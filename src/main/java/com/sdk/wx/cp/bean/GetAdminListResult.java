package com.sdk.wx.cp.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取应用管理员列表返回实体
 * 企业微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90606
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAdminListResult implements Serializable{
	 
	private static final long serialVersionUID = -5724370888164435841L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 应用管理员列表
	 */
	private Admin admin;
	
	/**
	 * 应用的管理员列表（不包括外部管理员）
	 * @author yangtao
	 * @date 2019/05/24
	 */
	@Data
	public static class Admin implements Serializable{
		
		private static final long serialVersionUID = 9165276265279324725L;

		/**
		 * 	管理员的userid
		 */
		private String userid;
		
		/**
		 * 该管理员对应用的权限：0=发消息权限，1=管理权限
		 */
		private String authType;
	}
}
