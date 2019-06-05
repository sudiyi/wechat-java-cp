package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询注册状态返回信息实体
 * 微信文档：https://work.weixin.qq.com/api/doc#90001/90143/90582
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRegisterInfoResult implements Serializable{

	private static final long serialVersionUID = 4080333929942867880L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 企业的corpid
	 */
	private String corpid;
	
	/**
	 * 通讯录迁移的凭证信息。仅当注册推广包开启通讯录迁移接口时返回该参数
	 */
	@SerializedName("contract_sync")
	private ContractSync contractSync;
	
	/**
	 * 授权管理员的信息
	 */
	@SerializedName("auth_user_info")
	private AuthUserInfo authUserInfo;
	
	/**
	 * 用户自定义的状态值，参数值由接口 获取注册码 指定。若未指定，则无该字段
	 */
	private String state;
	
	@Data
	public class ContractSync implements Serializable{

		private static final long serialVersionUID = 9010387210619876045L;
		
		/**
		 * 通讯录api接口调用凭证，有全部通讯录读写权限。（请注意与provider_access_token的区别）
		 */
		@SerializedName("access_token")
		private String accessToken;
		
		/**
		 * access_token凭证的有效时间（秒）
		 */
		@SerializedName("expires_id")
		private String expiresId;
	}
	
	@Data
	public class AuthUserInfo implements Serializable{

		private static final long serialVersionUID = -1474519424901908591L;
		
		/**
		 * 授权管理员的userid
		 */
		private String userid;
	}
}

