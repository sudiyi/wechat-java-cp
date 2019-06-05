package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取应用列表返回实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90363
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAgentListResult implements Serializable{

	private static final long serialVersionUID = 3473981783579585130L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 当前凭证可访问的应用列表
	 */
	private List<AgentInfo> agentlist;
	
	@Data
	public class AgentInfo implements Serializable{

		private static final long serialVersionUID = -291469739616966769L;
		
		/**
		 * 企业应用id
		 */
		private String agentid;
		
		/**
		 * 企业应用名称
		 */
		private String name;
		
		/**
		 * 企业应用方形头像url
		 */
		@SerializedName("square_logo_url")
		private String squareLogoUrl;
		
	}
}
