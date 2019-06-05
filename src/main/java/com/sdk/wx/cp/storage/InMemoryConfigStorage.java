package com.sdk.wx.cp.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sdk.wx.cp.bean.GetPermanentCodeResult;
import com.sdk.wx.cp.config.WxCpProperties;
import com.sdk.wx.cp.config.WxCpProperties.SuiteInfo;
import com.sdk.wx.cp.util.GsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.util.http.apache.ApacheHttpClientBuilder;

/**
 * 基于内存的 token 及配置信息管理器
 * @author yangtao
 * @date 2019/05/28
 */
@Component
@Slf4j
public class InMemoryConfigStorage implements ConfigStorage{
	
	@Autowired
	private WxCpProperties properties;
	
	//******初始配置信息******
	/**
	 * 服务商的企业微信ID
	 */
	private String corpid;
	
	/**
	 * 服务商的密钥
	 */
	private String providerSecret;
	
	/**
	 * 第三方应用配置信息
	 * key:suiteId
	 * value:第三方应用完整信息
	 */
	private ConcurrentHashMap<String, SuiteStorageInfo> suiteStorageInfo = new ConcurrentHashMap<String, InMemoryConfigStorage.SuiteStorageInfo>();
	
	
	//******api调用过程token数据******
	
	/**
	 * 服务商accessToken
	 */
	private volatile String providerAccessToken;
	
	/**
	 * 服务商accessToken过期时间
	 */
	private volatile long providerAccessTokenExpiresTime;
	
	private volatile ApacheHttpClientBuilder apacheHttpClientBuilder;
	protected volatile String httpProxyHost;
	protected volatile int httpProxyPort;
	protected volatile String httpProxyUsername;
	protected volatile String httpProxyPassword;
	
	
	/**
	 * 第三方应用初始化信息+token信息
	 * @author yangtao
	 * @date 2019/06/05
	 */
	@Getter
	@Setter
	public class SuiteStorageInfo{
		
		/**
		 * 第三方应用suiteId
		 */
		private String suiteId;
		
		/**
		 * 第三方应用secret
		 */
		private String suiteSecret;
		
		/**
		 * 第三方应用AES密钥
		 */
		private String aeskey;
		
		/**
		 * 第三方应用token
		 */
		private String token;
		
		/**
		 * 第三方应用凭证
		 */
		private volatile String suiteAccessToken;
		
		/**
		 * 第三方应用凭证过期时间
		 */
		private volatile long suiteAccessTokenExpiresTime;
		
		/**
		 * 第三方应用设置的普通用户oauth2授权回调地址（根据开发时实际地址写入配置文件）
		 */
		private String oauth2RedirectUri;
		
		/**
		 * 企业微信定时推送ticket，用于获取第三方应用凭证
		 * 企业微信每十分钟推送一次，有效期三十分钟，也可在服务商后台手动刷新ticket（手动推送）
		 * 需保证每次使用都是最新的ticket
		 */
		private String suiteTicket;
		
		/**
		 * 授权第三方应用的企业微信授权信息
		 * key:授权企业微信corpId
		 * value:授权信息
		 */
		private Map<String, ConsumerStorage> consumerStorage;
		
		/**
		 * 更新suiteAccessToken
		 * @param suiteAccessToken
		 * @param expiresTime
		 */
		public void updateSuiteAccessToken(String suiteAccessToken, long expiresTime){
			this.suiteAccessToken = suiteAccessToken;
			this.suiteAccessTokenExpiresTime = System.currentTimeMillis() + (expiresTime - 200) * 1000L;
		}
	}
	
	/**
	 * 第三方应用授权用户信息
	 * @author yangtao
	 * @date 2019/05/30
	 */
	@Getter
	@Setter
	public class ConsumerStorage{
		
		/**
		 * 第三方应用访问企业微信的accessToken
		 */
		private String accessToken;
		
		/**
		 * 永久授权码
		 */
		private String permanentCode;
		
		/**
		 * 企业微信corpId
		 */
		private String corpId;
		
		/**
		 * 企业微信accessToken过期时间
		 */
		private long accessTokenExpiresTime;
		
		/**
		 * 第三方应用在授权企业微信方的应用id
		 */
		private String agentId;
		
		/**
		 * 更新授权企业微信token信息
		 */
		public void updateAccessToken(String accessToken, long expiresTime){
			this.accessToken = accessToken;
			this.accessTokenExpiresTime = System.currentTimeMillis() + (expiresTime - 200) * 1000L;
		}
		
		/**
		 * 企业微信用户授权时，记录永久授权码信息
		 */
		public void updatePermanentCode(String agentId,String accessToken,int expiresTime, String permanentCode, String corpId){
			this.accessToken = accessToken;
			this.accessTokenExpiresTime = System.currentTimeMillis() + (expiresTime - 200) * 1000L;
			this.agentId = agentId;
			this.corpId = corpId;
			this.permanentCode = permanentCode;
		}

	}

	@Override
	public String getProviderAccessToken() {
		return this.providerAccessToken;
	}

	@Override
	public synchronized void updateProviderAccessToken(String providerAccessToken, int expireTime) {
		this.providerAccessToken = providerAccessToken;
		this.providerAccessTokenExpiresTime = System.currentTimeMillis() + (expireTime - 200) * 1000L;
	}

	@Override
	public synchronized void expireProviderAccessToken() {
		this.providerAccessTokenExpiresTime = 0;		
	}

	@Override
	public boolean isPATExpire() {
		return System.currentTimeMillis() > this.providerAccessTokenExpiresTime;
	}

	@Override
	public String getSuiteAccessToken(String suiteId) {
		return this.suiteStorageInfo.get(suiteId).getSuiteAccessToken();
	}

	@Override
	public void updateSuiteAccessToken(String suiteId, String suiteAccessToken, int expireTime) {
		this.suiteStorageInfo.get(suiteId).updateSuiteAccessToken(suiteAccessToken, expireTime);
	}

	@Override
	public void expireSuiteAccessToken(String suiteId) {
		this.suiteStorageInfo.get(suiteId).setSuiteAccessTokenExpiresTime(0);
	}

	@Override
	public boolean isSATExpire(String suiteId) {
		return System.currentTimeMillis() > this.suiteStorageInfo.get(suiteId).getSuiteAccessTokenExpiresTime();
	}

	@Override
	public String getAccessToken(String suiteId, String corpId) {
		return this.suiteStorageInfo.get(suiteId).getConsumerStorage().get(corpId).getAccessToken();
	}

	@Override
	public void updateAccessToken(String suiteId, String corpId, String accessToken, int expireTime) {
		this.suiteStorageInfo.get(suiteId).getConsumerStorage().get(corpId).updateAccessToken(accessToken, expireTime);
	}

	@Override
	public void expireAccessToken(String suiteId, String corpId) {
		this.suiteStorageInfo.get(suiteId).getConsumerStorage().get(corpId).setAccessTokenExpiresTime(0);
	}

	@Override
	public boolean isATExpire(String suiteId, String corpId) {
		return System.currentTimeMillis() > this.suiteStorageInfo.get(suiteId).getConsumerStorage().get(corpId).getAccessTokenExpiresTime();
	}

	@Override
	public ConsumerStorage getPermanentInfo(String suiteId, String corpId) {
		return this.suiteStorageInfo.get(suiteId).getConsumerStorage().get(corpId);
	}

	@Override
	public void setPermanentCode(String suiteId, String corpId, GetPermanentCodeResult permanentResult) {
		ConsumerStorage conStorage = new ConsumerStorage();
		conStorage.setAccessToken(permanentResult.getAccessToken());
		conStorage.setAccessTokenExpiresTime(System.currentTimeMillis() + (Integer.valueOf(permanentResult.getExpiresIn()) - 200) * 1000L);
		conStorage.setAgentId(permanentResult.getAuthInfo().getAgent().get(0).getAgentid());
		conStorage.setCorpId(corpId);
		conStorage.setPermanentCode(permanentResult.getPermanentCode());
		this.suiteStorageInfo.get(suiteId).getConsumerStorage().put(corpId, conStorage);
	}

	@Override
	public String getToken(String suiteId) {
		return this.suiteStorageInfo.get(suiteId).getToken();
	}

	@Override
	public String getAesKey(String suiteId) {
		return this.suiteStorageInfo.get(suiteId).getAeskey();
	}

	@Override
	public String getCorpid() {
		return this.corpid;
	}

	@Override
	public String getProviderSecret() {
		return this.providerSecret;
	}

	@Override
	public void setSuiteTicket(String suiteId, String suiteTicket) {
		this.suiteStorageInfo.get(suiteId).setSuiteTicket(suiteTicket);
	}

	@Override
	public boolean isAleadyAuth(String suiteId, String corpId) {
		return this.suiteStorageInfo.get(suiteId).getConsumerStorage().containsKey(corpId);
	}

	@PostConstruct
	public void init(){
		if(StringUtils.isAnyBlank(properties.getCorpId(),properties.getProviderSecret())){
			throw new RuntimeException("内存token管理器初始化失败，服务商信息为空");
		}
		this.corpid = properties.getCorpId();
		this.providerSecret = properties.getProviderSecret();
		if(properties.getSuiteInfo() == null || properties.getSuiteInfo().size() <= 0){
			throw new RuntimeException("内存token管理器初始化失败，未找到第三方应用初始配置信息");
		}
		for(SuiteInfo suiteInfo : properties.getSuiteInfo()){
			SuiteStorageInfo suiteStorage = new SuiteStorageInfo();
			suiteStorage.setAeskey(suiteInfo.getAeskey());
			suiteStorage.setOauth2RedirectUri(suiteInfo.getOauth2RedirectUri());
			suiteStorage.setSuiteId(suiteInfo.getSuiteId());
			suiteStorage.setSuiteSecret(suiteInfo.getSuiteSecret());
			suiteStorage.setToken(suiteInfo.getToken());
			this.suiteStorageInfo.put(suiteInfo.getSuiteId(), suiteStorage);
		}
		log.info("内存token管理器初始化完成，【服务商id】：{}\n【服务商密钥】：{}\n【第三方应用信息】：{}\n",this.corpid,this.providerSecret,GsonUtil.create().toJson(this.suiteStorageInfo));
	}

	@Override
	public ApacheHttpClientBuilder getApacheHttpClientBuilder() {
	  return this.apacheHttpClientBuilder;
	}

	public void setApacheHttpClientBuilder(ApacheHttpClientBuilder apacheHttpClientBuilder) {
	  this.apacheHttpClientBuilder = apacheHttpClientBuilder;
	}
	
	@Override
	public String getHttpProxyHost() {
		return this.httpProxyHost;
	}

	@Override
	public int getHttpProxyPort() {
		return this.httpProxyPort;
	}

	@Override
	public String getHttpProxyUsername() {
		return this.httpProxyUsername;
	}

	@Override
	public String getHttpProxyPassword() {
		return this.httpProxyPassword;
	}

	@Override
	public String getSuiteTicket(String suiteId) {
		return this.suiteStorageInfo.get(suiteId).getSuiteTicket();
	}

	@Override
	public SuiteStorageInfo getSuiteStorage(String suiteId) {
		return this.suiteStorageInfo.get(suiteId);
	}
}
