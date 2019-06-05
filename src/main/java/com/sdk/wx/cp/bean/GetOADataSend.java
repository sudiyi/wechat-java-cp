package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询第三方应用审批申请当前状态-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91189
 * @author yangtao
 * @date 2019/06/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOADataSend implements Serializable{

	private static final long serialVersionUID = 7385985962477183986L;

	/**
	 * 	开发者发起申请时定义的审批单号（js-sdk）
	 */
	private String thirdNo;
}
