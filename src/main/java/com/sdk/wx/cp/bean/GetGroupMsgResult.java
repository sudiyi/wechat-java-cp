package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业群发消息发送结果-返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91574
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetGroupMsgResult implements Serializable{

	private static final long serialVersionUID = 2035913783395897280L;

	private String errcode;
	
	private String errmsg;

	/**
	 * 模板消息的审核状态 0-审核中 1-审核成功 2-审核失败
	 */
	@SerializedName("check_status")
	private String checkStatus;
	
	/**
	 * 
	 */
	@SerializedName("detail_list")
	private List<DetailList> detailList;
	
	@Data
	public class DetailList implements Serializable{

		private static final long serialVersionUID = -1994836324438104319L;
		
		/**
		 * 外部联系人userid
		 */
		@SerializedName("external_userid")
		private String externalUserid;
		
		/**
		 * 	企业服务人员的userid
		 */
		private String userid;
		
		/**
		 * 发送状态 0-未发送 1-已发送 2-因客户不是好友导致发送失败 3-因客户已经收到其他群发消息导致发送失败
		 */
		private String status;
		
		/**
		 * 	发送时间，发送状态为1时返回
		 */
		@SerializedName("send_time")
		private String sendTime;
	}
}
