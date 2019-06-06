package com.sdk.wx.cp.api.impl;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.sdk.wx.cp.api.AppAuthApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.GetCorpTokenResult;
import com.sdk.wx.cp.bean.GetProviderTokenResult;
import com.sdk.wx.cp.bean.GetSuiteTokenResult;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.storage.ConfigStorage;
import com.sdk.wx.cp.util.GsonUtil;
import com.sdk.wx.cp.util.WxErrorUtil;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.DataUtils;
import me.chanjar.weixin.common.util.crypto.SHA1;
import me.chanjar.weixin.common.util.http.RequestExecutor;
import me.chanjar.weixin.common.util.http.RequestHttp;
import me.chanjar.weixin.common.util.http.SimpleGetRequestExecutor;
import me.chanjar.weixin.common.util.http.SimplePostRequestExecutor;

/**
 * SDK核心接口功能集成类
 * @author yangtao
 * @date 2019/05/28
 */
@Slf4j
public abstract class WechatCommonApiImpl<H,P> implements WechatCommonApi,RequestHttp<H, P>{
	
	/**
	 * 应用授权接口
	 */
	private AppAuthApi appAuth = new AppAuthApiImpl(this);
	
	/**
	 * token 持久化工具，根据init时传进来的具体实现选择不同的方式
	 */
	protected ConfigStorage configStorage;
	
	/**
	 * 微信服务器繁忙时，重试等待时间
	 */
	private int retrySleepMillis = 1000;
	
	/**
	 * 微信服务器繁忙时，重试次数
	 */
	private int maxRetryTimes = 5;
	
	/**
	 * 获取accessToken时，保证线程安全的锁
	 */
	private Object accessTokenLock = new Object();
	
	/**
	 * 获取providerAccessToken时，保证线程安全的锁
	 */
	private Object providerAccessTokenLock = new Object();
	
	/**
	 * 获取suiteAccessToken时，保证线程安全的锁
	 */
	private Object suiteAccessTokenLock = new Object();

	@Override
	public ConfigStorage getConfigStorage() {
		return this.configStorage;
	}

	@Override
	public void initStorage(ConfigStorage configStorage) {
		this.configStorage = configStorage;
		this.initHttp();
	}

	@Override
	public boolean checkSignature(String suiteId,String msgSignature, String timestamp, String nonce, String data) {
		try {
		      return SHA1.gen(this.configStorage.getToken(suiteId), timestamp, nonce, data)
		        .equals(msgSignature);
		    } catch (Exception e) {
		      log.error("Checking signature failed, and the reason is :" + e.getMessage());
		      return false;
		    }
	}

	@Override
	public void setRetrySleepMillis(int retrySleepMillis) {
		this.retrySleepMillis = retrySleepMillis;;
	}

	@Override
	public void setMaxRetryTimes(int maxRetryTimes) {
		this.maxRetryTimes = maxRetryTimes;
	}
	
	@Override
	public String get(String url,String queryParam) throws WxErrorException {
		return get(url, UrlTypeEnum.NONE_TOKEN,null, null, queryParam);
	}

	@Override
	public String post(String url, String postData) throws WxErrorException {
		return post(url, UrlTypeEnum.NONE_TOKEN,null, null, postData);
	}
	
	@Override
	public String get(String url,UrlTypeEnum urlType,String suiteId, String corpId, String queryParam) throws WxErrorException {
		return execute(SimpleGetRequestExecutor.create(this), url, suiteId, corpId, urlType, queryParam);
	}

	@Override
	public String post(String url,UrlTypeEnum urlType,String suiteId, String corpId, String postData) throws WxErrorException {
		return execute(SimplePostRequestExecutor.create(this), url,suiteId, corpId,urlType, postData);
	}
	
	@Override
	public <T, E> T execute(RequestExecutor<T, E> executor, String uri,String suiteId, String corpId, UrlTypeEnum uriType, E data) throws WxErrorException {
	    int retryTimes = 0;
	    do {
	      try {
	        return this.executeInternal(executor, uri, suiteId, corpId, uriType, data);
	      } catch (WxErrorException e) {
	        if (retryTimes + 1 > this.maxRetryTimes) {
	          log.warn("重试达到最大次数【{}】", this.maxRetryTimes);
	          //最后一次重试失败后，直接抛出异常，不再等待
	          throw new RuntimeException("微信服务端异常，超出重试次数");
	        }

	        WxError error = e.getError();
	        /*
	         * -1 系统繁忙, 等待时间：（retrySleepMillis(ms) * 2^(重试次数 - 1)）
	         */
	        if (error.getErrorCode() == -1) {
	          int sleepMillis = this.retrySleepMillis * (1 << retryTimes);
	          try {
	            log.debug("微信系统繁忙，{} ms 后重试(第{}次)", sleepMillis, retryTimes + 1);
	            Thread.sleep(sleepMillis);
	          } catch (InterruptedException e1) {
	            Thread.currentThread().interrupt();
	          }
	        } else {
	          throw e;
	        }
	      }
	    } while (retryTimes++ < this.maxRetryTimes);

	    log.warn("重试达到最大次数【{}】", this.maxRetryTimes);
	    throw new RuntimeException("微信服务端异常，超出重试次数");
	}
	
	/**
	 * 执行请求,token过期会重试
	 * @param executor
	 * @param uri
	 * @param corpId
	 * @param uriType
	 * @param data
	 * @return
	 * @throws WxErrorException
	 */
	protected <T, E> T executeInternal(RequestExecutor<T, E> executor,String uri,String suiteId,String corpId,UrlTypeEnum uriType, E data) throws WxErrorException {
	    E dataForLog = DataUtils.handleDataWithSecret(data);
	    
	    //为不同类型url拼接token信息
	    String uriWithAccessToken = dealUrl(uri,suiteId, corpId, uriType);
	    log.info("\n【请求地址】: {}\n【请求参数】：{}", uriWithAccessToken, dataForLog);
	    try {
	      T result = executor.execute(uriWithAccessToken, data);
	      log.info("\n【响应数据】：{}", result);
	      return result;
	    } catch (WxErrorException e) {
	      WxError error = e.getError();
	      /*
	       * 发生以下情况时尝试刷新access_token
	       * 40001 获取access_token时AppSecret错误，或者access_token无效
	       * 42001 access_token超时
	       * 40014 不合法的access_token，请开发者认真比对access_token的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口
	       * 42009 suite_access_token已过期	suite_access_token有时效性，需要重新获取一次
	       */
	      if (error.getErrorCode() == 42001 || error.getErrorCode() == 40001 || error.getErrorCode() == 40014 || error.getErrorCode() == 42009) {
	        
	    	/*
	    	 * 此处因企业微信文档并没有对三种token过期的状态，分别说清楚，所以如果遇到代表token过期的错误码，即将所有类型的token过期
	    	 * 上面的错误也可能并没有将过期情况完全囊括，后续使用sdk时如果确定有遗漏情况，请在此处加上 
	    	 * 如果已经确定分别过期的状态码，请根据返回分别做强制过期处理
	    	 */
	    	log.info("accessToken过期："+GsonUtil.create().toJson(error));
	        this.configStorage.expireAccessToken(suiteId, corpId);
	        this.configStorage.expireProviderAccessToken();
	        this.configStorage.expireSuiteAccessToken(suiteId);
	        return execute(executor, uri,corpId,uriType, data);
	      }

	      if (error.getErrorCode() != 0) {
	        String errorMsg = WxErrorUtil.getErrorMsg(error.getErrorCode());
	        if(StringUtils.isNotBlank(errorMsg)){
	        	error.setErrorMsg(errorMsg);
	        }
	        log.error("\n【请求地址】: {}\n【请求参数】：{}\n【错误码】：{}\n【错误信息】：{}", uriWithAccessToken, dataForLog,error.getErrorCode(), error.getErrorMsg());
	        throw new WxErrorException(error, e);
	      }
	      return null;
	    } catch (IOException e) {
	      log.error("\n【请求地址】: {}\n【请求参数】：{}\n【异常信息】：{}", uriWithAccessToken, dataForLog, e.getMessage());
	      throw new RuntimeException(e);
	    }
	}
	
	/**
	 * 根据不同url token携带类型，拼接对应的url
	 * @param url
	 * @param corpId
	 * @param urlType
	 * @return
	 * @throws WxErrorException
	 */
	protected String dealUrl(String url,String suiteId, String corpId,UrlTypeEnum urlType) throws WxErrorException{
		switch(urlType){
			case NONE_TOKEN:
				return url;
			case ACCESS_TOKEN:
				return url + (url.contains("?") ? "&" : "?") + "access_token=" + getAccessToken(suiteId, corpId);
			case SUITE_ACCESS_TOKEN:
				return url + (url.contains("?") ? "&" : "?") + "suite_access_token=" + getSuiteAccessToken(suiteId);
			case PROVIDER_ACCESS_TOKEN:
				return url + (url.contains("?") ? "&" : "?") + "provider_access_token=" + getProviderAccessToken();
		default:
			return url;
		}
	}
	
	
	
	
	@Override
	public String get(String url, UrlTypeEnum urlType, String accessToken, String queryParam) throws WxErrorException {
		return execute(SimpleGetRequestExecutor.create(this), url, accessToken, urlType, queryParam);
	}

	@Override
	public String post(String url, UrlTypeEnum urlType, String accessToken, String postData) throws WxErrorException {
		return execute(SimplePostRequestExecutor.create(this), url, accessToken, urlType, postData);
	}

	@Override
	public <T, E> T execute(RequestExecutor<T, E> executor, String uri, String accessToken, UrlTypeEnum uriType, E data)
			throws WxErrorException {
		return executeInternal(executor, uri, accessToken, uriType, data);
	}
	
	/**
	 * 自定义accessToken执行
	 * @param executor
	 * @param uri
	 * @param accessToken
	 * @param uriType
	 * @param data
	 * @return
	 * @throws WxErrorException
	 */
	protected <T, E> T executeInternal(RequestExecutor<T, E> executor,String uri,String accessToken,UrlTypeEnum uriType, E data) throws WxErrorException {
		E dataForLog = DataUtils.handleDataWithSecret(data);
		String uriWithAccessToken = dealUrl(uri,accessToken, uriType);
		try {
			log.info("\n【请求地址】: {}\n【请求参数】：{}", uriWithAccessToken, dataForLog);
			T result = executor.execute(uriWithAccessToken, data);
			log.info("\n【响应数据】：{}", result);
			return result;
		} catch (WxErrorException e) {
			WxError error = e.getError();
			if (error.getErrorCode() != 0) {
		       String errorMsg = WxErrorUtil.getErrorMsg(error.getErrorCode());
		       if(StringUtils.isNotBlank(errorMsg)){
		    	   error.setErrorMsg(errorMsg);
		       }
		       log.error("\n【请求地址】: {}\n【请求参数】：{}\n【错误码】：{}\n【错误信息】：{}", uriWithAccessToken, dataForLog,error.getErrorCode(), error.getErrorMsg());
		       throw new WxErrorException(error, e);
		    }
		    return null;
		} catch (Exception e) {
			log.error("\n【请求地址】: {}\n【请求参数】：{}\n【异常信息】：{}", uriWithAccessToken, data, e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据自定义accessToken拼接url
	 * @param url
	 * @param accessToken
	 * @param urlType
	 * @return
	 * @throws WxErrorException
	 */
	protected String dealUrl(String url,String accessToken,UrlTypeEnum urlType) throws WxErrorException{
		switch(urlType){
			case NONE_TOKEN:
				return url;
			case ACCESS_TOKEN:
				return url + (url.contains("?") ? "&" : "?") + "access_token=" + accessToken;
			case SUITE_ACCESS_TOKEN:
				return url + (url.contains("?") ? "&" : "?") + "suite_access_token=" + accessToken;
			case PROVIDER_ACCESS_TOKEN:
				return url + (url.contains("?") ? "&" : "?") + "provider_access_token=" + accessToken;
		default:
			return url;
		}
	}

	@Override
	public RequestHttp<?, ?> getRequestHttp() {
		return this;
	}

	@Override
	public String getAccessToken(String suiteId, String corpId)  throws WxErrorException {
		return this.getAccessToken(suiteId, corpId,Boolean.FALSE);
	}

	@Override
	public String getAccessToken(String suiteId, String corpId, boolean forceRefresh) throws WxErrorException {
		
		//无效的corpId
		if(!this.configStorage.isAleadyAuth(suiteId, corpId)){
			new RuntimeException("无效的corpId，该企业微信并未在应用授权");
		}
		//如果accessToken有效并且不强制刷新，直接获取
		if(!this.configStorage.isATExpire(suiteId, corpId) && !forceRefresh){
			return this.configStorage.getAccessToken(suiteId, corpId);
		}
		//重新获取accessToken同步块
		synchronized (this.accessTokenLock) {
			GetCorpTokenResult corpToken = appAuth.getCorpToken(suiteId, corpId);
			//更新accessToken
			this.configStorage.updateAccessToken(suiteId, corpId, corpToken.getAccessToken(), Integer.valueOf(corpToken.getExpiresIn()));
		}
		return this.configStorage.getAccessToken(suiteId, corpId);
	}

	@Override
	public String getProviderAccessToken() throws WxErrorException{
		return this.getProviderAccessToken(Boolean.FALSE);
	}

	@Override
	public String getProviderAccessToken(boolean forceRefresh) throws WxErrorException {
		
		//token未过期，并且不强制刷新
		if(!this.configStorage.isPATExpire() && !forceRefresh){
			return this.configStorage.getProviderAccessToken();
		}
		//重新获取providerAccessToken同步块
		synchronized (this.providerAccessTokenLock) {
			GetProviderTokenResult providerToken = appAuth.getProviderToken();
			//更新providerAccesstoken
			this.configStorage.updateProviderAccessToken(providerToken.getProviderAccessToken(), Integer.valueOf(providerToken.getExpiresIn()));
		}
		return this.configStorage.getProviderAccessToken();
	}

	@Override
	public String getSuiteAccessToken(String suiteId) throws WxErrorException{
		return this.getSuiteAccessToken(suiteId, Boolean.FALSE);
	}

	@Override
	public String getSuiteAccessToken(String suiteId,boolean forceRefrech) throws WxErrorException{

		//如果suiteAccessToken没过期，并且不强制刷新，直接返回
		if(!this.configStorage.isSATExpire(suiteId) && !forceRefrech){
			return this.configStorage.getSuiteAccessToken(suiteId);
		}
		//重新获取
		synchronized (this.suiteAccessTokenLock) {
			GetSuiteTokenResult suiteToken = appAuth.getSuiteToken(suiteId);
			//更新suiteAccessToken
			this.configStorage.updateSuiteAccessToken(suiteId, suiteToken.getSuiteAccessToken(), Integer.valueOf(suiteToken.getExpiresIn()));
		}
		return this.configStorage.getSuiteAccessToken(suiteId);
	}
}
