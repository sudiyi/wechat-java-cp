package com.sdk.wx.cp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sdk.wx.cp.interceptor.Oauth2NormalInterceptor;

/**
 * 注册器
 * @author yangtao
 * @date 2019/06/04
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
 
  @Autowired
  private Oauth2NormalInterceptor oauth2NormalInterceptor;
 
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // addPathPatterns("/**") 应用主页请求，
    // excludePathPatterns 其余数据、消息、指令处理地址不拦截，实际开发时需调整，这只是测试逻辑
    registry.addInterceptor(oauth2NormalInterceptor).addPathPatterns("/**").excludePathPatterns("/wx/cp/**");
  }
}