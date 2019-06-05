package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量更新发票状态-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90422
 * @author yangtao
 * @date 2019/06/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusBatchSend implements Serializable{

	private static final long serialVersionUID = 4094073704322509165L;

	/**
	 * 用户openid，可用“userid与openid互换接口”获取
	 */
	private String openid;
	
	/**
	 * 发票报销状态 INVOICE_REIMBURSE_INIT：发票初始状态，未锁定；INVOICE_REIMBURSE_LOCK：发票已锁定，无法重复提交报销;INVOICE_REIMBURSE_CLOSURE:发票已核销，从用户卡包中移除
	 */
	@SerializedName("reimburse_status")
	private String reimburseStatus;
	
	/**
	 * 发票列表，必须全部属于同一个openid
	 */
	@SerializedName("invoice_list")
	private List<BatchInvoiceList> invoiceList;
	
	@Data
	public class BatchInvoiceList implements Serializable{

		private static final long serialVersionUID = -2148273190604860025L;
		
		/**
		 * 发票卡券的card_id
		 */
		@SerializedName("card_id")
		private String cardId;
		
		/**
		 * 发票卡券的加密code，和card_id共同构成一张发票卡券的唯一标识
		 */
		@SerializedName("encrypt_code")
		private String encryptCode;
		
	}
}
