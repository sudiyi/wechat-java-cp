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

	/**
	 * 要测试的第三方应用suiteId
	 */
	String suiteId = "ww5b5fc5fcf496fade";
	
	/**
	 * 测试token数据
	 */
	@Autowired
	private TestUtil testUtil;
	
	//获取指定应用详情
	public void getAgentDetail() throws WxErrorException{
		AgentApi agentApi = new AgentApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		GetAgentDetailResult result = agentApi.getAgentDetail(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid());
		log.info(GsonUtil.create().toJson(result));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/agent/get?agentid=1000034&access_token=9H7RQ3jmx3E0Y6BEfXwM1h5nPgkBIEG4m2e-Nme8McapUY06Pg6GE5LOsY0vcVP21kBvtt73qZs3jiMldzsSKgUsHrXtZBy6-bfW_OoYTZ9S8ljyGdAxJnighVWdE1pvvkTyHviZYVaarsWIEWPLOM8ARXOVPEqCMoZzZYxNzHXOFKC4nWY_Dp6jzy6cXNWQjpI96Bkrh7e36pr1DcEqNg
		//【请求参数】：null
		//【响应数据】：{"errcode":0,"errmsg":"ok","agentid":1000034,"name":"易开发","square_logo_url":"https://p.qlogo.cn/bizmail/z16NIeiaLEAufQadng3wlGBeNwYJPgOkdMp051b2jpL6c4Ah1hxWDjw/0","description":"企业内部人员账号，测试完整SDK接口（第三方）","allow_userinfos":{"user":[{"userid":"lisi"},{"userid":"zhangsan"},{"userid":"YangTao"}]},"allow_partys":{"partyid":[1]},"close":0,"redirect_domain":"ji65q3.natappfree.cc","report_location_flag":0,"isreportenter":0,"home_url":"http://ji65q3.natappfree.cc/normal/ww5b5fc5fcf496fade/"}
	}
	
	//获取应用列表数据
	@Test
	public void getAgentList() throws WxErrorException{
		AgentApi agentApi = new AgentApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		GetAgentListResult result = agentApi.getAgentList(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid());
		log.info(GsonUtil.create().toJson(result));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/agent/list?access_token=9H7RQ3jmx3E0Y6BEfXwM1h5nPgkBIEG4m2e-Nme8McapUY06Pg6GE5LOsY0vcVP21kBvtt73qZs3jiMldzsSKgUsHrXtZBy6-bfW_OoYTZ9S8ljyGdAxJnighVWdE1pvvkTyHviZYVaarsWIEWPLOM8ARXOVPEqCMoZzZYxNzHXOFKC4nWY_Dp6jzy6cXNWQjpI96Bkrh7e36pr1DcEqNg
		//【请求参数】：null
		//【响应数据】：{"errcode":0,"errmsg":"ok","agentlist":[{"agentid":1000034,"name":"易开发","square_logo_url":"https://p.qlogo.cn/bizmail/z16NIeiaLEAufQadng3wlGBeNwYJPgOkdMp051b2jpL6c4Ah1hxWDjw/0"}]}
	}
	
}
