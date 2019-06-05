package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.UserApi;
import com.sdk.wx.cp.api.WechatCommonApi;
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
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 成员管理模块实现
 * @author yangtao
 * @date 2019/05/28
 */
public class UserApiImpl implements UserApi{
	/**
	 * 公共方法执行接口、token管理器
	 */
	private WechatCommonApi wechatCommonApi;
	
	public UserApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public CommonResult createUser(String suiteId, String corpId, UserInfo userInfo) throws WxErrorException {
		String result = wechatCommonApi.post(CREATE_USER, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(userInfo));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public UserInfoResult getUser(String suiteId, String corpId, String userid) throws WxErrorException {
		String result = wechatCommonApi.get(GET_USER+userid, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, UserInfoResult.class);
	}

	@Override
	public CommonResult updateUser(String suiteId, String corpId, UserInfo userInfo) throws WxErrorException {
		String result = wechatCommonApi.post(UPDATE_USER, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(userInfo));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public CommonResult deleteUser(String suiteId, String corpId, String userid) throws WxErrorException {
		String result = wechatCommonApi.get(DELETE_USER+userid, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public CommonResult batchDelete(String suiteId, String corpId, BatchDeleteSend batchDeleteSend) throws WxErrorException {
		String result = wechatCommonApi.post(BATCH_DELETE, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(batchDeleteSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public UserSimpleListResult simpleList(String suiteId, String corpId, String departmentId, String fetchChild) throws WxErrorException {
		String url = SIMPLE_LIST+"?department_id=" + departmentId + "&fetch_child=" + fetchChild;
		String result = wechatCommonApi.get(url, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, UserSimpleListResult.class);
	}

	@Override
	public UserListDetailResult userList(String suiteId, String corpId, String departmentId, String fetchChild) throws WxErrorException {
		String url = USER_DETAIL_LIST + "?department_id=" + departmentId + "&fetch_child=" + fetchChild;
		String result = wechatCommonApi.get(url, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, UserListDetailResult.class);
	}

	@Override
	public UseridToOpenidResult userIdOpenId(String suiteId, String corpId, UseridToOpenidSend toOpenId) throws WxErrorException {
		String result = wechatCommonApi.post(CONVERT_TO_OPENID, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(toOpenId));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, UseridToOpenidResult.class);
	}

	@Override
	public OpenidToUseridResult openIdUserId(String suiteId, String corpId, OpenidToUseridSend toUserId) throws WxErrorException {
		String result = wechatCommonApi.post(CONVERT_TO_USERID, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(toUserId));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, OpenidToUseridResult.class);
	}

	@Override
	public CommonResult authsucc(String suiteId, String corpId, String userid) throws WxErrorException {
		String result = wechatCommonApi.get(AUTH_SUCC+userid, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public InviteUserResult inviteUser(String suiteId, String corpId, InviteUserSend inviteSend) throws WxErrorException {
		String result = wechatCommonApi.post(INVITE_USER, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(inviteSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, InviteUserResult.class);
	}

}
