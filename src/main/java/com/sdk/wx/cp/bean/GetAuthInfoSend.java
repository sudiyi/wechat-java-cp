package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业授权信息请求实体
 * 企业微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90604
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthInfoSend implements Serializable{

	private static final long serialVersionUID = 685784433546712499L;

	/**
	 * 授权方corpid
	 */
	@SerializedName("auth_corpid")
	private String authCorpid;
	
	/**
	 * 永久授权码，通过get_permanent_code获取
	 */
	@SerializedName("permanent_code")
	private String permanentCode;
}
