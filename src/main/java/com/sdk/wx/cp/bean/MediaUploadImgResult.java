package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 上传永久图片返回信息实体
 * 企业微信接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90392
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaUploadImgResult implements Serializable{

	private static final long serialVersionUID = 5502380958084693661L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 上传后得到的图片URL。永久有效
	 */
	private String url;
}
