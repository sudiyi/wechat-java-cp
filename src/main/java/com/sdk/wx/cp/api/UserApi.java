package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.BatchDeleteSend;
import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.InviteUserResult;
import com.sdk.wx.cp.bean.InviteUserSend;
import com.sdk.wx.cp.bean.OpenidToUseridResult;
import com.sdk.wx.cp.bean.OpenidToUseridSend;
import com.sdk.wx.cp.bean.UserInfo;
import com.sdk.wx.cp.bean.UserInfoResult;
import com.sdk.wx.cp.bean.UserListDetailResult;
import com.sdk.wx.cp.bean.UserSimpleListResult;
import com.sdk.wx.cp.bean.UseridToOpenidResult;
import com.sdk.wx.cp.bean.UseridToOpenidSend;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 成员管理模块接口
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90330
 * @author yangtao
 * @date 2019/05/28
 */
public interface UserApi {
	
	/**
	 * 创建成员接口地址
	 */
	public static final String CREATE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/create";

	/**
	 * 读取成员接口地址
	 */
	public static final String GET_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/get?userid=";

	/**
	 * 更新成员接口地址
	 */
	public static final String UPDATE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/update";

	/**
	 * 删除成员接口地址
	 */
	public static final String DELETE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?userid=";
	
	/**
	 * 批量删除成员接口地址
	 */
	public static final String BATCH_DELETE = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete";

	/**
	 * 获取部门成员接口地址
	 */
	public static final String SIMPLE_LIST = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist";
	
	/**
	 * 获取部门成员详情接口地址
	 */
	public static final String USER_DETAIL_LIST = "https://qyapi.weixin.qq.com/cgi-bin/user/list";
	
	/**
	 * userid换openID接口地址
	 */
	public static final String CONVERT_TO_OPENID = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid";

	/**
	 * openID换userid接口地址
	 */
	public static final String CONVERT_TO_USERID = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_userid";

	/**
	 * 二次验证接口地址
	 */
	public static final String AUTH_SUCC = "https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?userid=";
	
	/**
	 * 邀请成员接口地址
	 */
	public static final String INVITE_USER = "https://qyapi.weixin.qq.com/cgi-bin/batch/invite";

	/**
	 * <pre>
	 * 创建成员接口
	 * methods：POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90331
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param userInfo 成员信息
	 * @return 公共返回结果
	 * 
	 */
	CommonResult createUser(String suiteId, String corpId, UserInfo userInfo) throws WxErrorException;

	/**
	 * <pre>
	 * 读取成员接口
	 * methods：GET
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90332
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param userid 成员userid
	 * @return 成员信息
	 * 
	 */
	UserInfoResult getUser(String suiteId, String corpId, String userid) throws WxErrorException;

	/**
	 * <pre>
	 * 更新成员
	 * methods：POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90333
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param userInfo 成员信息
	 * @return 返回公共结果
	 */
	CommonResult updateUser(String suiteId, String corpId, UserInfo userInfo) throws WxErrorException;

	/**
	 * <pre>
	 * 删除成员
	 * methods：GET
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90334
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param userid 成员userid
	 * @return 公共结果
	 * 
	 */
	CommonResult deleteUser(String suiteId, String corpId, String userid) throws WxErrorException;

	/**
	 * <pre>
	 * 批量删除成员
	 * methods：POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90335
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param batchDeleteSend 批量删除ID集合
	 * @return 公共返回结果
	 */
	CommonResult batchDelete(String suiteId, String corpId, BatchDeleteSend batchDeleteSend) throws WxErrorException;

	/**
	 * <pre>
	 * 获取部门成员接口
	 * methods:GET
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90336
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param departmentId 	获取的部门id
	 * @param fetchChild 1/0：是否递归获取子部门下面的成员
	 * @return 成员信息集合
	 */
	UserSimpleListResult simpleList(String suiteId, String corpId, String departmentId ,String fetchChild) throws WxErrorException;

	/**
	 * <pre>
	 * 获取部门成员详情
	 * methods:GET
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90337
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param departmentId 	获取的部门id
	 * @param fetchChild 1/0：是否递归获取子部门下面的成员
	 * @return 成员详情信息集合
	 */
	UserListDetailResult userList(String suiteId, String corpId, String departmentId ,String fetchChild) throws WxErrorException;

	/**
	 * <pre>
	 * userid 换 openID接口
	 * methods：POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90338
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param toOpenId userid
	 * @return openID
	 */
	UseridToOpenidResult userIdOpenId(String suiteId, String corpId, UseridToOpenidSend toOpenId) throws WxErrorException;

	/**
	 * <pre>
	 * openid 换 userid接口
	 * methods：POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90338
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param toUserId openid 
	 * @return userid
	 * 
	 */
	OpenidToUseridResult openIdUserId(String suiteId, String corpId, OpenidToUseridSend toUserId) throws WxErrorException;

	/**
	 * <pre>
	 * 二次验证接口
	 * methods：GET
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90339
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param userid
	 * @return 公共返回结果
	 */
	CommonResult authsucc(String suiteId, String corpId, String userid) throws WxErrorException;

	/**
	 * <pre>
	 * 邀请成员（企业可通过接口批量邀请成员使用企业微信，邀请后将通过短信或邮件下发通知。）
	 * user, party, tag三者不能同时为空；
如果部分接收人无权限或不存在，邀请仍然执行，但会返回无效的部分（即invaliduser或invalidparty或invalidtag）;
非认证企业每天邀请人数不能超过1000, 认证企业每天邀请人数不能超过5000；
同一用户只须邀请一次，被邀请的用户如果未安装企业微信，在3天内每天会收到一次通知，最多持续3天。
因为邀请频率是异步检查的，所以调用接口返回成功，并不代表接收者一定能收到邀请消息（可能受上述频率限制无法接收）。
	 * methods：POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91127
	 * <pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param inviteSend 邀请信息集合
	 * @return 
	 */
	InviteUserResult inviteUser(String suiteId, String corpId, InviteUserSend inviteSend) throws WxErrorException;
}
