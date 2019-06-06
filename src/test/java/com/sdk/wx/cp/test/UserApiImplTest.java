package com.sdk.wx.cp.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sdk.wx.cp.api.UserApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.UserApiImpl;
import com.sdk.wx.cp.bean.BatchDeleteSend;
import com.sdk.wx.cp.bean.InviteUserSend;
import com.sdk.wx.cp.bean.OpenidToUseridSend;
import com.sdk.wx.cp.bean.UserInfo;
import com.sdk.wx.cp.bean.UseridToOpenidSend;
import com.sdk.wx.cp.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 成员模块接口测试
 * 该模块涉及修改的接口，需要用通讯录管理的secret获取的accessToken访问
 * @author yangtao
 * @date 2019/06/03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserApiImplTest {

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
	
	//读取成员
	public void getUser() throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(userApi.getUser(testUtil.getPer().getAuthCorpInfo().getCorpid(), "YangTao", null)));
	}
	
	//创建成员
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void createUser() throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		UserInfo userInfo  = new UserInfo();
		userInfo.setUserid("test03");
		userInfo.setName("测试成员03");
		List<String> de = new ArrayList<String>();
		de.add("1");
		userInfo.setDepartment(de);
		userInfo.setMobile("18224479674");
		userInfo.setEmail("1254877@qq.com");
		log.info(GsonUtil.create().toJson(userApi.createUser(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), userInfo)));;
	}
	
	//更新成员
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void updateUser() throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		UserInfo userInfo = new UserInfo();
		userInfo.setUserid("test03");
		userInfo.setName("测试成员-update03");
		log.info(GsonUtil.create().toJson(userApi.updateUser(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), userInfo)));
	}
	
	//更新成员
	//必须使用企业微信设置的通讯录secret获取的accessToken，并且设置了编辑权限，才能使用写操作接口
	public void deleteUser() throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(userApi.deleteUser(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "test03")));
	}
	
	//批量删除成员
	public void batchDelete() throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		BatchDeleteSend batchDeleteSend = new BatchDeleteSend(new String[]{"test002"});
		log.info(GsonUtil.create().toJson(userApi.batchDelete(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), batchDeleteSend)));
	}
	
	//获取部门成员
	@Test
	public void simpleList() throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(userApi.simpleList(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "1", "1")));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?department_id=1&fetch_child=1&access_token=9H7RQ3jmx3E0Y6BEfXwM1h5nPgkBIEG4m2e-Nme8McapUY06Pg6GE5LOsY0vcVP21kBvtt73qZs3jiMldzsSKgUsHrXtZBy6-bfW_OoYTZ9S8ljyGdAxJnighVWdE1pvvkTyHviZYVaarsWIEWPLOM8ARXOVPEqCMoZzZYxNzHXOFKC4nWY_Dp6jzy6cXNWQjpI96Bkrh7e36pr1DcEqNg
		//【请求参数】：null
		//【响应数据】：{"errcode":0,"errmsg":"ok","userlist":[{"userid":"YangTao","name":"杨涛","department":[1]},{"userid":"zhangsan","name":"张三","department":[1]},{"userid":"lisi","name":"李四","department":[1]}]}
	}
	
	//获取部门成员详情
	public void userList() throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(userApi.userList(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "1", "1")));;
	}
	
	//userid换openid
	public void userIdOpenId()  throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		UseridToOpenidSend send = new UseridToOpenidSend("YangTao");
		log.info(GsonUtil.create().toJson(userApi.userIdOpenId(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), send)));
	}
	
	//openid换userid
	public void openIdUserId() throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		OpenidToUseridSend send = new OpenidToUseridSend("oZEws6CWSbMK3V8JOgXiJoek4Css");
		log.info(GsonUtil.create().toJson(userApi.openIdUserId(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), send)));
	}
	
	//二次验证
	public void succSync() throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(userApi.authsucc(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "YangTao")));
	}
	
	//邀请成员
	public void inviteUser() throws WxErrorException{
		UserApi userApi = new UserApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		InviteUserSend inviteSend = new InviteUserSend();
		inviteSend.setUser(new String[]{"test002"});
		log.info(GsonUtil.create().toJson(userApi.inviteUser(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), inviteSend)));
	}
}
