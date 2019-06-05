package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * userid 换 openid返回实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90338
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UseridToOpenidResult implements Serializable{

	private static final long serialVersionUID = 9096532689453105359L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 	企业微信成员userid对应的openid
	 */
	private String openid;
}
