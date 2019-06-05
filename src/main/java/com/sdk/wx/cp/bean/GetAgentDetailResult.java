package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取应用详情返回实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90363
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAgentDetailResult implements Serializable{

	private static final long serialVersionUID = 2002169669447696905L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 	企业应用id
	 */
	private String agentid;
	
	/**
	 * 企业应用名称
	 */
	private String name;
	
	/**
	 * 企业应用方形头像
	 */
	@SerializedName("square_logo_url")
	private String squareLogoUrl;
	
	/**
	 * 企业应用详情
	 */
	private String description;
	
	/**
	 * 企业应用可见范围（人员），其中包括userid
	 */
	@SerializedName("allow_userinfos")	
	private AllowUserinfos allowUserinfos;
	
	/**
	 * 企业应用可见范围（部门）
	 */
	@SerializedName("allow_partys")
	private AllowPartys allowPartys;
	
	/**
	 * 企业应用可见范围（标签）
	 */
	@SerializedName("allow_tags")
	private AllowTags allowTags;
	
	/**
	 * 企业应用是否被停用
	 */
	private String close;
	
	/**
	 * 	企业应用可信域名
	 */
	@SerializedName("redirect_domain")
	private String redirectDomain;
	
	/**
	 * 企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；
	 */
	@SerializedName("report_location_flag")
	private String reportLocationFlag;
	
	/**
	 * 是否上报用户进入应用事件。0：不接收；1：接收
	 */
	private String isreportenter;
	
	/**
	 * 应用主页url
	 */
	@SerializedName("home_url")
	private String homeUrl;
	
	@Data
	public class AllowUserinfos implements Serializable{

		private static final long serialVersionUID = 5229084737759477883L;
		
		/**
		 * 
		 */
		private List<User> user;
	}
	
	@Data
	public class User implements Serializable{

		private static final long serialVersionUID = -4387236925266343648L;
		
		/**
		 * 
		 */
		private String userid;
	}
	
	@Data
	public class AllowPartys implements Serializable{

		private static final long serialVersionUID = -9101257553291658867L;
		
		private List<String> partyid;
	}
	
	@Data
	public class AllowTags implements Serializable{

		private static final long serialVersionUID = -3722060200864923644L;
		
		/**
		 * 
		 */
		private List<String> tagid;
	}
}
