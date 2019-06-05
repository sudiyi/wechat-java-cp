package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业永久授权码返回实体
 * 企业微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90603
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPermanentCodeResult implements Serializable{

	private static final long serialVersionUID = -3587813968185483418L;

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
	
	/**
	 * 企业微信永久授权码,最长为512字节
	 */
	@SerializedName("permanent_code")
	private String permanentCode;
	
	/**
	 * 代理服务商企业信息
	 */
	@SerializedName("dealer_corp_info")
	private DealerCorpInfo dealerCorpInfo;
	
	/**
	 * 授权方企业信息
	 */
	@SerializedName("auth_corp_info")
	private AuthCorpInfo authCorpInfo;
	
	@SerializedName("auth_info")
	private AuthInfo authInfo;
	
	@SerializedName("auth_user_info")
	private AuthUserInfo authUserInfo;
	
	
	/**
	 * 代理服务商企业信息
	 * @author yangtao
	 * @date 2019/05/24
	 */
	@Data
	public class DealerCorpInfo implements Serializable{

		private static final long serialVersionUID = 4737750813388426578L;
		
		/**
		 * 代理服务商企业微信id
		 */
		private String corpid;
		
		/**
		 * 代理服务商企业微信名称
		 */
		@SerializedName("corp_name")
		private String corpName;
	}
	
	@Data
	public class AuthCorpInfo implements Serializable{

		private static final long serialVersionUID = 7342297172515797050L;
		
		/**
		 * 授权方企业微信id
		 */
		private String corpid;

		/**
		 * 授权方企业名称，即企业简称
		 */
		@SerializedName("corp_name")
		private String corpName;
		
		/**
		 * 授权方企业类型，认证号：verified, 注册号：unverified
		 */
		@SerializedName("corp_type")
		private String corpType;
		
		/**
		 * 授权方企业方形头像
		 */
		@SerializedName("corp_square_logo_url")
		private String corpSquareLogoUrl;
		
		/**
		 * corp_user_max
		 */
		@SerializedName("corp_user_max")
		private String corpUserMax;
		
		/**
		 * 
		 */
		@SerializedName("corp_agent_max")
		private String corpAgentMax;
		
		/**
		 * 授权方企业的主体名称(仅认证或验证过的企业有)，即企业全称。
		 */
		@SerializedName("corp_full_name")
		private String corpFullName;
		
		/**
		 * 认证到期时间
		 */
		@SerializedName("verified_end_time")
		private String verifiedEndTime;
		
		/**
		 * 企业类型，1. 企业; 2. 政府以及事业单位; 3. 其他组织, 4.团队号
		 */
		@SerializedName("subject_type")
		private String subjectType;
		
		/**
		 * 授权企业在微工作台（原企业号）的二维码，可用于关注微工作台
		 */
		@SerializedName("corp_wxqrcode")
		private String corpWxqrcode;
		
		/**
		 * 企业规模。当企业未设置该属性时，值为空
		 */
		@SerializedName("corp_scale")
		private String corpScale;
		
		/**
		 * 企业所属行业。当企业未设置该属性时，值为空
		 */
		@SerializedName("corp_industry")
		private String corpIndustry;
		
		/**
		 * 企业所属子行业。当企业未设置该属性时，值为空
		 */
		@SerializedName("corp_sub_industry")
		private String corpSubIndustry;
		
		/**
		 * 企业所在地信息, 为空时表示未知
		 */
		private String location;
	}
	
	/**
	 * 授权信息。如果是通讯录应用，且没开启实体应用，是没有该项的。通讯录应用拥有企业通讯录的全部信息读写权限
	 * @author yangtao
	 * @date 2019/05/24
	 */
	@Data
	public class AuthInfo implements Serializable{
		private static final long serialVersionUID = -4563922190876896438L;
		
		/**
		 * 授权的应用信息，注意是一个数组，但仅旧的多应用套件授权时会返回多个agent，对新的单应用授权，永远只返回一个agent
		 */
		private List<Agent> agent;
	}
	
	@Data
	public class Agent implements Serializable{
		
		private static final long serialVersionUID = -9067259221157270631L;

		/**
		 * 授权方应用id
		 */
		private String agentid;
		
		/**
		 * 	授权方应用名字
		 */
		private String name;
		
		/**
		 * 	授权方应用圆形头像
		 */
		@SerializedName("round_logo_url")
		private String roundLogoUrl;
		
		/**
		 * 授权方应用方形头像
		 */
		@SerializedName("square_logo_url")
		private String squareLogoUrl;
		
		/**
		 * 旧的多应用套件中的对应应用id，新开发者请忽略
		 */
		private String appid;
		
		/**
		 * 应用对应的权限
		 */
		private Privilege privilege;
		
	}
	
	/**
	 * 应用对应的权限
	 * @author yangtao
	 * @date 2019/05/24
	 */
	@Data
	public class Privilege implements Serializable{

		private static final long serialVersionUID = 3707692036348455446L;
		
		private String level;
		
		/**
		 * 应用可见范围（部门）
		 */
		@SerializedName("allow_party")
		private List<String> allowParty;
		
		/**
		 * 应用可见范围（成员）
		 */
		@SerializedName("allow_user")
		private List<String> allowUser;
		
		/**
		 * 应用可见范围（标签）
		 */
		@SerializedName("allow_tag")
		private List<String> allowTag;
		
		/**
		 * 额外通讯录（部门）
		 */
		@SerializedName("extra_party")
		private List<String> extraParty;
		
		/**
		 * 额外通讯录（成员）
		 */
		@SerializedName("extra_user")
		private List<String> extraUser;
		
		/**
		 * 额外通讯录（标签）
		 */
		@SerializedName("extra_tag")
		private List<String> extraTag;
		
	}
	
	@Data
	public class AuthUserInfo implements Serializable{

		private static final long serialVersionUID = -5355022862605245907L;
		
		/**
		 * 授权管理员的userid，可能为空（内部管理员一定有，不可更改）
		 */
		private String userid;
		
		/**
		 * 授权管理员的name，可能为空（内部管理员一定有，不可更改）
		 */
		private String name;
		
		/**
		 * 授权管理员的头像url
		 */
		private String avatar;
	}
	
}
