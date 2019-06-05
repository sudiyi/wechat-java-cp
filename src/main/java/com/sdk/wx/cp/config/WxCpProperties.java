package com.sdk.wx.cp.config;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

/**
 * 从配置文件加载的配置信息
 * @author yangtao
 * @date 2019/06/05
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "wechat.cp")
@Component
public class WxCpProperties {

	/**
	 * 服务商corpId
	 */
	private String corpId;
	
	/**
	 * 服务商密钥
	 */
	private String providerSecret;
	
	/**
	 * 服务商第三方应用信息
	 * 此处使用集合，是为了满足第三方服务商多个应用token共享需求。但企业微信官网并不建议这样做。
	 * 服务商应该尽量将服务集成到一个应用，如果确实有业务分割需求，也尽量独立运营
	 */
	private List<SuiteInfo> suiteInfo;
	
	@Getter
	@Setter
	public static class SuiteInfo{
		
		/**
		 * 第三方应用suiteId
		 */
		private String suiteId;
		
		/**
		 * 第三方应用secret
		 */
		private String suiteSecret;
		
		/**
		 * 第三方应用设置的AES密钥
		 */
		private String aeskey;
		
		/**
		 * 第三方应用设置的token
		 */
		private String token;
		
		/**
		 * 第三方应用，普通用户oauth2授权回调处理地址
		 */
		private String oauth2RedirectUri;
		
	}
	
}
