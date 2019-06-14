package com.sdk.wx.cp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sdk.wx.cp.api.Oauth2Api;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.Oauth2ApiImpl;
import com.sdk.wx.cp.config.WxCpProperties;
import com.sdk.wx.cp.config.WxCpProperties.SuiteInfo;
import com.sdk.wx.cp.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 普通用户构造oauth2拦截器（第三方应用需要给应用主页设置成ip+port/normal/suiteId/）
 * @author yangtao
 * @date 2019/06/04
 */
@Slf4j
@Component
public class Oauth2NormalFilter implements Filter{
	
	@Autowired
	private WechatCommonApi wechatCommonApi;

	@Autowired
	private WxCpProperties properties;

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        //TODO 权限校验，查看是否是需要进行oauth2的请求（根据实际情况来，这儿代码只是一个测试流程）
        //因为目前第三方应用的主页设置了以suiteId结尾，故在此判断请求地址包含suiteId的请求会被拦截
		log.info("进入普通用户地址拦截【requestUri】{}\n",request.getRequestURI());
		for(SuiteInfo suiteInfo : properties.getSuiteInfo()){
			if(request.getRequestURI().contains(suiteInfo.getSuiteId())){
				try{
					Oauth2Api oauthApi = new Oauth2ApiImpl(wechatCommonApi);
					String authUrl = oauthApi.authorizationUrl(suiteInfo.getSuiteId(), "AFEfawef");
					log.info("【authUrl】{}\n",authUrl);
					responseInfoString(response,"<a href='"+oauthApi.authorizationUrl("ww5b5fc5fcf496fade","0fawfwewe")+"'><img src='//rescdn.qqmail.com/node/wwopen/wwopenmng/style/images/independent/brand/300x40_blue$cecbbc4e.png' srcset='//rescdn.qqmail.com/node/wwopen/wwopenmng/style/images/independent/brand/300x40_blue_2x$c22687e4.png 2x' alt='企业微信登录'></a>");
					return;
				}catch (WxErrorException e) {
					responseInfoString(response,GsonUtil.create().toJson(e.getError()));
					return;
				}
			}
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	/**
	 * 返回信息
	 * @param response
	 * @param object
	 * @throws IOException
	 */
	private void responseInfoString(HttpServletResponse response,String str) throws IOException{
		ServletOutputStream out = response.getOutputStream();
		out.write(str.getBytes());
		out.flush();
	    out.close();
	}
}
