package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.SendMessageApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.MessageResult;
import com.sdk.wx.cp.bean.MessageSend;
import com.sdk.wx.cp.bean.UpdateTaskCardResult;
import com.sdk.wx.cp.bean.UpdateTaskCardSend;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 发送应用消息模块接口实现
 * @author yangtao
 * @date 2019/05/28
 */
public class SendMessageApiImpl implements SendMessageApi{
	
	/**
	 * 公共方法执行接口、token管理器
	 */
	private WechatCommonApi wechatCommonApi;
	
	public SendMessageApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public MessageResult sendMessage(String suiteId,String corpId, MessageSend msgSend) throws WxErrorException {
		String result = wechatCommonApi.post(SEND_MESSAGE,UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(msgSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, MessageResult.class);
	
	}

	@Override
	public UpdateTaskCardResult updateTaskCard(String suiteId, String corpId, UpdateTaskCardSend taskcardSend) throws WxErrorException {
		String result = wechatCommonApi.post(UPDATE_TASKCARD,UrlTypeEnum.ACCESS_TOKEN, suiteId, corpId, GsonUtil.create().toJson(taskcardSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, UpdateTaskCardResult.class);
	}

}
