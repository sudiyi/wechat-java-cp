package com.sdk.wx.cp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.DepartmentApiImpl;
import com.sdk.wx.cp.bean.DepartmentInfo;
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
	
	//创建部门
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void createDep() throws WxErrorException{
		DepartmentApiImpl depart = new DepartmentApiImpl(wechatCommonApi);
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
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(depart.getDepList(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), null)));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/department/list?idnull&access_token=9H7RQ3jmx3E0Y6BEfXwM1h5nPgkBIEG4m2e-Nme8McapUY06Pg6GE5LOsY0vcVP21kBvtt73qZs3jiMldzsSKgUsHrXtZBy6-bfW_OoYTZ9S8ljyGdAxJnighVWdE1pvvkTyHviZYVaarsWIEWPLOM8ARXOVPEqCMoZzZYxNzHXOFKC4nWY_Dp6jzy6cXNWQjpI96Bkrh7e36pr1DcEqNg
		//【请求参数】：null
		//【响应数据】：{"errcode":0,"errmsg":"ok","department":[{"id":1,"name":"腾讯科技","parentid":0,"order":1},{"id":2,"name":"总办","parentid":1,"order":1},{"id":3,"name":"微信事业群11","parentid":1,"order":2},{"id":4,"name":"产品部","parentid":3,"order":1},{"id":5,"name":"开发部","parentid":3,"order":2},{"id":6,"name":"前端开发组","parentid":5,"order":1},{"id":7,"name":"后台开发组","parentid":5,"order":2},{"id":8,"name":"测试部门1","parentid":1,"order":100000000}]}
	}

	//更新企业部门
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void updateDep() throws WxErrorException{
		DepartmentApiImpl depart = new DepartmentApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		DepartmentInfo departInfo = new DepartmentInfo();
		departInfo.setId("1");
		departInfo.setName("测试企业部门更新");
		log.info(GsonUtil.create().toJson(depart.updateDep(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), departInfo)));;
	}
	
	//删除企业部门
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	@Test
	public void deleteDep() throws WxErrorException{
		DepartmentApiImpl depart = new DepartmentApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(depart.deleteDep(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "2")));
	}
}
