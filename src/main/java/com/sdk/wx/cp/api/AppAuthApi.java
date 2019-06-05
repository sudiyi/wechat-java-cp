package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.GetAdminListResult;
import com.sdk.wx.cp.bean.GetAuthInfoResult;
import com.sdk.wx.cp.bean.GetCallbackIpResult;
import com.sdk.wx.cp.bean.GetCorpTokenResult;
import com.sdk.wx.cp.bean.GetPermanentCodeResult;
import com.sdk.wx.cp.bean.GetPreAuthCodeResult;
import com.sdk.wx.cp.bean.GetProviderTokenResult;
import com.sdk.wx.cp.bean.GetSuiteTokenResult;
import com.sdk.wx.cp.bean.SetSessionInfoSend;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 应用授权-第三方应用开发
 * 企业微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90597
 * @author yangtao
 * @date 2019/05/27
 */
public interface AppAuthApi {
	
	/**
	 * 获取服务商凭证接口地址
	 */
	public static final String GET_PROVIDER_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/service/get_provider_token";
	
	/**
	 * 获取第三方应用凭证接口地址
	 */
	public static final String GET_SUITE_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/service/get_suite_token";
	
	/**
	 * 获取预授权码接口地址
	 */
	public static final String GET_PRE_AUTH_CODE = "https://qyapi.weixin.qq.com/cgi-bin/service/get_pre_auth_code";
	
	/**
	 * 授权配置接口地址
	 */
	public static final String SET_SESSION_INFO = "https://qyapi.weixin.qq.com/cgi-bin/service/set_session_info";
	
	/**
	 * 换取永久授权码接口地址
	 */
	public static final String GET_PERMANENT_CODE = "https://qyapi.weixin.qq.com/cgi-bin/service/get_permanent_code";
	
	/**
	 * 获取企业授权信息接口地址
	 */
	public static final String GET_AUTH_INFO = "https://qyapi.weixin.qq.com/cgi-bin/service/get_auth_info";
	
	/**
	 * 获取企业凭证接口地址
	 */
	public static final String GET_CORP_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/service/get_corp_token";
	
	/**
	 * 获取管理员列表接口地址
	 */
	public static final String GET_ADMIN_LIST = "https://qyapi.weixin.qq.com/cgi-bin/service/get_admin_list";
	
	/**
	 * 获取企业微信回调IP段
	 */
	public static final String GET_CALLBACK_IP = "https://qyapi.weixin.qq.com/cgi-bin/getcallbackip";

	/**
	 * <pre>
	 * 获取服务商凭证
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91200
	 * </pre>
	 * @return
	 * @throws WxErrorException
	 */
	GetProviderTokenResult getProviderToken() throws WxErrorException;
	
	/**
	 * <pre>
	 * 该API用于获取第三方应用凭证（suite_access_token）
	 * methods:POST
	 * 文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90600
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @return 获取第三方应用凭证返回实体
	 */
	GetSuiteTokenResult getSuiteToken(String suiteId) throws WxErrorException;
	
	/**
	 * <pre>
	 * 该API用于获取预授权码。预授权码用于企业授权时的第三方服务商安全验证。
	 * methods:GET
	 * 文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90601
	 * <pre>
	 * @param suiteId 第三方应用suiteId
	 * @return 获取预授权码返回实体
	 * 
	 */
	GetPreAuthCodeResult getPreAuthCode(String suiteId) throws WxErrorException;
	
	/**
	 * <pre>
	 * 该接口可对某次授权进行配置。可支持测试模式（应用未发布时）。
	 * methods:POST
	 * 文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90602
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param setSessionInfoSend 设置授权配置请求实体
	 * @return 设置授权配置返回实体
	 * 
	 */
	CommonResult setSessionInfo(String suiteId, SetSessionInfoSend setSessionInfoSend) throws WxErrorException;
	
	/**
	 * <pre>
	 * 该API用于使用临时授权码换取授权方的永久授权码，并换取授权信息、企业access_token，临时授权码一次有效。建议第三方以userid为主键，来建立自己的管理员账号。
	 * methods:POST
	 * 文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90603
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param authCode 授权回调事件中的授权码
	 * @return 获取企业永久授权码返回实体
	 */
	GetPermanentCodeResult getPermanentCode(String suiteId, String authCode) throws WxErrorException;
	
	/**
	 * <pre>
	 * 该API用于通过永久授权码换取企业微信的授权信息。 永久code的获取，是通过临时授权码使用get_permanent_code 接口获取到的permanent_code。
	 * methods：POST
	 * 文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90604
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权方corpId
	 * @return 获取企业授权信息返回实体
	 */
	GetAuthInfoResult getAuthInfo(String suiteId,String corpId) throws WxErrorException;
	
	/**
	 * <pre>
	 * 第三方服务商在取得企业的永久授权码后，通过此接口可以获取到企业的access_token。
	 * 获取后可通过通讯录、应用、消息等企业接口来运营这些应用。
	 * methods：POST
	 * 文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90605
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权方corpId
	 * @return 获取企业凭证返回实体
	 * 
	 */
	GetCorpTokenResult getCorpToken(String suiteId, String corpId) throws WxErrorException;
	
	/**
	 * <pre>
	 * 第三方服务商可以用此接口获取授权企业中某个第三方应用的管理员列表(不包括外部管理员)，以便服务商在用户进入应用主页之后根据是否管理员身份做权限的区分。
	 * methods：POST
	 * 文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90606
	 * <pre>
	 * @param suiteId 第三方应用suiteId
	 * @param getAdminListSend 获取应用管理员列表请求实体
	 * @return 获取应用管理员返回实体
	 */
	GetAdminListResult getAdminList(String suiteId, String corpId) throws WxErrorException;
	
	/**
	 * <pre>
	 * 获取企业微信服务器的ip段
	 * methods:GET
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91116
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @return
	 * @throws WxErrorException
	 */
	GetCallbackIpResult getCallbackIp(String suiteId, String corpId) throws WxErrorException;
}
