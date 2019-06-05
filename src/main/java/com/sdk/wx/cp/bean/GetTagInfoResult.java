package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取标签成员返回信息实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90349
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTagInfoResult implements Serializable{

	private static final long serialVersionUID = -2493433666715324438L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 标签名
	 */
	private String tagname;
	
	/**
	 * 标签中包含的成员列表
	 */
	private List<TagUser> userlist;
	
	/**
	 * 	标签中包含的部门id列表
	 */
	private List<String> partylist;
	
	@Data
	public class TagUser implements Serializable{

		private static final long serialVersionUID = 1L;
		
		/**
		 * 成员帐号
		 */
		private String userid;
		
		/**
		 * 成员名
		 */
		private String name;
	}
}
