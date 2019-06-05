package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * openID 换 userid 返回结果实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90338
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenidToUseridResult implements Serializable{

	private static final long serialVersionUID = -5520477276270714454L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 该openid在企业微信对应的成员userid
	 */
	private String userid;
}
