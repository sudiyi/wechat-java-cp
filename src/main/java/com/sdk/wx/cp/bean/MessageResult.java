package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发送消息返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90372
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResult implements Serializable{

	private static final long serialVersionUID = -445267571324364231L;

	private String errcode;
	
	private String errMsg;
	
	/**
	 * 无效用户
	 */
	private String invaliduser;
	
	/**
	 * 无效部门
	 */
	private String invalidparty;
	
	/**
	 * 无效标签
	 */
	private String invalidtag;
}
