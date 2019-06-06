package com.sdk.wx.cp.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sdk.wx.cp.bean.GetPermanentCodeResult;
import com.sdk.wx.cp.bean.GetPermanentCodeResult.Agent;
import com.sdk.wx.cp.bean.GetPermanentCodeResult.AuthCorpInfo;
import com.sdk.wx.cp.bean.GetPermanentCodeResult.AuthInfo;

/**
 * 提供永久授权码和token数据（测试时用）
 * @author yangtao
 * @date 2019/06/03
 */
@Component
public class TestUtil {
	
	public GetPermanentCodeResult getPer(){
		GetPermanentCodeResult result = new GetPermanentCodeResult();
		result.setAccessToken("H7RQ3jmx3E0Y6BEfXwM1h5nPgkBIEG4m2e-Nme8McapUY06Pg6GE5LOsY0vcVP21kBvtt73qZs3jiMldzsSKgUsHrXtZBy6-bfW_OoYTZ9S8ljyGdAxJnighVWdE1pvvkTyHviZYVaarsWIEWPLOM8ARXOVPEqCMoZzZYxNzHXOFKC4nWY_Dp6jzy6cXNWQjpI96Bkrh7e36pr1DcEqNg");
		result.setExpiresIn("7200");
		AuthCorpInfo auth = result.new AuthCorpInfo();
		auth.setCorpid("wwc21e247fa2b93f01");
		result.setAuthCorpInfo(auth);
		result.setPermanentCode("gjQcwuJXi18sVuxuS-Y91pVPUOa90NP6bqJbobu3hRo");
		AuthInfo authInfo = result.new AuthInfo();
		List<Agent> list = new ArrayList<GetPermanentCodeResult.Agent>();
		Agent agent = result.new Agent();
		agent.setAgentid("1000034");
		list.add(agent);
		authInfo.setAgent(list);
		result.setAuthInfo(authInfo);
		return result;
	}

}
