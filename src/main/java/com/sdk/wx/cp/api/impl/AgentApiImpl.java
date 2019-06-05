package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.AgentApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.GetAgentDetailResult;
import com.sdk.wx.cp.bean.GetAgentListResult;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 应用模块接口实现
 * @author yangtao
 * @date 2019/05/27
 */
public class AgentApiImpl implements AgentApi{
	
	/**
	 * 公共方法执行接口、token管理器
	 */
	private WechatCommonApi wechatCommonApi;
	
	public AgentApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public GetAgentDetailResult getAgentDetail(String suiteId, String corpId) throws WxErrorException {
		String agentId = wechatCommonApi.getConfigStorage().getPermanentInfo(suiteId,corpId).getAgentId();
		String result = wechatCommonApi.get(GET_AGENT_DETAIL + "?agentid=" + agentId, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetAgentDetailResult.class);
	}

	@Override
	public GetAgentListResult getAgentList(String suiteId ,String corpId) throws WxErrorException {
		String result = wechatCommonApi.get(GET_AGENT_LIST, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetAgentListResult.class);
	}

}
