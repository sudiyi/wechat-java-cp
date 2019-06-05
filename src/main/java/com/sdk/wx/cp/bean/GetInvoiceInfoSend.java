package com.sdk.wx.cp.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询电子发票-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90420
 * @author yangtao
 * @date 2019/06/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceInfoSend implements Serializable{

	private static final long serialVersionUID = -8233603606573019104L;

	/**
	 * 发票id
	 */
	@SerializedName("card_id")
	private String cardId;
	
	/**
	 * 加密code
	 */
	@SerializedName("encrypt_code")
	private String encryptCode;
}
