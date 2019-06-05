package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量查询电子发票返回实体信息
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90423
 * @author yangtao
 * @date 2019/06/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceInfoBatchResult implements Serializable{

	private static final long serialVersionUID = 8078942146833329390L;

	private String errcode;
	
	private String errmsg;
	
	@SerializedName("item_list")
	private List<GetBatchItemList> itemList;
	
	@Data
	public class GetBatchItemList implements Serializable{

		private static final long serialVersionUID = -2064510540053156121L;
		
		/**
		 * 发票id
		 */
		@SerializedName("card_id")
		private String cardId;
		
		/**
		 * 	用户标识
		 */
		private String openid;
		
		/**
		 * 	发票类型，如广东增值税普通发票
		 */
		private String type;
		
		/**
		 * 	发票的收款方
		 */
		private String payee;
		
		/**
		 * 	发票详情
		 */
		private String detail;
		
		/**
		 * 	发票的用户信息，见user_info结构说明
		 */
		@SerializedName("user_info")
		private ItemListUserInfo userInfo;
		
	}
	
	@Data
	public class ItemListUserInfo implements Serializable{

		private static final long serialVersionUID = 4105912544675366243L;
		
		/**
		 * 发票加税合计金额，以分为单位
		 */
		private String fee;
		
		/**
		 * 	发票的抬头
		 */
		private String title;
		
		/**
		 * 	开票时间，为十位时间戳
		 */
		@SerializedName("billing_time")
		private String billingTime;
		
		/**
		 * 	发票代码
		 */
		@SerializedName("billing_no")
		private String billingNo;
		
		/**
		 * 	发票号码
		 */
		@SerializedName("billing_code")
		private String billingCode;
		
		/**
		 * 商品信息
		 */
		private List<ItemListUserInfoItem> info;
		
		/**
		 * 	不含税金额，以分为单位
		 */
		@SerializedName("fee_without_tax")
		private String feeWithOutTax;
		
		/**
		 * 
		 */
		private String tax;
		
		/**
		 * 	发票详情，一般描述的是发票的使用说明
		 */
		private String detail;
		
		/**
		 * 	这张发票对应的PDF_URL
		 */
		@SerializedName("pdf_url")
		private String pdfUrl;
		
		/**
		 * 发报销状态INVOICE_REIMBURSE_INIT：发票初始状态，未锁定；INVOICE_REIMBURSE_LOCK：发票已锁定；INVOICE_REIMBURSE_CLOSURE：发票已核销
		 */
		@SerializedName("reimburse_status")
		private String reimburseStatus;
		
		/**
		 * 
		 */
		@SerializedName("order_id")
		private String orderId;
		
		/**
		 * 	校验码
		 */
		@SerializedName("check_code")
		private String checkCode;
		
		/**
		 * 购买方纳税人识别号
		 */
		@SerializedName("buyer_number")
		private String buyerNumber;
		
	}
	
	@Data
	public class ItemListUserInfoItem implements Serializable{

		private static final long serialVersionUID = 4819290865681619698L;
		
		/**
		 * 	项目（商品）名称
		 */
		private String name;
		
		/**
		 * 项目数量
		 */
		private String num;
		
		/**
		 * 	项目单位
		 */
		private String unit;
		
		/**
		 * 
		 */
		private String fee;
		
		/**
		 * 单价，以分为单位
		 */
		private String price;
	}
}
