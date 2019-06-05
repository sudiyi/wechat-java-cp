package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取员工行为数据-返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91584
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserBehaviorResult implements Serializable{

	private static final long serialVersionUID = -4732650449540644203L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 
	 */
	@SerializedName("behavior_data")
	private List<BehaviorData> behaviorData;
	
	@Data
	public class BehaviorData implements Serializable{

		private static final long serialVersionUID = 9000219888612663038L;
		
		/**
		 * 	数据日期，为当日0点的时间戳
		 */
		@SerializedName("stat_time")
		private String statTime;
		
		/**
		 * 成员有主动发送过消息的聊天数，包括单聊和群聊
		 */
		@SerializedName("chat_cnt")
		private String chatCnt;
		
		/**
		 * 成员在单聊和群聊中发送的消息总数
		 */
		@SerializedName("message_cnt")
		private String messageCnt;
		
		/**
		 * 已回复聊天占比，即客户主动发起聊天后，成员在一个自然日内有回复过消息的聊天数/客户主动发起的聊天数比例，不包括群聊
		 */
		@SerializedName("reply_percentage")
		private String replyPercentage;
		
		/**
		 * 平均首次回复时长，单位为分钟，即客户主动发起聊天后，成员在一个自然日内首次回复的时长间隔为首次回复时长，所有聊天的首次回复总时长/已回复的聊天总数即为平均首次回复时长，不包括群聊
		 */
		@SerializedName("avg_reply_time")
		private String avgReplyTime;
	}
}
