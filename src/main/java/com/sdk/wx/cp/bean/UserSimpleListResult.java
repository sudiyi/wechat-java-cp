package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取部门成员返回实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90336
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSimpleListResult implements Serializable{

	private static final long serialVersionUID = 7980709938351282159L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 	成员列表
	 */
	private List<UserList> userlist;
	
	@Data
	public class UserList implements Serializable{

		private static final long serialVersionUID = 807332366857780953L;
		
		/**
		 * 成员UserID。对应管理端的帐号
		 */
		private String userid;
		
		/**
		 * 	成员名称
		 */
		private String name;
		
		/**
		 * 	成员所属部门列表。列表项为部门ID，32位整型
		 */
		private List<String> department;
	}
	
}
