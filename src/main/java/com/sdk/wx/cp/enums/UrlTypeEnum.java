package com.sdk.wx.cp.enums;

/**
 * url请求类别enum
 * @author yangtao
 * @date 2019/05/31
 */
public enum UrlTypeEnum {
	
	/**
	 * 不携带token的请求
	 */
	NONE_TOKEN,
	
	/**
	 * 携带企业微信授权token的请求
	 */
	ACCESS_TOKEN,
	
	/**
	 * 携带第三方应用token的请求
	 */
	SUITE_ACCESS_TOKEN,
	
	/**
	 * 携带服务商token的请求
	 */
	PROVIDER_ACCESS_TOKEN;
	
}
