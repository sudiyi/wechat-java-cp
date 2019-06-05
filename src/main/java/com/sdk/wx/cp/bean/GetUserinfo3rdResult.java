package com.sdk.wx.cp.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取访问用户身份返回实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91121
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserinfo3rdResult implements Serializable{

	private static final long serialVersionUID = 1953753337208764114L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 用户所属企业的corpid
	 */
	@SerializedName("CorpId")
	private String corpId;
	
	/**
	 * 用户在企业内的UserID，如果该企业与第三方应用有授权关系时，返回明文UserId，否则返回密文UserId
	 */
	@SerializedName("UserId")
	private String userId;
	
	/**
	 * 手机设备号(由企业微信在安装时随机生成，删除重装会改变，升级不受影响)
	 */
	@SerializedName("DeviceId")
	private String deviceId;
	
	/**
	 * scope为snsapi_userinfo或snsapi_privateinfo，且用户在应用可见范围之内时返回此参数。
	 * 后续利用该参数可以获取用户信息或敏感信息，参见“第三方使用user_ticket获取成员详情”。
	 */
	@SerializedName("user_ticket")
	private String userTicket;
	
	/**
	 * user_ticket的有效时间（秒），随user_ticket一起返回
	 */
	@SerializedName("expiress_in")
	private String expiressId;
}
