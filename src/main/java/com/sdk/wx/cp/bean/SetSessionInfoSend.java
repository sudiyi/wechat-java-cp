package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设置授权配置请求实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90602
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetSessionInfoSend implements Serializable{

	private static final long serialVersionUID = -9077802397571548699L;

	/**
	 * 预授权码
	 */
	@SerializedName("pre_auth_code")
	private String preAuthCode;
	
	@SerializedName("session_info")
	private SessionInfo sessionInfo;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class SessionInfo implements Serializable{

		private static final long serialVersionUID = 1L;
		
		/**
		 * 允许进行授权的应用id，如1、2、3， 不填或者填空数组都表示允许授权套件内所有应用（仅旧的多应用套件可传此参数，新开发者可忽略）
		 */
		private String[] appid;
		
		/**
		 * 授权类型：0 正式授权， 1 测试授权。 默认值为0。注意，请确保应用在正式发布后的授权类型为“正式授权”
		 */
		@SerializedName("auth_type")
		private String authType;
	}
	
}
