package com.sdk.wx.cp.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业群发消息发送结果-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91574
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetGroupMsgSend implements Serializable{

	private static final long serialVersionUID = 2346670489137045772L;

	/**
	 * 群发消息的id，通过添加企业群发消息模板接口返回
	 */
	private String msgid;
}
