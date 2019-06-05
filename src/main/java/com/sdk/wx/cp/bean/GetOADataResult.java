package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询第三方应用审批申请当前状态-返回实体信息
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91189
 * @author yangtao
 * @date 2019/06/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOADataResult implements Serializable{

	private static final long serialVersionUID = 233486883862565847L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 审批信息
	 */
	private OAData data;
	
	@Data
	public class OAData implements Serializable{

		private static final long serialVersionUID = -3177944247872417721L;
		
		/**
		 * 	审批单编号，由开发者在发起申请时自定义
		 */
		@SerializedName("ThirdNo")
		private String thirdNo;
		
		/**
		 * 	审批模板id
		 */
		@SerializedName("OpenTemplateId")
		private String openTemplateId;
		
		/**
		 * 审批模板名称
		 */
		@SerializedName("OpenSpName")
		private String openSpName;
		
		/**
		 * 申请单当前审批状态：1-审批中；2-已通过；3-已驳回；4-已取消
		 */
		@SerializedName("OpenSpstatus")
		private String openSpstatus;
		
		/**
		 * 	提交申请时间
		 */
		@SerializedName("ApplyTime")
		private String applyTime;
		
		/**
		 * 	提交者姓名
		 */
		@SerializedName("ApplyUsername")
		private String applyUsername;
		
		/**
		 * 	提交者所在部门
		 */
		@SerializedName("ApplyUserParty")
		private String applyUserParty;
		
		/**
		 * 	提交者头像
		 */
		@SerializedName("ApplyUserImage")
		private String applyUserImage;
		
		/**
		 * 	提交者userid
		 */
		@SerializedName("ApplyUserId")
		private String applyUserId;
		
		/**
		 * 	审批流程信息
		 */
		@SerializedName("ApprovalNodes")
		private OADataApprovalNodes approvalNodes;
		
		/**
		 * 	抄送信息，可能有多个抄送人
		 */
		@SerializedName("NotifyNodes")
		private OADataNotifyNodes notifyNodes;
		
		/**
		 * 当前审批节点：0-第一个审批节点；1-第二个审批节点…以此类推
		 */
		private String approverstep;
	}
	
	@Data
	public class OADataApprovalNodes implements Serializable{

		private static final long serialVersionUID = -3312368657060037945L;
		
		/**
		 * 	审批流程信息，可以有多个审批节点
		 */
		@SerializedName("ApprovalNode")
		private List<OADataApprovalNode> approvalNode;
	}
	
	@Data
	public class OADataApprovalNode implements Serializable{

		private static final long serialVersionUID = 5777837491085396803L;
		
		/**
		 * 	节点审批操作状态：1-审批中；2-已同意；3-已驳回；4-已转审
		 */
		@SerializedName("NodeStatus")
		private String nodeStatus;
		
		/**
		 * 审批节点属性：1-或签；2-会签
		 */
		@SerializedName("NodeAttr")
		private String nodeAttr;
		
		/**
		 * 	审批节点类型：1-固定成员；2-标签；3-上级
		 */
		@SerializedName("NodeType")
		private String nodeType;
		
		/**
		 * 	审批节点信息，当节点为标签或上级时，一个节点可能有多个分支
		 */
		@SerializedName("Items")
		private OADataApprovalNodeItems items;
		
	}
	
	@Data
	public class OADataApprovalNodeItems implements Serializable{

		private static final long serialVersionUID = 7678026325585099617L;
		
		/**
		 * 审批节点分支，当节点为标签或上级时，一个节点可能有多个分支
		 */
		@SerializedName("Item")
		private List<OADataApprovalNodeItem> item;
	}
	
	@Data
	public class OADataApprovalNodeItem implements Serializable{

		private static final long serialVersionUID = 7673985059654418327L;
		
		/**
		 * 	分支审批人姓名
		 */
		@SerializedName("ItemName")
		private String itemName;
		
		/**
		 * 	分支审批人所在部门
		 */
		@SerializedName("ItemParty")
		private String itemParty;
		
		/**
		 * 	分支审批人头像
		 */
		@SerializedName("ItemImage")
		private String itemImage;
		
		/**
		 * 分支审批人userid
		 */
		@SerializedName("ItemUserId")
		private String itemUserId;
		
		/**
		 * 	分支审批审批操作状态：1-审批中；2-已同意；3-已驳回；4-已转审
		 */
		@SerializedName("ItemStatus")
		private String itemStatus;
		
		/**
		 * 	分支审批人审批意见
		 */
		@SerializedName("ItemSpeech")
		private String itemSpeech;
		
		/**
		 * 	分支审批人操作时间
		 */
		@SerializedName("ItemOpTime")
		private String itemOpTime;
	}
	
	@Data
	public class OADataNotifyNodes implements Serializable{

		private static final long serialVersionUID = 6238239301964859001L;
		
		/**
		 * 	抄送人信息
		 */
		@SerializedName("NotifyNode")
		private List<OADataNotifyNode> notifyNode;
	}
	
	@Data
	public class OADataNotifyNode implements Serializable{

		private static final long serialVersionUID = -7018164373703641187L;
		
		/**
		 * 	抄送人姓名
		 */
		@SerializedName("ItemName")
		private String itemName;
		
		/**
		 * 	抄送人所在部门
		 */
		@SerializedName("ItemParty")
		private String itemParty;
		
		/**
		 * 	抄送人头像
		 */
		@SerializedName("ItemImage")
		private String itemImage;
		
		/**
		 * 	抄送人userid
		 */
		@SerializedName("itemUserId")
		private String ItemUserId;
	}
}
