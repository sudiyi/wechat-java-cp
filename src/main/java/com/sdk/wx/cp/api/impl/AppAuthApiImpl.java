package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.AppAuthApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.GetAdminListResult;
import com.sdk.wx.cp.bean.GetAdminListSend;
import com.sdk.wx.cp.bean.GetAuthInfoResult;
import com.sdk.wx.cp.bean.GetAuthInfoSend;
import com.sdk.wx.cp.bean.GetCallbackIpResult;
import com.sdk.wx.cp.bean.GetCorpTokenResult;
import com.sdk.wx.cp.bean.GetCorpTokenSend;
import com.sdk.wx.cp.bean.GetPermanentCodeResult;
import com.sdk.wx.cp.bean.GetPermanentCodeSend;
import com.sdk.wx.cp.bean.GetPreAuthCodeResult;
import com.sdk.wx.cp.bean.GetProviderTokenResult;
import com.sdk.wx.cp.bean.GetProviderTokenSend;
import com.sdk.wx.cp.bean.GetSuiteTokenResult;
import com.sdk.wx.cp.bean.GetSuiteTokenSend;
import com.sdk.wx.cp.bean.SetSessionInfoSend;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 应用授权模块实现
 * @author yangtao
 * @date 2019/05/27
 */
public class AppAuthApiImpl implements AppAuthApi{
	
	/**
	 * 公共方法执行接口、token管理器
	 */
	private WechatCommonApi wechatCommonApi;
	
	public AppAuthApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public GetSuiteTokenResult getSuiteToken(String suiteId) throws WxErrorException {
		GetSuiteTokenSend send = new GetSuiteTokenSend(suiteId, wechatCommonApi.getConfigStorage().getSuiteStorage(suiteId).getSuiteSecret(), wechatCommonApi.getConfigStorage().getSuiteTicket(suiteId));
		String result = wechatCommonApi.post(GET_SUITE_TOKEN, GsonUtil.create().toJson(send));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetSuiteTokenResult.class);
	}

	@Override
	public GetPreAuthCodeResult getPreAuthCode(String suiteId) throws WxErrorException {
		String result = wechatCommonApi.get(GET_PRE_AUTH_CODE,UrlTypeEnum.SUITE_ACCESS_TOKEN,suiteId,null,null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetPreAuthCodeResult.class);
	}

	@Override
	public CommonResult setSessionInfo(String suiteId, SetSessionInfoSend setSessionInfoSend)
			throws WxErrorException {
		String result = wechatCommonApi.post(SET_SESSION_INFO,UrlTypeEnum.SUITE_ACCESS_TOKEN,suiteId, null, GsonUtil.create().toJson(setSessionInfoSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public GetPermanentCodeResult getPermanentCode(String suiteId, String authCode)
			throws WxErrorException {
		GetPermanentCodeSend getPermanentCodeSend = new GetPermanentCodeSend(authCode);
		String result = wechatCommonApi.post(GET_PERMANENT_CODE,UrlTypeEnum.SUITE_ACCESS_TOKEN,suiteId, null, GsonUtil.create().toJson(getPermanentCodeSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetPermanentCodeResult.class);
	}

	@Override
	public GetAuthInfoResult getAuthInfo(String suiteId, String corpId) throws WxErrorException {
		GetAuthInfoSend getAuthInfoSend = new GetAuthInfoSend(corpId, wechatCommonApi.getConfigStorage().getPermanentInfo(suiteId, corpId).getPermanentCode());
		String result = wechatCommonApi.post(GET_AUTH_INFO,UrlTypeEnum.SUITE_ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(getAuthInfoSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetAuthInfoResult.class);
	}

	@Override
	public GetCorpTokenResult getCorpToken(String suiteId, String corpId) throws WxErrorException {
		GetCorpTokenSend getCorpTokenSend = new GetCorpTokenSend(corpId, wechatCommonApi.getConfigStorage().getPermanentInfo(suiteId, corpId).getPermanentCode());
		String result = wechatCommonApi.post(GET_CORP_TOKEN,UrlTypeEnum.SUITE_ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(getCorpTokenSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetCorpTokenResult.class);
	}

	@Override
	public GetAdminListResult getAdminList(String suiteId, String corpId) throws WxErrorException {
		GetAdminListSend getAdminListSend = new GetAdminListSend(corpId, wechatCommonApi.getConfigStorage().getPermanentInfo(suiteId, corpId).getAgentId());
		String result = wechatCommonApi.post(GET_ADMIN_LIST,UrlTypeEnum.SUITE_ACCESS_TOKEN, suiteId,corpId, GsonUtil.create().toJson(getAdminListSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetAdminListResult.class);
	}

	@Override
	public GetProviderTokenResult getProviderToken()
			throws WxErrorException {
		GetProviderTokenSend send = new GetProviderTokenSend(wechatCommonApi.getConfigStorage().getCorpid(),
				wechatCommonApi.getConfigStorage().getProviderSecret());
		String result = wechatCommonApi.post(GET_PROVIDER_TOKEN, GsonUtil.create().toJson(send));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetProviderTokenResult.class);
	}

	@Override
	public GetCallbackIpResult getCallbackIp(String suiteId, String corpId) throws WxErrorException {
		String result = wechatCommonApi.get(GET_CALLBACK_IP, UrlTypeEnum.ACCESS_TOKEN, suiteId,corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetCallbackIpResult.class);
	}

}
