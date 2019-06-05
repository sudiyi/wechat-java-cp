package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.SyncBatchApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.GetSyncResult;
import com.sdk.wx.cp.bean.ReplacePartySend;
import com.sdk.wx.cp.bean.SyncCUserResult;
import com.sdk.wx.cp.bean.SyncCUserSend;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 异步批量接口实现
 * @author yangtao
 * @date 2019/05/28
 */
public class SyncBatchApiImpl implements SyncBatchApi{
	
	/**
	 * 公共方法执行接口、token管理器
	 */
	private WechatCommonApi wechatCommonApi;
	
	public SyncBatchApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public SyncCUserResult syncCUser(String suiteId,String corpId, SyncCUserSend userSend) throws WxErrorException {
		String result = wechatCommonApi.post(SYNCCUSER,UrlTypeEnum.ACCESS_TOKEN,suiteId,corpId, GsonUtil.create().toJson(userSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, SyncCUserResult.class);
	}

	@Override
	public SyncCUserResult replaceUser(String suiteId,String corpId, SyncCUserSend userSend) throws WxErrorException {
		String result = wechatCommonApi.post(REPLACEUSER,UrlTypeEnum.ACCESS_TOKEN,suiteId,corpId, GsonUtil.create().toJson(userSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, SyncCUserResult.class);
	}

	@Override
	public SyncCUserResult replaceParty(String suiteId,String corpId, ReplacePartySend partySend) throws WxErrorException {
		String result = wechatCommonApi.post(REPLACEPARTY,UrlTypeEnum.ACCESS_TOKEN,suiteId,corpId, GsonUtil.create().toJson(partySend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, SyncCUserResult.class);
	}

	@Override
	public GetSyncResult getResult(String suiteId,String corpId, String jobId) throws WxErrorException {
		String result = wechatCommonApi.post(GET_RESULT+jobId,UrlTypeEnum.ACCESS_TOKEN,suiteId,corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetSyncResult.class);
	}

}
