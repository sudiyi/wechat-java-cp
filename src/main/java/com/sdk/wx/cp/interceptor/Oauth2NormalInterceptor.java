package com.sdk.wx.cp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.wx.cp.api.Oauth2Api;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.Oauth2ApiImpl;
import com.sdk.wx.cp.storage.InMemoryConfigStorage;

import lombok.extern.slf4j.Slf4j;

/**
 * 普通用户构造oauth2拦截器
 * @author yangtao
 * @date 2019/06/04
 */
@Component
@Slf4j
public class Oauth2NormalInterceptor implements HandlerInterceptor{
	
	@Autowired
	private WechatCommonApi wechatCommonApi;

	@Autowired
	private InMemoryConfigStorage inMemoryConfigStorage;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//TODO 权限校验，查看是否是需要进行oauth2的请求（根据实际情况来，这儿代码只是一个测试流程）
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		Oauth2Api oauthApi = new Oauth2ApiImpl(wechatCommonApi);
		log.info("进入应用");
		log.info(oauthApi.authorizationUrl(request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1), "acwdfsd"));
		response.getOutputStream().write(("<a href='"+oauthApi.authorizationUrl(request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")),"0fawfwewe")+"'><img src='//rescdn.qqmail.com/node/wwopen/wwopenmng/style/images/independent/brand/300x40_blue$cecbbc4e.png' srcset='//rescdn.qqmail.com/node/wwopen/wwopenmng/style/images/independent/brand/300x40_blue_2x$c22687e4.png 2x' alt='企业微信登录'></a>").getBytes());
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
