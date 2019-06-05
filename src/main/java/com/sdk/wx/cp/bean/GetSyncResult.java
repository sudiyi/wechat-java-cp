package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取异步任务结果返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91133
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSyncResult implements Serializable{

	private static final long serialVersionUID = -146051967600417048L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 任务状态，整型，1表示任务开始，2表示任务进行中，3表示任务已完成
	 */
	private String status;
	
	/**
	 * 操作类型，字节串，目前分别有：1. sync_user(增量更新成员) 2. replace_user(全量覆盖成员)3. replace_party(全量覆盖部门)
	 */
	private String type;
	
	/**
	 * 	任务运行总条数
	 */
	private String total;
	
	/**
	 * 	目前运行百分比，当任务完成时为100
	 */
	private String percentag;
	
	/**
	 * 	详细的处理结果，具体格式参考下面说明。当任务完成后此字段有效
	 */
	private List<SyncResultDetail> result;
	
	@Data
	public class SyncResultDetail implements Serializable{

		private static final long serialVersionUID = 1964475760971148029L;
		
		/**
		 * 成员UserID。对应管理端的帐号
		 */
		private String userid;
		
		private String errcode;
		
		private String errmsg;
		
		/**
		 * 操作类型（按位或）：1 新建部门 ，2 更改部门名称， 4 移动部门， 8 修改部门排序
		 */
		private String action;
		
		/**
		 * 部门ID
		 */
		private String partyid;
	}
}
