package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.AddContactWayResult;
import com.sdk.wx.cp.bean.AddContactWaySend;
import com.sdk.wx.cp.bean.AddMsgTemplateResult;
import com.sdk.wx.cp.bean.AddMsgTemplateSend;
import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.GetContactWayResult;
import com.sdk.wx.cp.bean.GetContactWaySend;
import com.sdk.wx.cp.bean.GetExternalContactResult;
import com.sdk.wx.cp.bean.GetExternalListResult;
import com.sdk.wx.cp.bean.GetFollowUserListResult;
import com.sdk.wx.cp.bean.GetGroupMsgResult;
import com.sdk.wx.cp.bean.GetGroupMsgSend;
import com.sdk.wx.cp.bean.GetUnassignedListResult;
import com.sdk.wx.cp.bean.GetUnassignedListSend;
import com.sdk.wx.cp.bean.GetUserBehaviorResult;
import com.sdk.wx.cp.bean.GetUserBehaviorSend;
import com.sdk.wx.cp.bean.UnassignTransferSend;
import com.sdk.wx.cp.bean.UpdateContactWaySend;

import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 外部联系人管理模块
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90357
 * @author yangtao
 * @date 2019/05/28
 */
public interface ExternalContactApi {

	/**
	 * 获取配置了客户联系功能的成员列表接口地址
	 */
	public static final String GET_FOLLOW_USER_LIST = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get_follow_user_list";

	/**
	 * 获取外部联系人列表接口地址
	 */
	public static final String EXTERNAL_CONTACT = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/list";
	
	/**
	 * 获取外部联系人详情接口地址
	 */
	public static final String EXTERBAK_CONTACT_DETAIL = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get";
	
	/**
	 * 配置客户联系「联系我」方式接口地址
	 */
	public static final String ADD_CONTACT_WAY = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/add_contact_way";
	
	/**
	 * 获取企业已配置的「联系我」方式接口地址
	 */
	public static final String GET_CONTACT_WAY = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get_contact_way";
	
	/**
	 * 更新企业已配置的「联系我」方式接口地址
	 */
	public static final String UPDATE_CONTACT_WAY = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/update_contact_way";
	
	/**
	 * 删除企业已配置的「联系我」方式接口地址
	 */
	public static final String DEL_CONTACT_WAY = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/del_contact_way";
	
	/**
	 * 添加企业群发消息模板接口地址
	 */
	public static final String ADD_MSG_TEMPLATE = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/add_msg_template";
	
	/**
	 * 获取企业群发消息发送结果接口地址
	 */
	public static final String GET_GROUP_MSG = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get_group_msg_result";
	
	/**
	 * 获取员工行为数据接口地址
	 */
	public static final String GET_USER_BEHAVIOR = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get_user_behavior_data";
	
	/**
	 * 获取离职成员的客户列表接口地址
	 */
	public static final String GET_UNASSIGNED_LIST = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get_unassigned_list";
	
	/**
	 * 离职成员的外部联系人再分配接口地址
	 */
	public static final String UNSSIGN_TRANSFER = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/transfer";
	
	/**
	 * 获取配置了客户联系功能的成员列表
	 * 企业和第三方服务商可通过此接口获取配置了客户联系功能的成员(Customer Contact)列表。
	 * 企业需要使用外部联系人管理secret所获取的accesstoken来调用（accesstoken如何获取？）；
第三方应用需拥有“企业客户”权限。
第三方应用只能获取到可见范围内的配置了客户联系功能的成员。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @return 成员列表
	 * methods:GET
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91569
	 */
	GetFollowUserListResult getFollowUserList(String suiteId, String corpId) throws WxErrorException;

	/**
	 * 获取外部联系人列表
	 * 企业可通过此接口获取指定成员添加的客户列表。客户是指配置了客户联系功能的成员所添加的外部联系人。没有配置客户联系功能的成员，所添加的外部联系人将不会作为客户返回。
	 * 企业需要使用外部联系人管理secret所获取的accesstoken来调用（accesstoken如何获取？）；
第三方应用需拥有“企业客户”权限。
第三方应用的可见范围应包含指定的成员。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param userid 企业成员ID
	 * @return 外部联系人ID
	 * methods:GET
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91570
	 */
	GetExternalListResult getExternalContact(String suiteId, String corpId, String userid) throws WxErrorException;

	/**
	 * 获取外部联系人详情
	 * 企业可通过此接口，根据外部联系人的userid（如何获取?），拉取外部联系人详情。
	 * 企业需要使用外部联系人管理secret所获取的accesstoken来调用（accesstoken如何获取？）；
第三方应用需拥有“企业客户”权限。
第三方应用调用时，返回的跟进人follow_user仅包含应用可见范围之内的成员。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param externalUserid 外部联系人的userid，注意不是企业成员的帐号
	 * @return 外部联系人详情
	 * methods:GET
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91571
	 */
	GetExternalContactResult getExternalContactDetail(String suiteId, String corpId, String externalUserid) throws WxErrorException;

	/**
	 * 配置客户联系「联系我」方式
	 * 企业可以在管理后台-客户联系中配置成员的「联系我」的二维码或者小程序按钮，客户通过扫描二维码或点击小程序上的按钮，即可获取成员联系方式，主动联系到成员。
企业可通过此接口为具有客户联系功能的成员生成专属的「联系我」二维码或者「联系我」按钮。
注意:通过API添加的「联系我」不会在管理端进行展示，每个企业可通过API最多配置10万个「联系我」。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param addSend 配置内容
	 * @return 配置ID
	 * methods：POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91572
	 */
	AddContactWayResult addContactWay(String suiteId, String corpId, AddContactWaySend addSend) throws WxErrorException;

	/**
	 * 获取企业已配置的「联系我」方式
	 * 批量获取企业配置的「联系我」二维码和「联系我」小程序按钮。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param getSend 配置ID
	 * @return 配置信息
	 * methods：POST
	 * 接口地址：https://work.weixin.qq.com/api/doc#90001/90143/91572
	 */
	GetContactWayResult getContactWay(String suiteId,String corpId, GetContactWaySend getSend) throws WxErrorException;

	/**
	 * 更新企业已配置的「联系我」方式
	 * 更新企业配置的「联系我」二维码和「联系我」小程序按钮中的信息，如使用人员和备注等。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param updateSend 更新配置信息
	 * @return 公共返回实体
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91572
	 */
	CommonResult updateContactWay(String suiteId, String corpId, UpdateContactWaySend updateSend) throws WxErrorException;

	/**
	 * 删除企业已配置的「联系我」方式
	 * 删除一个已配置的「联系我」二维码或者「联系我」小程序按钮。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param delSend 配置ID
	 * @return 公共返回实体
	 * methods : POST
	 * 接口地址：https://work.weixin.qq.com/api/doc#90001/90143/91572
	 */
	CommonResult delContactWay(String suiteId, String corpId, GetContactWaySend delSend) throws WxErrorException;

	/**
	 * 添加企业群发消息模板
	 * 企业可通过此接口添加企业群发消息的模板并通知客服人员发送给相关客户。（注：企业微信终端需升级到2.7.5版本及以上）
注意：调用该接口并不会直接发送消息给客户，需要相关的客服人员操作以后才会实际发送（客服人员的企业微信需要升级到2.7.5及以上版本）
同一个企业对一个客户一个自然周内（周一至周日）至多只能发送一条消息，超过限制的用户将会被忽略。

第三方应用需拥有“企业客户”权限，并且能给第三方应用可见范围内的成员进行推送。
如果客户没有回复消息给配置了客户联系功能成员，则无法向其发送企业群发消息，不满足条件的external_userid将被过滤，如果传入的所有external_userid都不满足条件，则返回无可发送的客户(41048);
当只提供sender参数时，相当于选取了这个成员所有的客户；

	 * 
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param addMsgTSend 模板信息
	 * @return 模板ID
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91573
	 */
	AddMsgTemplateResult addMsgTemplate(String suiteId, String corpId, AddMsgTemplateSend addMsgTSend) throws WxErrorException;

	/**
	 * 获取企业群发消息发送结果
	 * 企业和第三方可通过该接口获取到添加企业群发消息模板生成消息的群发发送结果。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param msgSend 模板ID
	 * @return 发送结果
	 * methods：POST
	 * 接口地址：https://work.weixin.qq.com/api/doc#90001/90143/91574
	 */
	GetGroupMsgResult getGroupMsg(String suiteId, String corpId, GetGroupMsgSend msgSend) throws WxErrorException;

	/**
	 * 获取员工行为数据
	 * 企业可通过此接口获取员工联系客户的行为数据，包括聊天数，发送消息数，消息回复比例和平均首次回复时长等维度。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param behaviorSend 查询条件
	 * @return 行为数据
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91584
	 */
	GetUserBehaviorResult getUserBehavior(String suiteId, String corpId, GetUserBehaviorSend behaviorSend) throws WxErrorException;
	
	/**
	 * 获取离职成员的客户列表
	 * 企业和第三方可通过此接口，获取所有离职成员的客户列表，并可进一步调用离职成员的外部联系人再分配接口将这些客户重新分配给其他企业成员。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param unassignSend 分页数据
	 * @return 客户列表
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91575
	 */
	GetUnassignedListResult getUnassignedList(String suiteId, String corpId, GetUnassignedListSend unassignSend) throws WxErrorException;
	
	/**
	 * 离职成员的外部联系人再分配
	 * 企业可通过此接口，将已离职成员的外部联系人分配给另一个成员接替联系。
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param transferSend 分配信息
	 * @return 公共返回实体
	 * methods : POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91576
	 */
	CommonResult unassignTransfer(String suiteId, String corpId, UnassignTransferSend transferSend) throws WxErrorException;
}
