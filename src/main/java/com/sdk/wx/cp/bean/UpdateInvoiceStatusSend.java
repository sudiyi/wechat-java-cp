package com.sdk.wx.cp.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新发票状态请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90421
 * @author yangtao
 * @date 2019/06/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceStatusSend implements Serializable{

	private static final long serialVersionUID = -5229918675609412195L;

	/**
	 * 发票id
	 */
	@SerializedName("card_id")
	private String cardId;
	
	/**
	 * 	加密code
	 */
	@SerializedName("encypt_code")
	private String encryptCode;
	
	/**
	 * 发报销状态 INVOICE_REIMBURSE_INIT：发票初始状态，未锁定；INVOICE_REIMBURSE_LOCK：发票已锁定，无法重复提交报销;INVOICE_REIMBURSE_CLOSURE:发票已核销，从用户卡包中移除
	 */
	@SerializedName("reimburse_status")
	private String reimburseStatus;
}
