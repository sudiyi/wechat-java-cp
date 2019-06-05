package com.sdk.wx.cp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdk.wx.cp.api.AgentApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.AgentApiImpl;
import com.sdk.wx.cp.bean.GetAgentDetailResult;
import com.sdk.wx.cp.bean.GetAgentListResult;
import com.sdk.wx.cp.config.WxCpProperties;
import com.sdk.wx.cp.storage.InMemoryConfigStorage;
import com.sdk.wx.cp.util.GsonUtil;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 应用模块接口单元测试
 * @author yangtao
 * @date 2019/06/03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AgentApiImplTest {
	
	@Autowired
	private WechatCommonApi wechatCommonApi;

	@Autowired
	private InMemoryConfigStorage inMemoryConfigStorage;
	
	@Autowired
	private WxCpProperties properties;
	
	String suiteId = "";
	
	/**
	 * 测试token数据
	 */
	@Autowired
	private TestUtil testUtil;
	
	//获取指定应用详情
	public void getAgentDetail() throws WxErrorException{
		AgentApi agentApi = new AgentApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		GetAgentDetailResult result = agentApi.getAgentDetail(testUtil.getPer().getAuthCorpInfo().getCorpid(), null);
		log.info(GsonUtil.create().toJson(result));
	}
	
	//获取应用列表数据
	public void getAgentList() throws WxErrorException{
		AgentApi agentApi = new AgentApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		GetAgentListResult result = agentApi.getAgentList(testUtil.getPer().getAuthCorpInfo().getCorpid(), null);
		log.info(GsonUtil.create().toJson(result));
	}
	
	@Test
	public void test(){
		log.info(GsonUtil.create().toJson(properties));
	}

}
