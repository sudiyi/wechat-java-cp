package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.GetRegisterCodeResult;
import com.sdk.wx.cp.bean.GetRegisterCodeSend;
import com.sdk.wx.cp.bean.GetRegisterInfoResult;
import com.sdk.wx.cp.bean.SetScopeResult;
import com.sdk.wx.cp.bean.SetScopeSend;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 推广二维码模块
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90578
 * @author yangtao
 * @date 2019/05/27
 */
public interface SpreadCodeApi {

	/**
	 * 获取注册码接口地址
	 */
	public static final String GET_REGISTER_CODE = "https://qyapi.weixin.qq.com/cgi-bin/service/get_register_code";
	
	/**
	 * 查询注册状态接口地址
	 */
	public static final String GET_REGISTER_INFO = "https://qyapi.weixin.qq.com/cgi-bin/service/get_register_info";

	/**
	 * 设置授权应用可见范围接口地址
	 */
	public static final String SET_SCOPE = "https://qyapi.weixin.qq.com/cgi-bin/agent/set_scope";

	/**
	 * 设置通讯录同步完成接口地址
	 */
	public static final String CONTACT_SYNC_SUCCESS = "https://qyapi.weixin.qq.com/cgi-bin/sync/contact_sync_success";

	/**
	 * <pre>
	 * 获取注册码接口
	 * methods:POST
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90581
	 * </pre>
	 * @param getRegisterCodeSend 参数实体
	 * @return 返回信息实体
	 * 
	 */
	GetRegisterCodeResult getRegisterCode(GetRegisterCodeSend getRegisterCodeSend) throws WxErrorException;

	/**
	 * <pre>
	 * 查询注册状态
	 * methods:POST
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90582
	 * </pre>
	 * @param registerCode 获取注册码接口返回信息
	 * @return 返回信息实体
	 * 
	 */
	GetRegisterInfoResult getRegisterInfo(String registerCode) throws WxErrorException;

	/**
	 * <pre>
	 * 设置授权应用可见范围
	 * methods:GET
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90583
	 * </pre>
	 * @param accessToken 查询注册状态返回的accessToken
	 * @param corpId 企业微信授权corpId
	 * @param setScopeSend 参数实体
	 * @return 返回信息实体
	 * 
	 */
	SetScopeResult setScope(String accessToken,String corpId, SetScopeSend setScopeSend) throws WxErrorException;

	/**
	 * <pre>
	 * 设置通讯录同步完成
	 * methods:GET
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90584
	 * </pre>
	 * @param accessToken 查询注册状态返回的accessToken
	 * @return 返回信息实体
	 */
	CommonResult contactSyncSuccess(String accessToken) throws WxErrorException;
}
