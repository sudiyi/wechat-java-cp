package com.sdk.wx.cp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sdk.wx.cp.api.SpreadCodeApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.SpreadCodeApiImpl;
import com.sdk.wx.cp.bean.GetRegisterCodeSend;
import com.sdk.wx.cp.bean.SetScopeSend;
import com.sdk.wx.cp.storage.InMemoryConfigStorage;
import com.sdk.wx.cp.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 推广二维码模块测试
 * @author yangtao
 * @date 2019/06/05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpreadCodeApiImplTest {

	@Autowired
	private WechatCommonApi wechatCommonApi;

	@Autowired
	private InMemoryConfigStorage inMemoryConfigStorage;
	
	private String suiteId;
	
	/**
	 * 测试token数据
	 */
	@Autowired
	private TestUtil testUtil;
	
	//获取注册码接口
	public void getRegisterCode() throws WxErrorException{
		SpreadCodeApi spreadApi = new SpreadCodeApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "275kXp_NmdO_QuBHXlAYsXW7JjIJVeAJC0NP1h-gw-9wMmg--fGjajSgd-adU1jdlvS0z9SsZfSzrLq5cxtLndCRxuxJ2n0_K0HT8GBK9jtgC0_JtRBu0kSoqd17wX-J", 7200);
		GetRegisterCodeSend registerSend = new GetRegisterCodeSend();
		registerSend.setTemplateId("tpl0ce517d3e15bb085");
		log.info(GsonUtil.create().toJson(spreadApi.getRegisterCode(registerSend)));;
		//【响应数据】：{"errcode":0,"errmsg":"ok","register_code":"WdkMiT3cCYMLJkJQdI9p2FtiC2bvE5IAiiJII2y6q0ymQA4sPNDEJGNlR4WCBFsf","expires_in":600}
	}
	
	//获取注册信息
	public void getRegisterInfo() throws WxErrorException{
		SpreadCodeApi spreadApi = new SpreadCodeApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "275kXp_NmdO_QuBHXlAYsXW7JjIJVeAJC0NP1h-gw-9wMmg--fGjajSgd-adU1jdlvS0z9SsZfSzrLq5cxtLndCRxuxJ2n0_K0HT8GBK9jtgC0_JtRBu0kSoqd17wX-J", 7200);
		log.info(GsonUtil.create().toJson(spreadApi.getRegisterInfo("WdkMiT3cCYMLJkJQdI9p2FtiC2bvE5IAiiJII2y6q0ymQA4sPNDEJGNlR4WCBFsf")));;
		//【错误信息】：{"errcode":84024,"errmsg":"no register info, hint: [1559702768_4_00164cbeff221c8dbfe178d90313a9b8], more info at https://open.work.weixin.qq.com/devtool/query?e=84024"}
		//无注册信息
	}
	
	//设置应用授权状态
	/**
	 * 调用该接口前提是开启通讯录迁移，收到授权成功通知后可调用。
	 * 企业注册初始化安装应用后，应用默认可见范围为根部门。
	 * 如需修改应用可见范围，服务商可以调用该接口设置授权应用的可见范围。
	 * 该接口只能使用注册完成回调事件或者查询注册状态返回的access_token，
	 * 调用设置通讯录同步完成后或者access_token超过30分钟失效（即解除通讯录锁定状态）则不能继续调用该接口。
	 */
	public void setScope() throws WxErrorException{
		SpreadCodeApi spreadApi = new SpreadCodeApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		wechatCommonApi.getConfigStorage().updateSuiteAccessToken(suiteId, "275kXp_NmdO_QuBHXlAYsXW7JjIJVeAJC0NP1h-gw-9wMmg--fGjajSgd-adU1jdlvS0z9SsZfSzrLq5cxtLndCRxuxJ2n0_K0HT8GBK9jtgC0_JtRBu0kSoqd17wX-J", 7200);
		SetScopeSend scopeSend = new SetScopeSend();
		scopeSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		scopeSend.setAllowParty(new String[]{"1","2"});
		log.info(GsonUtil.create().toJson(spreadApi.setScope(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), scopeSend)));
	}
	
	//设置通讯录同步完成
	/**
	 * 也需要使用查询注册状态和返回通知事件里的accessToken信息
	 * 暂时无法测试
	 */
	@Test
	public void contactSyncSuccess(){
		
	}
}
