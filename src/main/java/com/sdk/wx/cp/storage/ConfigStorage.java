package com.sdk.wx.cp.storage;

import com.sdk.wx.cp.bean.GetPermanentCodeResult;
import com.sdk.wx.cp.storage.InMemoryConfigStorage.ConsumerStorage;
import com.sdk.wx.cp.storage.InMemoryConfigStorage.SuiteStorageInfo;

import me.chanjar.weixin.common.util.http.apache.ApacheHttpClientBuilder;

/**
 * token配置信息管理顶层接口
 * 可实现该接口，基于内存,db,redis等方式管理token。注意实际使用的时候时候token信息一定要做持久化
 * @author yangtao
 * @date 2019/05/28
 */
public interface ConfigStorage {
	
	/**
	 * 获取服务商的token
	 */
	String getProviderAccessToken();
	
	/**
	 * 更新服务商token（过期时间自动减200s）
	 */
	void updateProviderAccessToken(String providerAccessToken, int expireTime);
	
	/**
	 * 强制过期服务商token
	 */
	void expireProviderAccessToken();
	
	/**
	 * 服务商token是否过期
	 */
	boolean isPATExpire();
	
	/**
	 * 获取第三方应用的token
	 */
	String getSuiteAccessToken(String suiteId);
	
	/**
	 * 更新第三方应该token（过期时间自动减200s）
	 */
	void updateSuiteAccessToken(String suiteId,String suiteAccessToken, int expireTime);
	
	/**
	 * 强制过期第三方应用token
	 */
	void expireSuiteAccessToken(String suiteId);
	
	/**
	 * 第三方应用token是否过期
	 */
	boolean isSATExpire(String suiteId);
	
	/**
	 * 获取授权企业的token
	 */
	String getAccessToken(String suiteId, String corpId);
	
	/**
	 * 更新授权企业token（过期时间自动减200s）
	 */
	void updateAccessToken(String suiteId, String corpId,String accessToken, int expireTime);
	
	/**
	 * 强制过期授权企业token
	 */
	void expireAccessToken(String suiteId, String corpId);
	
	/**
	 * 授权企业token是否过期
	 */
	boolean isATExpire(String suiteId, String corpId);
	
	/**
	 * 获取授权企业微信storage完整信息
	 */
	ConsumerStorage getPermanentInfo(String suiteId, String corpId);
	
	/**
	 * 设置企业永久授权码
	 */
	void setPermanentCode(String suiteId, String corpId,GetPermanentCodeResult permanentResult);
	
	/**
	 * 获取应用token
	 */
	String getToken(String suiteId);

	/**
	 * 获取应用AES密钥
	 */
	String getAesKey(String suiteId);

	/**
	 * 获取服务商corpId
	 */
	String getCorpid();

	/**
	 * 获取服务商secret
	 */
	String getProviderSecret();
	
	/**
	 * 设置第三方应用ticket
	 */
	void setSuiteTicket(String suiteId,String suiteTicket);
	
	/**
	 * 获取应用ticket
	 * @param suiteId
	 */
	String getSuiteTicket(String suiteId);
	
	/**
	 * 获取第三方应用完整信息
	 * @param suiteId
	 * @return
	 */
	SuiteStorageInfo getSuiteStorage(String suiteId);

	
	/**
	 * 查询storage中是否已存在该企业的授权信息
	 * （不管是否过期，即是否曾经获取过永久授权码）
	 */
	boolean isAleadyAuth(String suiteId, String corpId);
	
	/**
	 * 获取素材管理临时文件生成地址
	 */
	String getMediaTempPath();
	
	ApacheHttpClientBuilder getApacheHttpClientBuilder();
	
	String getHttpProxyHost();

	int getHttpProxyPort();

	String getHttpProxyUsername();

	String getHttpProxyPassword();
}
