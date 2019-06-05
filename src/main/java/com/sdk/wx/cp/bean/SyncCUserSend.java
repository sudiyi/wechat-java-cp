package com.sdk.wx.cp.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 增量更新接口请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91130
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SyncCUserSend implements Serializable{

	private static final long serialVersionUID = 5031110814738976268L;

	/**
	 * 上传的csv文件的media_id
	 */
	@SerializedName("media_id")
	private String mediaId;
	
	/**
	 * 是否邀请新建的成员使用企业微信（将通过微信服务通知或短信或邮件下发邀请，每天自动下发一次，最多持续3个工作日），默认值为true。
	 */
	@SerializedName("to_invite")
	private String toInvite;
	
	/**
	 * 回调信息。如填写该项则任务完成后，通过callback推送事件给企业。具体请参考应用回调模式中的相应选项
	 */
	private Callback callback;
	
	@Data
	public class Callback implements Serializable{

		private static final long serialVersionUID = 5422281304496612034L;
		
		/**
		 * 企业应用接收企业微信推送请求的访问协议和地址，支持http或https协议
		 */
		private String url;
		
		/**
		 * 	用于生成签名
		 */
		private String token;
		
		/**
		 * 	用于消息体的加密，是AES密钥的Base64编码
		 */
		private String encodingaeskey;
		
	}
}
