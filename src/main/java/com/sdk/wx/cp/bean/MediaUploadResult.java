package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 上传媒体文件返回信息实体
 * 微信接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90389
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaUploadResult implements Serializable{

	private static final long serialVersionUID = 5084470653080357673L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)
	 */
	private String type;
	
	/**
	 * 媒体文件上传后获取的唯一标识，3天内有效
	 */
	@SerializedName("media_id")
	private String mediaId;
	
	/**
	 * 媒体文件上传时间戳
	 */
	@SerializedName("created_at")
	private String createdAt;
}
