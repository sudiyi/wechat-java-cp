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
import com.sdk.wx.cp.storage.InMemoryConfigStorage;
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
	
	@Autowired
	private WechatCommonApi wechatCommonApi;

	@Autowired
	private InMemoryConfigStorage inMemoryConfigStorage;
	
	private String suiteId = "";
	
	/**
	 * 测试token数据
	 */
	@Autowired
	private TestUtil testUtil;
	
	//获取第三方应用凭证
	public void getSuiteToken(){
		//微信服务端推送ticket时触发，已测试
	}
	
	//获取预授权码
	public void getPreAuthCode() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "w4P2bHOJWIfwc-yZ2lzuCqFlen1DBYH6sVdUmPvP6PyeYtRTonq0hHbSeZrH8IFbKTfSXxwUkNz4ar9yHQmw3xyxGaG4QY5_f6gL4CjfxKmaerojpFtmumU6LT9-ta-A", 7200);
		GetPreAuthCodeResult result = appAuth.getPreAuthCode(suiteId);
		log.info(GsonUtil.create().toJson(result));
	}
	
	//设置授权配置
	public void setSessionInfo() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "w4P2bHOJWIfwc-yZ2lzuCqFlen1DBYH6sVdUmPvP6PyeYtRTonq0hHbSeZrH8IFbKTfSXxwUkNz4ar9yHQmw3xyxGaG4QY5_f6gL4CjfxKmaerojpFtmumU6LT9-ta-A", 7200);
		SetSessionInfoSend send = new SetSessionInfoSend();
		send.setPreAuthCode("KS0YxKs-383kEZs3Qh7eWWHU0_veAKmbMwPcGSmPxZ7OA6OiaOWrUNRvN7wdS2ZJ");
		SessionInfo info = send.new SessionInfo();
		info.setAuthType("1");
		send.setSessionInfo(info);
		log.info(GsonUtil.create().toJson(appAuth.setSessionInfo(suiteId,send)));
	}
	
	//获取永久授权码
	public void getPermanentCode(){
		//企业微信授权通知事件触发实现，已测试
	}
	
	//获取企业授权信息
	public void getAuthInfo() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "w4P2bHOJWIfwc-yZ2lzuCqFlen1DBYH6sVdUmPvP6PyeYtRTonq0hHbSeZrH8IFbKTfSXxwUkNz4ar9yHQmw3xyxGaG4QY5_f6gL4CjfxKmaerojpFtmumU6LT9-ta-A", 7200);
		log.info(GsonUtil.create().toJson(appAuth.getAuthInfo(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid())));
	}
	
	//获取企业凭证
	@Test
	public void getCorpToken() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "275kXp_NmdO_QuBHXlAYsXW7JjIJVeAJC0NP1h-gw-9wMmg--fGjajSgd-adU1jdlvS0z9SsZfSzrLq5cxtLndCRxuxJ2n0_K0HT8GBK9jtgC0_JtRBu0kSoqd17wX-J", 7200);
		log.info(GsonUtil.create().toJson(appAuth.getCorpToken(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid())));
	}
	
	//获取管理员列表数据
	public void getAdminList() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "Uv_ppHr_AjKg8RJNkJ-z9UnNBMjpR4fK3nM8Vs6yL23ACOzHyKUIZGWeaj7YiQzF_H5MxTLZgRBjnns7kbZMa0JQrjbkYCzJY3nZbgmXgPbZoKRfL-oxvmNUEXwSreQ4", 7200);
		log.info(GsonUtil.create().toJson(appAuth.getAdminList(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid())));
	}
	
	//获取服务商的token
	public void getProviderToken() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		log.info(GsonUtil.create().toJson(appAuth.getProviderToken()));
		//【响应数据】：{"provider_access_token":"XmAaVN_RrLxlJZ1Zz2T2tcROclFiMdg2WGSuJGcLX-fHbvmZL1ar7TpL1u60-cZB-FWIqubtxeDW8_FnGzHY25mr_lOd3n28WcGgdCYO1ojnbfiCTk3xms_IjMN4XzkH","expires_in":7200}
	}
	
	//获取企业微信服务器的ip段
	public void getCallbackIP() throws WxErrorException{
		AppAuthApiImpl appAuth = new AppAuthApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(appAuth.getCallbackIp(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid())));
		//【响应数据】：{"ip_list":["101.226.233.*","101.227.139.*","112.90.75.*","117.144.245.*","121.51.139.*","121.51.162.*","14.17.43.*","14.17.44.*","14.215.153.*","140.207.54.*","157.255.192.*","163.177.84.*","163.177.87.246","183.232.98.*","183.3.235.*","183.61.51.*","203.205.151.*","58.251.62.*","59.36.121.*"]}
	}

}
