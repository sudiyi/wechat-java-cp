package com.sdk.wx.cp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.DepartmentApiImpl;
import com.sdk.wx.cp.bean.DepartmentInfo;
import com.sdk.wx.cp.storage.InMemoryConfigStorage;
import com.sdk.wx.cp.util.GsonUtil;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 部门模块接口单元测试
 * @author yangtao
 * @date 2019/06/03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DepartmentApiImplTest {

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
	
	//创建部门
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	@Test
	public void createDep() throws WxErrorException{
		DepartmentApiImpl depart = new DepartmentApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		DepartmentInfo departInfo = new DepartmentInfo();
		departInfo.setName("测试部门1");
		departInfo.setOrder("100000000");
		departInfo.setParentid("1");
		log.info(GsonUtil.create().toJson(depart.createDep(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), departInfo)));
	}
	
	//获取部门列表
	public void getDepList() throws WxErrorException{
		DepartmentApiImpl depart = new DepartmentApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(depart.getDepList(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), null)));
	}

	//更新企业部门
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void updateDep() throws WxErrorException{
		DepartmentApiImpl depart = new DepartmentApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		DepartmentInfo departInfo = new DepartmentInfo();
		departInfo.setId("1");
		departInfo.setName("测试企业部门更新");
		log.info(GsonUtil.create().toJson(depart.updateDep(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), departInfo)));;
	}
	
	//删除企业部门
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void deleteDep() throws WxErrorException{
		DepartmentApiImpl depart = new DepartmentApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(depart.deleteDep(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "2")));
	}
}
