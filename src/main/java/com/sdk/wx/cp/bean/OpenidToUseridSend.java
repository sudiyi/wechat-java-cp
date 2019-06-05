package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * openID 换 userid
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90338
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenidToUseridSend implements Serializable{

	private static final long serialVersionUID = -3863080349403184612L;

	/**
	 * 在使用企业支付之后，返回结果的openid
	 */
	private String openid;
}
