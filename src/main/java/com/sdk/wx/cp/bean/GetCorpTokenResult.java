package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业凭证返回实体
 * 企业微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90605
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCorpTokenResult implements Serializable{

	private static final long serialVersionUID = 6262015029607470264L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 授权方（企业）access_token,最长为512字节
	 */
	@SerializedName("access_token")
	private String accessToken;
	
	/**
	 * 授权方（企业）access_token超时时间
	 */
	@SerializedName("expires_in")
	private String expiresIn;
	
}
