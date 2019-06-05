package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.GetAgentDetailResult;
import com.sdk.wx.cp.bean.GetAgentListResult;

import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 应用管理模块
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90363
 * @author yangtao
 * @date 2019/05/27
 */
public interface AgentApi {
	
	/**
	 * 获取指定的应用详情接口地址
	 */
	public static final String GET_AGENT_DETAIL = "https://qyapi.weixin.qq.com/cgi-bin/agent/get";

	/**
	 * 获取access_token对应的应用列表
	 */
	public static final String GET_AGENT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/agent/list";

	/**
	 * <pre>
	 * 获取指定应用详情
	 * methods：GET
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90363
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信 corpId
	 * @return 返回信息实体
	 * 
	 */
	GetAgentDetailResult getAgentDetail(String suiteId,String corpId) throws WxErrorException;
	
	/**
	 * <pre>
	 * 获取应用列表数据
	 * methods：GET
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90363
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信 corpId
	 * @return 返回信息实体
	 * 
	 */
	GetAgentListResult getAgentList(String suiteId,String corpId) throws WxErrorException;
}
