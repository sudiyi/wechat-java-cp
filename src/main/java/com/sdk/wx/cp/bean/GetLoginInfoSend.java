package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取用户登录信息请求实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91125
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLoginInfoSend implements Serializable{

	private static final long serialVersionUID = -5821153874141364288L;
	
	@SerializedName("auth_code")
	private String authCode;
}
