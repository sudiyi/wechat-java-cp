package com.sdk.wx.cp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdk.wx.cp.api.TagApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.TagApiImpl;
import com.sdk.wx.cp.bean.AddTaguserSend;
import com.sdk.wx.cp.bean.TagInfo;
import com.sdk.wx.cp.storage.InMemoryConfigStorage;
import com.sdk.wx.cp.util.GsonUtil;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 标签模块接口测试
 * @author yangtao
 * @date 2019/06/03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TagApiImplTest {

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
	
	//创建标签
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void createTag() throws WxErrorException{
		TagApi tagApi = new TagApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		TagInfo tagInfo = new TagInfo("测试tag4", null);
		log.info(GsonUtil.create().toJson(tagApi.createTag(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), tagInfo)));;
	}
	
	//更新标签
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void updateTag() throws WxErrorException{
		TagApi tagApi = new TagApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		TagInfo tagInfo = new TagInfo("测试update-tag2", "2");
		log.info(GsonUtil.create().toJson(tagApi.updateTag(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), tagInfo)));;
	}
	
	//删除标签
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void deleteTag() throws WxErrorException{
		TagApi tagApi = new TagApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(tagApi.deleteTag(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "3")));
	}
	
	//获取标签信息
	@Test
	public void getTagInfo() throws WxErrorException{
		TagApi tagApi = new TagApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(tagApi.getTagInfo(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "1")));
	}
	
	//增加标签成员
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void addTagusers() throws WxErrorException{
		TagApi tagApi = new TagApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		AddTaguserSend send = new AddTaguserSend();
		send.setTagid("1");
		send.setUserlist(new String[]{"YangTao"});
		send.setPartylist(new String[]{"1"});
		log.info(GsonUtil.create().toJson(tagApi.addTagusers(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), send)));
	}
	
	//删除标签成员
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void delTagusers() throws WxErrorException{
		TagApi tagApi = new TagApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		AddTaguserSend send = new AddTaguserSend();
		send.setTagid("1");
		send.setUserlist(new String[]{"YangTao"});
		log.info(GsonUtil.create().toJson(tagApi.delTagusers(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), send)));
	}
	
	//获取标签列表
	@Test
	public void getTagList() throws WxErrorException{
		TagApi tagApi = new TagApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(tagApi.getTagList(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid())));
	}
}
