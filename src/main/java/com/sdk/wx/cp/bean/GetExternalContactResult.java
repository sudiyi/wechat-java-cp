package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.sdk.wx.cp.bean.UserInfoResult.ExternalProfile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 外部联系人详情返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91571
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetExternalContactResult implements Serializable{

	private static final long serialVersionUID = 8412478149816171057L;
	
	private String errcode;
	
	private String errmsg;
	
	/**
	 * 外部联系人
	 */
	@SerializedName("external_contact")
	private ExternalContact externalContact;
	
	/**
	 * 跟进人
	 */
	@SerializedName("follow_user")
	private List<FollowUser> followUser;
	
	@Data
	public class ExternalContact implements Serializable{

		private static final long serialVersionUID = -5757704309278790324L;
		
		/**
		 * 外部联系人的userid
		 */
		private String externalUserid;
		
		/**
		 * 外部联系人的姓名或别名
		 */
		private String name;
		
		/**
		 * 外部联系人的职位，如果外部企业或用户选择隐藏职位，则不返回，仅当联系人类型是企业微信用户时有此字段
		 */
		private String position;
		
		/**
		 * 外部联系人头像，第三方不可获取
		 */
		private String avatar;
		
		/**
		 * 外部联系人所在企业的简称，仅当联系人类型是企业微信用户时有此字段
		 */
		private String corpName;
		
		/**
		 * 外部联系人所在企业的主体名称，仅当联系人类型是企业微信用户时有此字段
		 */
		private String corpFullName;
		
		/**
		 * 	外部联系人的类型，1表示该外部联系人是微信用户，2表示该外部联系人是企业微信用户
		 */
		private String type;
		
		/**
		 * 外部联系人性别 0-未知 1-男性 2-女性
		 */
		private String gender;
		
		/**
		 * 外部联系人在微信开放平台的唯一身份标识（微信unionid），通过此字段企业可将外部联系人与公众号/小程序用户关联起来。仅当联系人类型是微信用户，且企业绑定了微信开发者ID有此字段。查看绑定方法
		 */
		private String unionid;
		
		/**
		 * 外部联系人的自定义展示信息，可以有多个字段和多种类型，包括文本，网页和小程序，仅当联系人类型是企业微信用户时有此字段，字段详情见对外属性；
		 */
		@SerializedName("externalProfile")
		private ExternalProfile externalProfile;
		
	}
	
	@Data
	public class FollowUser implements Serializable{

		private static final long serialVersionUID = 5559300158781094776L;
		
		/**
		 * 	添加了此外部联系人的企业成员userid
		 */
		private String userid;
		
		/**
		 * 	该成员对此外部联系人的备注
		 */
		private String remark;
		
		/**
		 * 该成员对此外部联系人的描述
		 */
		private String description;
		
		/**
		 * 	该成员添加此外部联系人的时间
		 */
		private String createtime;
		
		/**
		 * 
		 */
		private List<FollowTags> tags;
		
		/**
		 * 	该成员对此客户备注的企业名称
		 */
		@SerializedName("remark_company")
		private String remarkCompany;
		
		/**
		 * 	该成员添加此客户的渠道，由用户通过创建「联系我」方式指定
		 */
		private String state;
		
		/**
		 * 	该成员对此客户备注的手机号码
		 */
		@SerializedName("remark_mobiles")
		private List<String> remarkMobiles;
	}
	
	@Data
	public class FollowTags implements Serializable{

		private static final long serialVersionUID = -2094124300911905071L;
		
		/**
		 * 	该成员添加此外部联系人所打标签的分组名称（标签功能需要企业微信升级到2.7.5及以上版本）
		 */
		private String groupName;
		
		/**
		 * 该成员添加此外部联系人所打标签名称
		 */
		private String tagName;
		
		/**
		 * 该成员添加此外部联系人所打标签类型, 1-企业设置, 2-用户自定义
		 */
		private String type;
	}
}
