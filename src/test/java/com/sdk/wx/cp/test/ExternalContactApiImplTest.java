package com.sdk.wx.cp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdk.wx.cp.api.ExternalContactApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.ExternalContactApiImpl;
import com.sdk.wx.cp.bean.AddContactWaySend;
import com.sdk.wx.cp.bean.GetUnassignedListSend;
import com.sdk.wx.cp.bean.GetUserBehaviorSend;
import com.sdk.wx.cp.storage.InMemoryConfigStorage;
import com.sdk.wx.cp.util.GsonUtil;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 外部联系人模块接口测试
 * @author yangtao
 * @date 2019/06/04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ExternalContactApiImplTest {

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
	
	//获取配置了客户联系功能的成员列表（企业需要验证以后才能设置外部联系人，所以获取到的数据为空）
	public void getFollowUserList() throws WxErrorException{
		ExternalContactApi exApi = new ExternalContactApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(exApi.getFollowUserList(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid())));;
		//【响应数据】：{"errcode":0,"errmsg":"ok","follow_user":[]}
	}
	
	//获取外部联系人列表
	//TODO
	public void getExternalContact() throws WxErrorException{
		ExternalContactApi exApi = new ExternalContactApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(exApi.getExternalContact(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "YangTao")));
		//【错误信息】：{"errcode":84061,"errmsg":"not external contact, hint: [1559637818_7_7338c5449b4fb73120a4853d45a72138], more info at https://open.work.weixin.qq.com/devtool/query?e=84061","external_userid":[]}
		//https://open.work.weixin.qq.com/devtool/query?e=84061 所传用户不存在外部联系人的关系
	}
	
	//获取外部联系人详情
	public void getExternalContactDetail() throws WxErrorException{
		ExternalContactApi exApi = new ExternalContactApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(exApi.getExternalContactDetail(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "YangTao")));
		//【错误信息】：{"errcode":40096,"errmsg":"invalid external userid, hint: [1559638009_5_5415bc68abd69d5ca735715d58f4a225], more info at https://open.work.weixin.qq.com/devtool/query?e=40096","follow_user":[]}
		//https://open.work.weixin.qq.com/devtool/query?e=40096 不合法的外部联系人userid
	}
	
	//配置客户联系「联系我」方式
	public void addContactWay() throws WxErrorException{
		ExternalContactApi exApi = new ExternalContactApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		AddContactWaySend addContactSend = new AddContactWaySend();
		addContactSend.setParty(new String[]{"1","2","5"});
		addContactSend.setRemark("测试客户");
		addContactSend.setScene("2");
		addContactSend.setSkipVerify("true");
		addContactSend.setState("外联二维码1");
		addContactSend.setStyle("");
		addContactSend.setType("2");
		addContactSend.setUser(new String[]{"YangTao","zhangsan"});
		log.info(GsonUtil.create().toJson(exApi.addContactWay(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), addContactSend)));;
		//【错误信息】：{"errcode":84074,"errmsg":"require in external contact, hint: [1559638560_2_a85d07b07ce7ffe9d2064710c1876e96], more info at https://open.work.weixin.qq.com/devtool/query?e=84074"}
		//https://open.work.weixin.qq.com/devtool/query?e=84074 没有外部联系人权限
	}
	
	//获取用户行为数据
	public void getUserBehavior() throws WxErrorException{
		ExternalContactApi exApi = new ExternalContactApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		GetUserBehaviorSend behaviorSend = new GetUserBehaviorSend();
		behaviorSend.setEndTime("1559639250");
		behaviorSend.setStartTime("1559631250");
		behaviorSend.setUserid(new String[]{"YangTao","zhangsan"});
		log.info(GsonUtil.create().toJson(exApi.getUserBehavior(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), behaviorSend)));;
		//【响应数据】：{"errcode":0,"errmsg":"ok","behavior_data":[{"stat_time":1559577600,"chat_cnt":0,"message_cnt":0}]}
	}
	
	//获取离职人员数据
	@Test
	public void getUnassignedList() throws WxErrorException{
		ExternalContactApi exApi = new ExternalContactApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		GetUnassignedListSend unassignSend = new GetUnassignedListSend("0","100");
		log.info(GsonUtil.create().toJson(exApi.getUnassignedList(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), unassignSend)));
		//【响应数据】：{"errcode":0,"errmsg":"ok","info":[],"is_last":true}
	}
	
}
