package com.sdk.wx.cp.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取服务商凭证-请求实体
 * 接口地址：https://work.weixin.qq.com/api/doc#90001/90143/91200
 * @author yangtao
 * @date 2019/05/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProviderTokenSend implements Serializable{
	 
	private static final long serialVersionUID = -3032567653302865453L;

	/**
	 * 服务商的corpId
	 */
	@SerializedName("corpid")
	private String corpId;
	
	/**
	 * 服务商的secret
	 */
	@SerializedName("provider_secret")
	private String providerSecret;
}
