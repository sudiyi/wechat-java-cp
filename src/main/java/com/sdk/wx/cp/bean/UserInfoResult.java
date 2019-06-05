package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 读取成员信息实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90332
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResult implements Serializable{

	private static final long serialVersionUID = 754932938692504159L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节。只能由数字、字母和“_-@.”四种字符组成，且第一个字符必须是数字或字母。
	 */
	private String userid;
	
	/**
	 * 成员名称。长度为1~64个utf8字符
	 */
	private String name;
	
	/**
	 * 成员别名。长度1~32个utf8字符
	 */
	private String alias;
	
	/**
	 * 手机号码。企业内必须唯一，mobile/email二者不能同时为空
	 */
	private String mobile;
	
	/**
	 * 成员所属部门id列表,不超过20个
	 */
	private List<String> department;
	
	/**
	 * 部门内的排序值，默认为0，成员次序以创建时间从小到大排列。数量必须和department一致，数值越大排序越前面。有效的值范围是[0, 2^32)
	 */
	private List<String> order;
	
	/**
	 * 	职务信息。长度为0~128个字符
	 */
	private String position;
	
	/**
	 * 性别。1表示男性，2表示女性
	 */
	private String gender;
	
	/**
	 * 邮箱。长度6~64个字节，且为有效的email格式。企业内必须唯一，mobile/email二者不能同时为空
	 */
	private String email;
	
	/**
	 * 个数必须和department一致，表示在所在的部门内是否为上级。1表示为上级，0表示非上级。在审批等应用里可以用来标识上级审批人
	 */
	@SerializedName("is_leader_in_dept")
	private String isLeaderInDept;
	
	/**
	 * 启用/禁用成员。1表示启用成员，0表示禁用成员
	 */
	private String enable;
	
	/**
	 * 成员头像的mediaid，通过素材管理接口上传图片获得的mediaid
	 */
	private String avatar;
	
	/**
	 * 座机。32字节以内，由纯数字或’-‘号组成。
	 */
	private String telephone;
	
	/**
	 * 地址。长度最大128个字符
	 */
	private String address;
	
	/**
	 * 自定义字段。自定义字段需要先在WEB管理端添加，见扩展属性添加方法，否则忽略未知属性的赋值。与对外属性一致，不过只支持type=0的文本和type=1的网页类型，详细描述查看对外属性
	 */
	private Extattr extattr;
	
	/**
	 * 激活状态: 1=已激活，2=已禁用，4=未激活。
已激活代表已激活企业微信或已关注微工作台（原企业号）。未激活代表既未激活企业微信又未关注微工作台（原企业号）。
	 */
	private String status;
	
	/**
	 * 员工个人二维码，扫描可添加为外部联系人；第三方仅通讯录应用可获取
	 */
	@SerializedName("qr_code")
	private String qrCode;
	
	/**
	 * 对外职务，如果设置了该值，则以此作为对外展示的职务，否则以position来展示。长度12个汉字内
	 */
	@SerializedName("external_position")
	private String externalPosition;
	
	/**
	 * 成员对外属性，字段详情见对外属性
	 */
	@SerializedName("external_profile")
	private ExternalProfile externalProfile;
	
	/////////////以下实体字段接口文档未说明///////////////
	
	@Data
	public class Extattr implements Serializable{

		private static final long serialVersionUID = 8226673732184793334L;
		
		/**
		 * 
		 */
		private List<Attrs> attrs;
		
	}
	
	@Data
	public class Attrs implements Serializable{

		private static final long serialVersionUID = -1388607892199945377L;
		
		/**
		 * 
		 */
		private String type;
		
		/**
		 * 
		 */
		private String name;
		
		/**
		 * 
		 */
		private AttrsText text;
		
		/**
		 * 
		 */
		private AttrsWeb web;
		
		/**
		 * 
		 */
		private AttrsMiniprogram miniprogram;
		
	}
	
	@Data
	public class AttrsText implements Serializable{

		private static final long serialVersionUID = 3146785087762014468L;
		
		/**
		 * 
		 */
		private String value;
	}
	
	@Data
	public class AttrsWeb implements Serializable{

		private static final long serialVersionUID = -7142858052804687594L;
		
		/**
		 * 
		 */
		private String url;
		
		/**
		 * 
		 */
		private String title;
	}
	
	@Data
	public class AttrsMiniprogram implements Serializable{

		private static final long serialVersionUID = 8704424456439615814L;
		
		/**
		 * 
		 */
		private String appid;
		
		/**
		 * 
		 */
		private String pagepath;
		
		/**
		 * 
		 */
		private String title;
	}
	
	@Data
	public class ExternalProfile implements Serializable{

		private static final long serialVersionUID = 4610960993127042299L;
		
		/**
		 * 
		 */
		@SerializedName("wxternal_corp_name")
		private String externalCorpName;
		
		/**
		 * 
		 */
		@SerializedName("external_attr")
		private List<Attrs> externalAttr;
	}

}
