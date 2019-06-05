package com.sdk.wx.cp.api.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Component;
import me.chanjar.weixin.common.util.http.HttpType;
import me.chanjar.weixin.common.util.http.apache.ApacheHttpClientBuilder;
import me.chanjar.weixin.common.util.http.apache.DefaultApacheHttpClientBuilder;

/**
 * apachehttp方式调用的开放工具类
 * @author yangtao
 * @date 2019/05/30
 */
@Component
public class WechatCommonApacheApiImpl extends WechatCommonApiImpl<CloseableHttpClient, HttpHost>{

	protected CloseableHttpClient httpClient;
	protected HttpHost httpProxy; 
	
	@Override
	public CloseableHttpClient getRequestHttpClient() {
		return httpClient;
	}

	@Override
	public HttpHost getRequestHttpProxy() {
		return httpProxy;
	}

	@Override
	public HttpType getRequestType() {
		return HttpType.APACHE_HTTP;
	}

	@Override
	public void initHttp() {
		ApacheHttpClientBuilder apacheHttpClientBuilder = this.configStorage.getApacheHttpClientBuilder();
		if (null == apacheHttpClientBuilder) {
		   apacheHttpClientBuilder = DefaultApacheHttpClientBuilder.get();
		}
		if(!StringUtils.isAnyBlank(this.configStorage.getHttpProxyHost(),
				this.configStorage.getHttpProxyUsername(),
				this.configStorage.getHttpProxyPassword())){
			apacheHttpClientBuilder.httpProxyHost(this.configStorage.getHttpProxyHost())
		      .httpProxyPort(this.configStorage.getHttpProxyPort())
		      .httpProxyUsername(this.configStorage.getHttpProxyUsername())
		      .httpProxyPassword(this.configStorage.getHttpProxyPassword());
			if(this.configStorage.getHttpProxyPort() > 0){
				this.httpProxy = new HttpHost(this.configStorage.getHttpProxyHost(), this.configStorage.getHttpProxyPort());
			}
		}
	    this.httpClient = apacheHttpClientBuilder.build();
	}

}
