package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * userid 换 openID请求实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90338
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UseridToOpenidSend implements Serializable{

	private static final long serialVersionUID = 2306548104517996829L;

	/**
	 * 	企业内的成员id
	 */
	private String userid;
}
