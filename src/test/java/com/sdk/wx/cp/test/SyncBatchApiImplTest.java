package com.sdk.wx.cp.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sdk.wx.cp.api.SyncBatchApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.SyncBatchApiImpl;
import com.sdk.wx.cp.bean.ReplacePartySend;
import com.sdk.wx.cp.bean.SyncCUserSend;
import com.sdk.wx.cp.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 异步任务模块测试
 * 该模块接口需要使用通讯录管理的secret获取到的accessToken来访问
 * @author yangtao
 * @date 2019/06/04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SyncBatchApiImplTest {
	
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
	
	//异步任务增量更新成员
	public void syncCUser() throws WxErrorException{
		SyncBatchApi syncApi = new SyncBatchApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		SyncCUserSend cUserSend = new SyncCUserSend();
		cUserSend.setMediaId("3xrSU0DjQYXllscYMiHeUv3yvyxm9e3Lu1q8NmytXg1I");
		cUserSend.setToInvite("false");
		log.info(GsonUtil.create().toJson(syncApi.syncCUser(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), cUserSend)));
		//【响应数据】：{"errcode":0,"errmsg":"ok","jobid":"3_1559620211_296300"}
	}
	
	//全量覆盖成员
	public void replaceUser() throws WxErrorException{
		SyncBatchApi syncApi = new SyncBatchApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		SyncCUserSend cUserSend = new SyncCUserSend();
		cUserSend.setMediaId("3xrSU0DjQYXllscYMiHeUv3yvyxm9e3Lu1q8NmytXg1I");
		cUserSend.setToInvite("false");
		log.info(GsonUtil.create().toJson(syncApi.replaceUser(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), cUserSend)));
		//【响应数据】：{"errcode":0,"errmsg":"ok","jobid":"2_1559620562_692869"}
	}
	
	//全量覆盖部门
	public void replaceParty() throws WxErrorException{
		SyncBatchApi syncApi = new SyncBatchApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		ReplacePartySend partySend = new ReplacePartySend();
		partySend.setMediaId("3EyjHUEZMbuQ43jdh6IbYX2EqaKXBGCvsai9DUJqVDiM");
		log.info(GsonUtil.create().toJson(syncApi.replaceParty(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), partySend)));
		//【响应数据】：{"errcode":0,"errmsg":"ok","jobid":"1_1559622343_711097"}
	}
	
	//获取异步任务结果
	public void getResult() throws WxErrorException{
		SyncBatchApi syncApi = new SyncBatchApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		//log.info(GsonUtil.create().toJson(syncApi.getResult(testUtil.getPer().getAuthCorpInfo().getCorpid(), "3_1559620211_296300", "")));
		//【响应数据】：{"errcode":0,"errmsg":"ok","type":"sync_user","result":[{"userid":"zhangsan","errcode":0,"errmsg":""},{"userid":"lisi","errcode":0,"errmsg":""}],"total":2,"percentage":100,"status":3}
		//log.info(GsonUtil.create().toJson(syncApi.getResult(testUtil.getPer().getAuthCorpInfo().getCorpid(), "2_1559620562_692869", "")));
		//【响应数据】：{"errcode":0,"errmsg":"ok","type":"replace_user","result":[{"userid":"YangTao","errcode":301005,"errmsg":"not allow del corp creator"},{"userid":"zhangsan","errcode":0,"errmsg":""},{"userid":"lisi","errcode":0,"errmsg":""}],"total":3,"percentage":100,"status":3}
		log.info(GsonUtil.create().toJson(syncApi.getResult(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "1_1559622343_711097")));
		//【响应数据】：{"errcode":0,"errmsg":"ok","type":"replace_party","result":[{"action":1,"errcode":0,"errmsg":"ok","partyid":2},{"action":1,"errcode":0,"errmsg":"ok","partyid":3},{"action":1,"errcode":0,"errmsg":"ok","partyid":4},{"action":1,"errcode":0,"errmsg":"ok","partyid":5},{"action":1,"errcode":0,"errmsg":"ok","partyid":6},{"action":1,"errcode":0,"errmsg":"ok","partyid":7},{"action":10,"errcode":0,"errmsg":"ok","partyid":1}],"total":6,"percentage":100,"status":3}
	}

}
