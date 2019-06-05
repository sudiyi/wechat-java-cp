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
		result.setAccessToken("Cq4BpQfjv228PZzX9iO8p-nFawtfvVhTC_VsO28G09-TeBeoIQv9r66SL_XYhjpHygWnAB4mjOagXEZ35WMDYwBlZ6286nnuMY6woj0KIM73eaYZ8cGHIUAunA777ctXXaREXi08NefV7csNxzTlqFbjNln5Xp50OWBEjOrLAClejlRt-nJ0BS8y0cIK6JG6mF17fCWFaZf_qNHygQ1dsA");
		result.setExpiresIn("7200");
		AuthCorpInfo auth = result.new AuthCorpInfo();
		auth.setCorpid("wwc21e247fa2b93f01");
		result.setAuthCorpInfo(auth);
		result.setPermanentCode("diQxh0jO0ZUJSuhHFHm4-CXHLeI6aIvKgtyIRPKYx3U");
		AuthInfo authInfo = result.new AuthInfo();
		List<Agent> list = new ArrayList<GetPermanentCodeResult.Agent>();
		Agent agent = result.new Agent();
		agent.setAgentid("1000022");
		list.add(agent);
		authInfo.setAgent(list);
		result.setAuthInfo(authInfo);
		return result;
	}

}
