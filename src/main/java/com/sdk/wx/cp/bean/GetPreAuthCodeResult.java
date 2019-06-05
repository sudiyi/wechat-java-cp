package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取预授权码返回实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90601
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPreAuthCodeResult implements Serializable{

	private static final long serialVersionUID = 312049673343065148L;

	private String errcode;
	private String errmsg;
	
	@SerializedName("pre_auth_code")
	private String preAuthCode;//预授权码,最长为512字节
	
	@SerializedName("expires_in")
	private String expiresIn;//过期时间
	
}
