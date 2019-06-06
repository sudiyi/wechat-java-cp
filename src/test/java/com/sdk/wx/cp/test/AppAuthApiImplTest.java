package com.sdk.wx.cp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.AppAuthApiImpl;
import com.sdk.wx.cp.bean.GetPreAuthCodeResult;
import com.sdk.wx.cp.bean.SetSessionInfoSend;
import com.sdk.wx.cp.bean.SetSessionInfoSend.SessionInfo;
import com.sdk.wx.cp.controller.InstructCallbackController;
import com.sdk.wx.cp.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 应用授权模块接口单元测试
 * @author yangtao
 * @date 2019/06/03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AppAuthApiImplTest {
	
	/**
	 * 公共执行器
	 */
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
	
	/**
	 * 获取第三方应用凭证
	 * 微信服务端推送ticket时触发
	 * 见{@link InstructCallbackController} 处理回调消息部分代码
	 */
	public void getSuiteToken(){
		
	}
	
	//获取预授权码
	public void getPreAuthCode() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "xkjsm50fzHas5fk1MhSkcuoBtLHupDJckGAotKDFreSDULhX8RQZLy8ifs7HiMiOmQM3J6YNmOv7T-On4BJtdUXg1JO8Qg1uXVkKvToybz33GofMw-MMC-j_G11zxa1F", 7200);
		GetPreAuthCodeResult result = appAuth.getPreAuthCode(suiteId);
		log.info(GsonUtil.create().toJson(result));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/service/get_pre_auth_code?suite_access_token=xkjsm50fzHas5fk1MhSkcuoBtLHupDJckGAotKDFreSDULhX8RQZLy8ifs7HiMiOmQM3J6YNmOv7T-On4BJtdUXg1JO8Qg1uXVkKvToybz33GofMw-MMC-j_G11zxa1F
		//【请求参数】：null
		//【响应数据】：{"errcode":0,"errmsg":"ok","pre_auth_code":"KS0YxKs-383kEZs3Qh7eWflGBwCLMaA02FzZKdMUsIU089qjSWUZpsQ0M8F_enBQ","expires_in":3600}
	}
	
	//设置授权配置
	public void setSessionInfo() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "xkjsm50fzHas5fk1MhSkcuoBtLHupDJckGAotKDFreSDULhX8RQZLy8ifs7HiMiOmQM3J6YNmOv7T-On4BJtdUXg1JO8Qg1uXVkKvToybz33GofMw-MMC-j_G11zxa1F", 7200);
		SetSessionInfoSend send = new SetSessionInfoSend();
		send.setPreAuthCode("KS0YxKs-383kEZs3Qh7eWflGBwCLMaA02FzZKdMUsIU089qjSWUZpsQ0M8F_enBQ");
		SessionInfo info = send.new SessionInfo();
		info.setAuthType("1");
		send.setSessionInfo(info);
		log.info(GsonUtil.create().toJson(appAuth.setSessionInfo(suiteId,send)));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/service/set_session_info?suite_access_token=xkjsm50fzHas5fk1MhSkcuoBtLHupDJckGAotKDFreSDULhX8RQZLy8ifs7HiMiOmQM3J6YNmOv7T-On4BJtdUXg1JO8Qg1uXVkKvToybz33GofMw-MMC-j_G11zxa1F
		//【请求参数】：{"pre_auth_code":"KS0YxKs-383kEZs3Qh7eWflGBwCLMaA02FzZKdMUsIU089qjSWUZpsQ0M8F_enBQ","session_info":{"auth_type":"1"}}
		//【响应数据】：{"errcode":0,"errmsg":"ok"}
	}
	
	/**
	 * 获取永久授权码
	 * 企业微信授权第三方应用时触发
	 * 见{@link InstructCallbackController} 处理回调消息部分代码
	 */
	public void getPermanentCode(){
		//企业微信授权通知事件触发实现，已测试
	}
	
	//获取企业授权信息
	public void getAuthInfo() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "xkjsm50fzHas5fk1MhSkcuoBtLHupDJckGAotKDFreSDULhX8RQZLy8ifs7HiMiOmQM3J6YNmOv7T-On4BJtdUXg1JO8Qg1uXVkKvToybz33GofMw-MMC-j_G11zxa1F", 7200);
		log.info(GsonUtil.create().toJson(appAuth.getAuthInfo(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid())));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/service/get_auth_info?suite_access_token=xkjsm50fzHas5fk1MhSkcuoBtLHupDJckGAotKDFreSDULhX8RQZLy8ifs7HiMiOmQM3J6YNmOv7T-On4BJtdUXg1JO8Qg1uXVkKvToybz33GofMw-MMC-j_G11zxa1F
		//【请求参数】：{"auth_corpid":"wwc21e247fa2b93f01","permanent_code":"gjQcwuJXi18sVuxuS-Y91pVPUOa90NP6bqJbobu3hRo"}
		//【响应数据】：{"auth_corp_info":{"corpid":"wwc21e247fa2b93f01","corp_name":"测试企业20190524","corp_type":"unverified","corp_round_logo_url":"http://p.qpic.cn/pic_wework/3777001839/4046834be7a5f2711feaaa3cc4e691e1bcb1e526cb4544b5/0","corp_square_logo_url":"https://p.qlogo.cn/bizmail/eHVCWNKzOFxWUQxJF9icpTNauRcQXicNWqpgMYqXeibpuSvRxb6zuCvrg/0","corp_user_max":200,"corp_agent_max":300,"corp_wxqrcode":"http://p.qpic.cn/pic_wework/68696431/2e28013e10278b4d294a7175a791e58d7686858a55992dff/0","subject_type":1,"corp_scale":"1-50人","corp_industry":"其他行业","corp_sub_industry":"其他","location":"四川省成都市"},"auth_info":{"agent":[{"agentid":1000034,"name":"易开发","square_logo_url":"https://p.qlogo.cn/bizmail/z16NIeiaLEAufQadng3wlGBeNwYJPgOkdMp051b2jpL6c4Ah1hxWDjw/0","privilege":{"level":1,"allow_party":[1],"allow_user":["YangTao","lisi","zhangsan"],"allow_tag":[],"extra_party":[],"extra_user":[],"extra_tag":[]}}]}}
	}
	
	//获取企业凭证
	public void getCorpToken() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "xkjsm50fzHas5fk1MhSkcuoBtLHupDJckGAotKDFreSDULhX8RQZLy8ifs7HiMiOmQM3J6YNmOv7T-On4BJtdUXg1JO8Qg1uXVkKvToybz33GofMw-MMC-j_G11zxa1F", 7200);
		log.info(GsonUtil.create().toJson(appAuth.getCorpToken(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid())));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/service/get_corp_token?suite_access_token=xkjsm50fzHas5fk1MhSkcuoBtLHupDJckGAotKDFreSDULhX8RQZLy8ifs7HiMiOmQM3J6YNmOv7T-On4BJtdUXg1JO8Qg1uXVkKvToybz33GofMw-MMC-j_G11zxa1F
		//【请求参数】：{"auth_corpid":"wwc21e247fa2b93f01","permanent_code":"gjQcwuJXi18sVuxuS-Y91pVPUOa90NP6bqJbobu3hRo"}
		//【响应数据】：{"access_token":"9H7RQ3jmx3E0Y6BEfXwM1h5nPgkBIEG4m2e-Nme8McapUY06Pg6GE5LOsY0vcVP21kBvtt73qZs3jiMldzsSKgUsHrXtZBy6-bfW_OoYTZ9S8ljyGdAxJnighVWdE1pvvkTyHviZYVaarsWIEWPLOM8ARXOVPEqCMoZzZYxNzHXOFKC4nWY_Dp6jzy6cXNWQjpI96Bkrh7e36pr1DcEqNg","expires_in":7200}
	}
	
	//获取管理员列表数据
	public void getAdminList() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "QHsJgRTen_-hIN-ympGO59rNE_3ZoMxDYRekmpeGJGSCwlVecbuLT_e35SCpcjbD8sOdpb5_Q4xfYvYpBukyIG_ZI5rTmXqFCzwDh_zdTvpxSS2v6q0ow9s9_wvU4WUb", 7200);
		log.info(GsonUtil.create().toJson(appAuth.getAdminList(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid())));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/service/get_admin_list?suite_access_token=QHsJgRTen_-hIN-ympGO59rNE_3ZoMxDYRekmpeGJGSCwlVecbuLT_e35SCpcjbD8sOdpb5_Q4xfYvYpBukyIG_ZI5rTmXqFCzwDh_zdTvpxSS2v6q0ow9s9_wvU4WUb
		//【请求参数】：{"auth_corpid":"wwc21e247fa2b93f01","agentid":"1000034"}
		//【响应数据】：{"admin":[{"userid":"YangTao","auth_type":1}],"errcode":0,"errmsg":"ok"}
	}
	
	//获取服务商的token
	public void getProviderToken() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		log.info(GsonUtil.create().toJson(appAuth.getProviderToken()));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/service/get_provider_token
		//【请求参数】：{"corpid":"wwc21e247fa2b93f01","provider_secret":"mvhyQIWWugI1HzKOOz-pX9_Rvv8ZP1YADpl-hjiTZl2StCrDHal5pFxslm8hBjun"}
		//【响应数据】：{"provider_access_token":"Uned13bQtJVqT8sPqtpOGemvFu9cCSj4Ak4MgqChPC43E4Vn2fJ6ZPlTEjE2Bpsthaj4umfpHjoNMLCj96TCCMkgC6Xew9OgO9TEjTHHSzz_lkRUIJ2dvv0YRhQOnzRF","expires_in":7200}
	}
	
	//获取企业微信服务器的ip段
	@Test
	public void getCallbackIP() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(appAuth.getCallbackIp(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid())));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/getcallbackip?access_token=9H7RQ3jmx3E0Y6BEfXwM1h5nPgkBIEG4m2e-Nme8McapUY06Pg6GE5LOsY0vcVP21kBvtt73qZs3jiMldzsSKgUsHrXtZBy6-bfW_OoYTZ9S8ljyGdAxJnighVWdE1pvvkTyHviZYVaarsWIEWPLOM8ARXOVPEqCMoZzZYxNzHXOFKC4nWY_Dp6jzy6cXNWQjpI96Bkrh7e36pr1DcEqNg
		//【请求参数】：null
		//【响应数据】：{"ip_list":["101.226.233.*","101.227.139.*","112.90.75.*","117.144.245.*","121.51.139.*","121.51.162.*","14.17.43.*","14.17.44.*","14.215.153.*","140.207.54.*","157.255.192.*","163.177.84.*","163.177.87.246","183.232.98.*","183.3.235.*","183.61.51.*","203.205.151.*","58.251.62.*","59.36.121.*"]}
	}

}
