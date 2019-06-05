package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新任务卡片消息状态-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91585
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskCardSend implements Serializable{

	private static final long serialVersionUID = -6871207736790467780L;

	/**
	 * 企业的成员ID列表（消息接收者，最多支持1000个）。
	 */
	private String[] userids;
	
	/**
	 * 	应用的agentid
	 */
	private String agentid;
	
	/**
	 * 发送任务卡片消息时指定的task_id
	 */
	@SerializedName("task_id")
	private String taskId;
	
	/**
	 * 设置指定的按钮为选择状态，需要与发送消息时指定的btn:key一致
	 */
	@SerializedName("clicked_key")
	private String clickedKey;
}
