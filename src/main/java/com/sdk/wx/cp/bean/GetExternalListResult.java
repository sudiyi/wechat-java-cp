package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取外部联系人列表-返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91570
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetExternalListResult implements Serializable{

	private static final long serialVersionUID = -7484775222370394905L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 	外部联系人的userid列表
	 */
	@SerializedName("external_userid")
	private List<String> externalUserid;
}
