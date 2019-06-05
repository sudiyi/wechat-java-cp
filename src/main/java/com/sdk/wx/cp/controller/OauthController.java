package com.sdk.wx.cp.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdk.wx.cp.api.Oauth2Api;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.GetLoginInfoSend;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.storage.InMemoryConfigStorage;
import com.sdk.wx.cp.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * oauth授权处理controller（身份验证模块测试使用）
 * @author yangtao
 * @date 2019/06/04
 */
@RestController
@RequestMapping("/wx/cp/oauth/")
@Slf4j
public class OauthController {
	
	@Autowired
	private WechatCommonApi wechatCommonApi;

	@Autowired
	private InMemoryConfigStorage inMemoryConfigStorage;

	/**
	 * 企业微信管理员管理后台跳转(测试接口)
	 * @param auth_code
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping("/adminOauth")
	public String adminOauth(String auth_code) throws WxErrorException{
		if(StringUtils.isNotBlank(auth_code)){
			log.info("拿到auth_code:" + auth_code);
			wechatCommonApi.initStorage(inMemoryConfigStorage);
			GetLoginInfoSend loginSend = new GetLoginInfoSend(auth_code);
			String url = Oauth2Api.GET_LOGIN_INFO + "?access_token=" + wechatCommonApi.getProviderAccessToken();
			//根据企业微信传过来的auth_code，获取管理员信息
			return GsonUtil.create().toJson(wechatCommonApi.post(url, UrlTypeEnum.NONE_TOKEN,null, GsonUtil.create().toJson(loginSend)));
			//拿到企业微信登录用户信息之后，可以为用户展示第三方应用管理模块
			//TODO 
		}
		return "未获取到auth_code";
	}
	
	/**
	 * 普通用户授权登录，企业微信手机端（测试接口）
	 * @param suiteId(应用的id，请在初始化项目时设置到回调路径中)
	 * @param code
	 * @param state
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping("/normalOauth")
	public String normalOauth(String suiteId,String code,String state) throws WxErrorException{
		if(StringUtils.isNotBlank(code)){
			log.info("拿到code:" + code);
			wechatCommonApi.initStorage(inMemoryConfigStorage);
			String url = Oauth2Api.GET_USERINFO_3RD + "suite_access_token=" + wechatCommonApi.getSuiteAccessToken(suiteId)+"&code="+code;
			//根据企业微信传过来的code，获取管理员信息
			//scope为snsapi_userinfo或snsapi_privateinfo时，使用code获取用户信息才会返回user_ticket，用以获取用户敏感信息
			return GsonUtil.create().toJson(wechatCommonApi.get(url, UrlTypeEnum.NONE_TOKEN,null, null));
			//拿到企业微信登录用户信息之后，可以为用户展示第三方功能模块
			//TODO 
		}
		return "未获取到code";
	}
}
