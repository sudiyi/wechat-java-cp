package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取第三方应用凭证返回实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90600
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSuiteTokenResult implements Serializable{

	private static final long serialVersionUID = -4004805126936069738L;

	private String errcode;
	private String errmsg;
	
	@SerializedName("suite_access_token")
	private String suiteAccessToken;//第三方应用access_token,最长为512字节
	
	@SerializedName("expires_in")
	private String expiresIn;//有效期
	
}
