package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.GetLoginInfoResult;
import com.sdk.wx.cp.bean.GetUserdetail3rdResult;
import com.sdk.wx.cp.bean.GetUserinfo3rdResult;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 身份认证模块-第三方应用开发
 * 企业微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91120
 * @author yangtao
 * @date 2019/05/27
 */
public interface Oauth2Api {
	
	/**
	 * 构造网页授权链接接口地址
	 */
	public static final String BUILDING_OAUTH2_ADD = "https://open.weixin.qq.com/connect/oauth2/authorize?";
	
	/**
	 * 获取访问用户身份接口地址
	 */
	public static final String GET_USERINFO_3RD = "https://qyapi.weixin.qq.com/cgi-bin/service/getuserinfo3rd?";

	/**
	 * 获取用户敏感信息接口地址
	 */
	public static final String GET_USERDETAIL_3RD = "https://qyapi.weixin.qq.com/cgi-bin/service/getuserdetail3rd";

	/**
	 * 获取登录用户信息接口地址
	 */
	public static final String GET_LOGIN_INFO = "https://qyapi.weixin.qq.com/cgi-bin/service/get_login_info";
	
	/**
	 * 构造oauth2授权的url链接（使用默认跳转地址、静默授权）
	 * @param state 重定向后会带上state参数，企业可以填写a-zA-Z0-9的参数值，长度不可超过128个字节（可选填）
	 * @param suiteId 第三方应用suiteId
	 * @return url
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91120
	 */
	String authorizationUrl(String suiteId, String state) throws WxErrorException;

	/**
	 * 构造oauth2授权的url链接（使用静默授权）
	 * @param suiteId 第三方应用suiteId
	 * @param redirectUri
	 * @param state 重定向后会带上state参数，企业可以填写a-zA-Z0-9的参数值，长度不可超过128个字节（可选填）
	 * @return url
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91120
	 */
	String authorizationUrl(String suiteId, String redirectUri, String state) throws WxErrorException;
	
	/**
	 * <pre>
	 * 构造oauth2授权的url链接
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91120
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param redirectUri
	 * @param state 重定向后会带上state参数，企业可以填写a-zA-Z0-9的参数值，长度不可超过128个字节（可选填）
	 * @param scope
	 * @return url
	 * 
	 */
	String authorizationUrl(String suiteId, String redirectUri, String state, String scope) throws WxErrorException;
	
	/**
	 * <pre>
	 * 获取访问用户身份
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91121
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param code 通过成员授权获取到的code，最大为512字节。每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
	 * @return 返回信息实体
	 * methods:GET
	 * 
	 */
	GetUserinfo3rdResult getUserinfo3rd(String suiteId, String code) throws WxErrorException;
	
	/**
	 * <pre>
	 * 获取访问用户敏感信息接口
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91122
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param userTicket 获取用户访问身份时，如果是snsapi_userinfo或snsapi_privateinfo时会返回
	 * @return 接口返回信息实体
	 * methods:POST
	 * 
	 */
	GetUserdetail3rdResult getUserdetail3rd(String suiteId, String userTicket) throws WxErrorException;
	
	/**
	 * <pre>
	 * 获取登录用户信息接口
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91125
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param authCode 接口请求参数实体
	 * @return 接口返回信息实体
	 * methods：POST
	 * 
	 */
	GetLoginInfoResult getLoginInfo(String suiteId, String authCode) throws WxErrorException;
}
