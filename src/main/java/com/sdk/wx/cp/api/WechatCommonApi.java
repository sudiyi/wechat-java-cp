package com.sdk.wx.cp.api;

import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.storage.ConfigStorage;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.RequestExecutor;
import me.chanjar.weixin.common.util.http.RequestHttp;

/**
 * 公共执行方法、accessToken 管理
 * @author yangtao
 * @date 2019/05/28
 */
public interface WechatCommonApi {
	
	/**
	 * 公共的GET请求方法
	 * @param url 请求地址
	 * @param queryParam 请求参数
	 * @return 返回结果
	 */
	public String get(String url, String queryParam) throws WxErrorException;
	
	/**
	 * 公共的GET请求方法
	 * @param url 请求地址
	 * @param suiteId 第三方应用suiteId
	 * @param corpId  授权企业微信corpId
	 * @param urlType 请求地址携带token类型
	 * @param corpId 授权的企业微信id(调用授权企业微信相关接口时才会用到)
	 * @param queryParam 请求参数
	 * @return 返回结果
	 */
	public String get(String url,UrlTypeEnum urlType,String suiteId, String corpId, String queryParam) throws WxErrorException;
	
	/**
	 * 公共的GET请求方法，支持传入token
	 * @param url
	 * @param urlType
	 * @param accessToken
	 * @param queryParam
	 * @return
	 * @throws WxErrorException
	 */
	public String get(String url,UrlTypeEnum urlType,String accessToken,String queryParam) throws WxErrorException;

	/**
	 * 公共的POST请求方法
	 * @param url 请求地址
	 * @param postData 请求参数
	 * @return 
	 */
	public String post(String url,String postData) throws WxErrorException;
	
	/**
	 * 公共的POST请求方法
	 * @param url 
	 * @param urlType 请求地址携带的token类型
	 * @param suiteId 第三方应用suiteId
	 * @param corpId  授权企业微信corpId
	 * @param corpId 授权的企业微信ID(调用授权企业微信相关接口时才会用到)
	 * @param postData
	 * @return
	 * @throws WxErrorException
	 */
	public String post(String url,UrlTypeEnum urlType, String suiteId, String corpId, String postData) throws WxErrorException;


	/**
	 * 公共的POST请求方法，支持传入token
	 * @param url
	 * @param urlType
	 * @param accessToken
	 * @param postData
	 * @return
	 * @throws WxErrorException
	 */
	public String post(String url,UrlTypeEnum urlType,String accessToken,String postData) throws WxErrorException;
	
	/**
	 * 获取token管理器
	 * @return
	 */
	public ConfigStorage getConfigStorage();
	
	/**
	 * 获取授权token,不强制刷新
	 * @param corpId
	 * @return
	 */
	public String getAccessToken(String suiteId,String corpId) throws WxErrorException ;
	
	/**
	 * 获取授权token，支持强制刷新，该方法会向微信服务器
	 * 请求新的accessToken，线程安全
	 * @param corpId 
	 * @param forceRefresh true:强制刷新
	 * @return
	 */
	public String getAccessToken(String suiteId, String corpId,boolean forceRefresh) throws WxErrorException ;
	
	/**
	 * 获取服务商token,不强制刷新
	 * @return
	 */
	public String getProviderAccessToken() throws WxErrorException;
	
	/**
	 * 获取服务商token，支持强制刷新，该方法会向微信服务器
	 * 请求获取新的服务商accessToken,线程安全
	 * @param forceRefresh true:强制刷新
	 * @return 
	 */
	public String getProviderAccessToken(boolean forceRefresh) throws WxErrorException;
	
	/**
	 * 获取应用token,不强制刷新
	 * @return
	 */
	public String getSuiteAccessToken(String suiteId) throws WxErrorException;
	
	/**
	 * 获取应用accessToken，支持强制刷新，该方法会向微信服务器
	 * 请求获取应用的accessToken，线程安全
	 * @param forceRefrech true:强制刷新
	 * @return
	 */
	public String getSuiteAccessToken(String suiteId, boolean forceRefrech) throws WxErrorException;
	
	/**
	 * 初始化token管理器
	 * @param configStorage
	 */
	public void initStorage(ConfigStorage configStorage);
	
	/**
	 * HTTP Get URL请求校验
	 * @param suiteId
	 * @param msgSignature
	 * @param timestamp
	 * @param nonce
	 * @param data
	 * @return
	 */
	public boolean checkSignature(String suiteId, String msgSignature, String timestamp, String nonce, String data);

	/**
	 * 设置当微信系统响应系统繁忙时，要等待多少 retrySleepMillis(ms) * 2^(重试次数 - 1) 再发起重试
	 * 默认：1000ms
	 * @param retrySleepMillis 重试休息时间
	 */
	void setRetrySleepMillis(int retrySleepMillis);
	
	
	/**
	 * 设置当微信系统响应系统繁忙时，最大重试次数
	 * 默认：5次
	 * @param maxRetryTimes
	 */
	void setMaxRetryTimes(int maxRetryTimes);
	
	/**
	   * <pre>
	   * Service没有实现某个API的时候，可以用这个，
	   * 比{@link #get}和{@link #post}方法更灵活，可以自己构造RequestExecutor用来处理不同的参数和不同的返回类型。
	   * token过期有重试机制
	   * </pre>
	   *
	   * @param executor 执行器
	   * @param uri      请求地址
	   * @param suiteId  服务商应用suiteId,考虑到一个服务商多个应用的情况
	   * @param corpId   授权的企业微信ID(调用授权企业微信相关接口时才会用到)
	   * @param uriType  请求地址携带token类型
	   * @param data     参数
	   * @param <T>      请求值类型
	   * @param <E>      返回值类型
	   */
	<T, E> T execute(RequestExecutor<T, E> executor, String uri,String suiteId, String corpId, UrlTypeEnum uriType, E data) throws WxErrorException;
	
	/**
	   * <pre>
	   * Service没有实现某个API的时候，可以用这个，
	   * 比{@link #get}和{@link #post}方法更灵活，可以自己构造RequestExecutor用来处理不同的参数和不同的返回类型。
	   * 自定义token传入，token过期直接返回
	   * </pre>
	   *
	   * @param executor 执行器
	   * @param uri      请求地址
	   * @param accessToken 因为第三方应该accessToken情景多样化，故支持外来token传入，由于不知道该token的业务规则，所以收到token无效或过期的结果，不会重试
	   * @param uriType   授权的企业微信ID(调用授权企业微信相关接口时才会用到)
	   * @param data     参数
	   * @param <T>      请求值类型
	   * @param <E>      返回值类型
	   */
	<T, E> T execute(RequestExecutor<T, E> executor, String uri,String accessToken,UrlTypeEnum uriType, E data) throws WxErrorException;
	
	/**
	 * http请求对象
	 */
	RequestHttp<?, ?> getRequestHttp();
	
	/**
	 * 初始化http请求对象
	 */
    void initHttp();
}
