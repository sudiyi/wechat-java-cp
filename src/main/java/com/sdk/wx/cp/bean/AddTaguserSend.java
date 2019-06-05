package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 增加标签成员请求实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90350
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTaguserSend implements Serializable{

	private static final long serialVersionUID = -8401105450913377671L;

	/**
	 * 标签ID
	 */
	private String tagid;
	
	/**
	 * 企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过1000
	 */
	private String[] userlist;
	
	/**
	 * 企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过100
	 */
	private String[] partylist;
}
