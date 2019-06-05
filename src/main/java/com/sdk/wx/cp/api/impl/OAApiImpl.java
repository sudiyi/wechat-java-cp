package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.OAApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.GetOADataResult;
import com.sdk.wx.cp.bean.GetOADataSend;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * OA模块接口实现
 * @author yangtao
 * @date 2019/06/03
 */
public class OAApiImpl implements OAApi{
	
	private WechatCommonApi wechatCommonApi;
	
	public OAApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public GetOADataResult getOAData(String suiteId, String corpId, GetOADataSend oaSend) throws WxErrorException {
		String result = wechatCommonApi.post(GET_OA_DATA, UrlTypeEnum.ACCESS_TOKEN, suiteId, corpId, GsonUtil.create().toJson(oaSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetOADataResult.class);
	}
	
}
