package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取离职成员的客户列表-返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91575
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUnassignedListResult implements Serializable{

	private static final long serialVersionUID = 6228589665382641776L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 离职员工信息
	 */
	private List<UnassignedInfo> info;
	
	/**
	 * 	是否是最后一条记录
	 */
	@SerializedName("is_last")
	private String isLast;
	
	public class UnassignedInfo implements Serializable{

		private static final long serialVersionUID = 7263470754045087288L;
		
		/**
		 * 离职成员的userid
		 */
		@SerializedName("handover_userid")
		private String handoverUserid;
		
		/**
		 * 外部联系人userid
		 */
		@SerializedName("external_userid")
		private String externalUserid;
		
		/**
		 * 成员离职时间
		 */
		@SerializedName("dimission_time")
		private String dimissionTime;
	}
}
