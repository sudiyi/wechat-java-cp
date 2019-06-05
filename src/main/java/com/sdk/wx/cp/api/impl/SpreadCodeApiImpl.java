package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.SpreadCodeApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.GetRegisterCodeResult;
import com.sdk.wx.cp.bean.GetRegisterCodeSend;
import com.sdk.wx.cp.bean.GetRegisterInfoResult;
import com.sdk.wx.cp.bean.GetRegisterInfoSend;
import com.sdk.wx.cp.bean.SetScopeResult;
import com.sdk.wx.cp.bean.SetScopeSend;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 推广二维码模块实现
 * @author yangtao
 * @date 2019/05/27
 */
public class SpreadCodeApiImpl implements SpreadCodeApi{
	
	/**
	 * 公共方法执行接口、token管理器
	 */
	private WechatCommonApi wechatCommonApi;
	
	public SpreadCodeApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public GetRegisterCodeResult getRegisterCode(GetRegisterCodeSend getRegisterCodeSend)
			throws WxErrorException {
		String result = wechatCommonApi.post(GET_REGISTER_CODE,UrlTypeEnum.PROVIDER_ACCESS_TOKEN,null, null, GsonUtil.create().toJson(getRegisterCodeSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetRegisterCodeResult.class);
	}

	@Override
	public GetRegisterInfoResult getRegisterInfo(String registerCode)
			throws WxErrorException {
		GetRegisterInfoSend send = new GetRegisterInfoSend(registerCode);
		String result = wechatCommonApi.post(GET_REGISTER_INFO,UrlTypeEnum.PROVIDER_ACCESS_TOKEN,null, null, GsonUtil.create().toJson(send));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetRegisterInfoResult.class);
	}

	@Override
	public SetScopeResult setScope(String accessToken, String corpId, SetScopeSend setScopeSend) throws WxErrorException {
		String result = wechatCommonApi.post(SET_SCOPE,UrlTypeEnum.ACCESS_TOKEN, accessToken, GsonUtil.create().toJson(setScopeSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, SetScopeResult.class);
	
	}

	@Override
	public CommonResult contactSyncSuccess(String accessToken)
			throws WxErrorException {
		String result = wechatCommonApi.get(CONTACT_SYNC_SUCCESS,UrlTypeEnum.ACCESS_TOKEN,accessToken,null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	
	}

}
