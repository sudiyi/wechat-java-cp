package com.sdk.wx.cp.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取服务商token-返回信息实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91200
 * @author yangtao
 * @date 2019/05/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProviderTokenResult implements Serializable{

	private static final long serialVersionUID = 3621182633140269312L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 服务商token
	 */
	@SerializedName("provider_access_token")
	private String providerAccessToken;
	
	/**
	 * 过期时间
	 */
	@SerializedName("expires_in")
	private String expiresIn;
}
