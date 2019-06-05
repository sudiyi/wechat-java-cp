package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业微信服务器的ip段-返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91116
 * @author yangtao
 * @date 2019/05/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCallbackIpResult implements Serializable{

	private static final long serialVersionUID = -7343220170497446678L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 企业微信回调IP段
	 */
	@SerializedName("ip_list")
	private String[] ipList;
}
