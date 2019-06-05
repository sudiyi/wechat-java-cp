package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 添加企业群发消息模板-返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91573
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMsgTemplateResult implements Serializable{

	private static final long serialVersionUID = 1101422374994347462L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 无效或无法发送的external_userid列表
	 */
	@SerializedName("fail_list")
	private List<String> failList;
	
	/**
	 * 企业群发消息的id，可用于获取群发消息发送结果
	 */
	private String msgid;
}
