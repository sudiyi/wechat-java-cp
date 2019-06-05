package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量查询电子发票-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90423
 * @author yangtao
 * @date 2019/06/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceInfoBatchSend implements Serializable{

	private static final long serialVersionUID = -5667065181105905832L;

	/**
	 * 发票列表
	 */
	@SerializedName("item_list")
	private List<BatchItemList> itemList;
	
	public class BatchItemList implements Serializable{

		private static final long serialVersionUID = -8333024686188363251L;
		
		/**
		 * 	发票id
		 */
		@SerializedName("card_id")
		private String cardId;
		
		/**
		 * 加密code
		 */
		@SerializedName("encrypt_code")
		private String encryptCode;
	}
}
