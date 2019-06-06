package com.sdk.wx.cp.api.impl;

import org.apache.commons.lang3.StringUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.Oauth2Api;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.GetLoginInfoResult;
import com.sdk.wx.cp.bean.GetLoginInfoSend;
import com.sdk.wx.cp.bean.GetUserdetail3rdResult;
import com.sdk.wx.cp.bean.GetUserdetail3rdSend;
import com.sdk.wx.cp.bean.GetUserinfo3rdResult;
import com.sdk.wx.cp.enums.OauthScopeConstants;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.URIUtil;

/**
 * 身份验证模块实现
 * @author yangtao
 * @date 2019/05/27
 */
public class Oauth2ApiImpl implements Oauth2Api{
	
	private WechatCommonApi wechatCommonApi;
	
	public Oauth2ApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public String authorizationUrl(String suiteId, String state) throws WxErrorException {
		return authorizationUrl(suiteId,wechatCommonApi.getConfigStorage().getSuiteStorage("ww5b5fc5fcf496fade").getOauth2RedirectUri(),state);
	}

	@Override
	public String authorizationUrl(String suiteId, String redirectUri, String state) throws WxErrorException {
		return authorizationUrl(suiteId,redirectUri,state,OauthScopeConstants.SNSAPI_BASE);
	}

	@Override
	public String authorizationUrl(String suiteId,String redirectUri, String state, String scope) throws WxErrorException {
		StringBuilder url = new StringBuilder(BUILDING_OAUTH2_ADD);
	    url.append("appid=").append(suiteId);
	    url.append("&redirect_uri=").append(URIUtil.encodeURIComponent(redirectUri));
	    url.append("&response_type=code");
	    url.append("&scope=").append(scope);
	    if (StringUtils.isNotBlank(state)) {
	        url.append("&state=").append(state);
	    }
	    url.append("#wechat_redirect");
	    return url.toString();
	}

	@Override
	public GetUserinfo3rdResult getUserinfo3rd(String suiteId,String code) throws WxErrorException {
		String result = wechatCommonApi.get(GET_USERINFO_3RD+"code=" + code, UrlTypeEnum.SUITE_ACCESS_TOKEN, suiteId, null, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetUserinfo3rdResult.class);
	}

	@Override
	public GetUserdetail3rdResult getUserdetail3rd(String suiteId, String userTicket) throws WxErrorException {
		GetUserdetail3rdSend getUserdetail3rdSend = new GetUserdetail3rdSend(userTicket);
		String result = wechatCommonApi.post(GET_USERDETAIL_3RD, UrlTypeEnum.SUITE_ACCESS_TOKEN,suiteId, null, GsonUtil.create().toJson(getUserdetail3rdSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetUserdetail3rdResult.class);
	}

	@Override
	public GetLoginInfoResult getLoginInfo(String suiteId,String authCode) throws WxErrorException {
		GetLoginInfoSend getLoginInfoSend = new GetLoginInfoSend(authCode);
		String result = wechatCommonApi.post(GET_LOGIN_INFO, UrlTypeEnum.PROVIDER_ACCESS_TOKEN,suiteId, null, GsonUtil.create().toJson(getLoginInfoSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetLoginInfoResult.class);
	}

}
