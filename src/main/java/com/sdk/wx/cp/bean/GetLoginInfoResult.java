package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 获取登录用户信息返回实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91125
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLoginInfoResult implements Serializable{

	private static final long serialVersionUID = 6117346393292427738L;

	private String errcode;
	
	private String errormsg;
	
	/**
	 * 登录用户的类型：1.创建者 2.内部系统管理员 3.外部系统管理员 4.分级管理员 5.成员
	 */
	private String usertype;
	
	/**
	 * 登录用户的信息
	 */
	@SerializedName("user_info")
	private LoginUserInfo userInfo;
	
	/**
	 * 授权方企业信息
	 */
	@SerializedName("corp_info")
	private CorpInfo corpInfo;
	
	/**
	 * 该管理员在该提供商中能使用的应用列表，当登录用户为管理员时返回
	 */
	private List<Agent> agent;
	
	/**
	 * 该管理员拥有的通讯录权限，当登录用户为管理员时返回
	 */
	@SerializedName("auth_info")
	private AuthInfo authInfo;
	
	@Data
	public class LoginUserInfo implements Serializable{
		
		private static final long serialVersionUID = -3201818003919250429L;
		
		/**
		 * 登录用户的userid，登录用户在通讯录中时返回
		 */
		private String userid;
		
		/**
		 * 	登录用户的名字，登录用户在通讯录中时返回
		 */
		private String name;
		
		/**
		 * 登录用户的头像，登录用户在通讯录中时返回
		 */
		private String avatar;
		
	}
	
	@Data
	public class CorpInfo implements Serializable{
		
		private static final long serialVersionUID = -1231403433481751441L;
		
		/**
		 * 授权方企业id
		 */
		private String corpid;
	}
	
	@Data
	public class Agent implements Serializable{

		private static final long serialVersionUID = 1L;
		
		/**
		 * 	应用id
		 */
		private String agentid;
		
		/**
		 * 该管理员对应用的权限：1.管理权限，0.使用权限
		 */
		@SerializedName("auth_type")
		private String authType;
	}
	
	@Data
	public class AuthInfo implements Serializable{

		private static final long serialVersionUID = 8221525480557347779L;
		
		private List<Department> department;
	}
	
	@Data
	public class Department implements Serializable{

		private static final long serialVersionUID = 4474573843480474294L;
		
		private String id;
		
		private String writable;
	}
}
