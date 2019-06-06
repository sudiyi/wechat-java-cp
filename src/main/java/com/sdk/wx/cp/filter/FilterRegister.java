package com.sdk.wx.cp.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * filter注册器
 * @author yangtao
 * @date 2019/06/06
 */
@Configuration
public class FilterRegister {
	
	@Autowired
	private Oauth2NormalFilter oauth2NormalFilter;

	/**
	 * 普通用户oauth2过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<Oauth2NormalFilter> registerOauth2NormalFilter(){
		FilterRegistrationBean<Oauth2NormalFilter> registration = new FilterRegistrationBean<Oauth2NormalFilter>();
		registration.setFilter(oauth2NormalFilter);
		registration.addUrlPatterns("/normal/*");
		registration.setName("Oauth2NormalFilter");
		registration.setOrder(1);
		return registration;
	}
}
