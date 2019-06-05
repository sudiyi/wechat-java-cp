package com.sdk.wx.cp.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 配置客户联系「联系我」方式 -返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91572
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddContactWayResult implements Serializable{

	private static final long serialVersionUID = 6397475547822122593L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 	新增联系方式的配置id
	 */
	@SerializedName("config_id")
	private String configId;
}
