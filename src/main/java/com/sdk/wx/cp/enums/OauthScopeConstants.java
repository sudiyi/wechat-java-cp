package com.sdk.wx.cp.enums;

/**
 * oauth2授权，应用授权作用域
 * @author yangtao
 * @date 2019/06/04
 */
public class OauthScopeConstants {
	
	/**
	 * 静默授权，可获取成员的基础信息（UserId与DeviceId）
	 */
	public static final String SNSAPI_BASE = "snsapi_base";
	
	/**
	 * 静默授权，可获取成员的详细信息，但不包含手机、邮箱等敏感信息
	 */
	public static final String SNSAPI_USERINFO = "snsapi_userinfo";
	
	/**
	 * 手动授权，可获取成员的详细信息，包含手机、邮箱等敏感信息
	 */
	public static final String SNSAPI_PRIVATEINFO = "snsapi_privateinfo";

}
