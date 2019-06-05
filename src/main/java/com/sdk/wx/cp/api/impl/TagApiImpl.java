package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.TagApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.AddTaguserResult;
import com.sdk.wx.cp.bean.AddTaguserSend;
import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.CreateTagResult;
import com.sdk.wx.cp.bean.GetTagInfoResult;
import com.sdk.wx.cp.bean.GetTagListResult;
import com.sdk.wx.cp.bean.TagInfo;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 标签管理模块实现
 * @author yangtao
 * @date 2019/05/27
 */
public class TagApiImpl implements TagApi{
	
	/**
	 * 公共方法执行接口、token管理器
	 */
	private WechatCommonApi wechatCommonApi;
	
	public TagApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public CreateTagResult createTag(String suiteId, String corpId, TagInfo tagInfo) throws WxErrorException {
		String result = wechatCommonApi.post(CREATE_TAG, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(tagInfo));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CreateTagResult.class);
	}

	@Override
	public CommonResult updateTag(String suiteId, String corpId, TagInfo tagInfo) throws WxErrorException {
		String result = wechatCommonApi.post(UPDATE_TAG, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(tagInfo));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public CommonResult deleteTag(String suiteId, String corpId, String tagid) throws WxErrorException {
		String result = wechatCommonApi.get(DELETE_TAG+tagid, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public GetTagInfoResult getTagInfo(String suiteId, String corpId, String tagid) throws WxErrorException {
		String result = wechatCommonApi.get(GET_TAG_INFO+tagid, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetTagInfoResult.class);
	}

	@Override
	public AddTaguserResult addTagusers(String suiteId, String corpId, AddTaguserSend addTagusersSend) throws WxErrorException {
		String result = wechatCommonApi.post(ADD_TAGUSERS, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(addTagusersSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, AddTaguserResult.class);
	}

	@Override
	public AddTaguserResult delTagusers(String suiteId, String corpId, AddTaguserSend delTagusersSend) throws WxErrorException {
		String result = wechatCommonApi.post(ADD_TAGUSERS, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(delTagusersSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, AddTaguserResult.class);
	}

	@Override
	public GetTagListResult getTagList(String suiteId, String corpId) throws WxErrorException {
		String result = wechatCommonApi.get(GET_TAG_LIST, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetTagListResult.class);
	}

}
