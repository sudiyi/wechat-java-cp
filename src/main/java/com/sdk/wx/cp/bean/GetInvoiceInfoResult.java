package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询电子发票返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90420
 * @author yangtao
 * @date 2019/06/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceInfoResult implements Serializable{

	private static final long serialVersionUID = -3525201497289972069L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 	发票id
	 */
	@SerializedName("card_id")
	private String cardId;
	
	/**
	 * 发票的有效期起始时间
	 */
	@SerializedName("begin_time")
	private String beginTime;
	
	/**
	 * 发票的有效期截止时间
	 */
	@SerializedName("end_time")
	private String endTime;
	
	/**
	 * 用户标识
	 */
	private String openid;
	
	/**
	 * 	发票类型，如广东增值税普通发票
	 */
	private String type;
	
	/**
	 * 发票的收款方
	 */
	private String payee;
	
	/**
	 * 	发票详情
	 */
	private String detail;
	
	/**
	 * 发票的用户信息，见user_info结构说明
	 */
	@SerializedName("user_info")
	private InvoiceUserInfo userInfo;
	
	@Data
	public class InvoiceUserInfo implements Serializable{

		private static final long serialVersionUID = 4129489714941373064L;
		
		/**
		 * 	发票加税合计金额，以分为单位
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
		 * 发票号码
		 */
		@SerializedName("billing_code")
		private String billingCode;
		
		/**
		 * 商品信息结构，见下方说明
		 */
		private List<InvoiceUserInfoItem> info;
		
		/**
		 * 不含税金额，以分为单位
		 */
		@SerializedName("fee_without_tax")
		private String feeWithoutTax;
		
		/**
		 * 
		 */
		private String tax;
		
		/**
		 * 	发票详情，一般描述的是发票的使用说明
		 */
		private String detail;
		
		/**
		 * 这张发票对应的PDF_URL
		 */
		@SerializedName("pdf_url")
		private String pdfUrl;
		
		/**
		 * 发报销状态INVOICE_REIMBURSE_INIT：发票初始状态，未锁定；INVOICE_REIMBURSE_LOCK：发票已锁定；INVOICE_REIMBURSE_CLOSURE：发票已核销
		 */
		@SerializedName("reimburse_status")
		private String reimburseStatus;
		
	}
	
	@Data
	public class InvoiceUserInfoItem implements Serializable{

		private static final long serialVersionUID = 5661032106172339908L;
		
		/**
		 * 项目（商品）名称
		 */
		private String name;
		
		/**
		 * 	项目数量
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
		 * 	单价，以分为单位
		 */
		private String price;
	}
}
