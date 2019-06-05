package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.ExternalContactApi;
import com.sdk.wx.cp.api.WechatCommonApi;
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
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 外部联系人管理模块接口实现
 * @author yangtao
 * @date 2019/05/28
 */
public class ExternalContactApiImpl implements ExternalContactApi{
	
	/**
	 * 公共方法执行接口、token管理器
	 */
	private WechatCommonApi wechatCommonApi;
	
	public ExternalContactApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public GetFollowUserListResult getFollowUserList(String suiteId, String corpId) throws WxErrorException {
		String result = wechatCommonApi.get(GET_FOLLOW_USER_LIST,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId,null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetFollowUserListResult.class);
	}

	@Override
	public GetExternalListResult getExternalContact(String suiteId, String corpId, String userid) throws WxErrorException {
		String result = wechatCommonApi.get(EXTERNAL_CONTACT+"?userid="+userid,UrlTypeEnum.ACCESS_TOKEN,suiteId,corpId,null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetExternalListResult.class);
	}

	@Override
	public GetExternalContactResult getExternalContactDetail(String suiteId, String corpId, String externalUserid)
			throws WxErrorException {
		String result = wechatCommonApi.get(EXTERBAK_CONTACT_DETAIL+"?external_userid="+externalUserid,UrlTypeEnum.ACCESS_TOKEN,suiteId,corpId,null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetExternalContactResult.class);
	}

	@Override
	public AddContactWayResult addContactWay(String suiteId, String corpId, AddContactWaySend addSend) throws WxErrorException {
		String result = wechatCommonApi.post(ADD_CONTACT_WAY,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(addSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, AddContactWayResult.class);
	}

	@Override
	public GetContactWayResult getContactWay(String suiteId, String corpId, GetContactWaySend getSend) throws WxErrorException {
		String result = wechatCommonApi.post(GET_CONTACT_WAY,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(getSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetContactWayResult.class);
	}

	@Override
	public CommonResult updateContactWay(String suiteId, String corpId, UpdateContactWaySend updateSend) throws WxErrorException {
		String result = wechatCommonApi.post(UPDATE_CONTACT_WAY,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(updateSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public CommonResult delContactWay(String suiteId, String corpId, GetContactWaySend delSend) throws WxErrorException {
		String result = wechatCommonApi.post(DEL_CONTACT_WAY,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(delSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public AddMsgTemplateResult addMsgTemplate(String suiteId, String corpId, AddMsgTemplateSend addMsgTSend) throws WxErrorException {
		String result = wechatCommonApi.post(ADD_MSG_TEMPLATE,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(addMsgTSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, AddMsgTemplateResult.class);
	}

	@Override
	public GetGroupMsgResult getGroupMsg(String suiteId, String corpId, GetGroupMsgSend msgSend) throws WxErrorException {
		String result = wechatCommonApi.post(GET_GROUP_MSG,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(msgSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetGroupMsgResult.class);
	}

	@Override
	public GetUserBehaviorResult getUserBehavior(String suiteId, String corpId, GetUserBehaviorSend behaviorSend) throws WxErrorException {
		String result = wechatCommonApi.post(GET_USER_BEHAVIOR,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(behaviorSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetUserBehaviorResult.class);
	}

	@Override
	public GetUnassignedListResult getUnassignedList(String suiteId, String corpId, GetUnassignedListSend unassignSend)
			throws WxErrorException {
		String result = wechatCommonApi.post(GET_UNASSIGNED_LIST,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(unassignSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetUnassignedListResult.class);
	}

	@Override
	public CommonResult unassignTransfer(String suiteId, String corpId, UnassignTransferSend transferSend) throws WxErrorException {
		String result = wechatCommonApi.post(UNSSIGN_TRANSFER,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(transferSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

}
