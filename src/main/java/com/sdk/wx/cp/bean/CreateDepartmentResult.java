package com.sdk.wx.cp.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建部门返回实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90341
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDepartmentResult implements Serializable{

	private static final long serialVersionUID = 572869173509596073L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 创建的部门id
	 */
	private String id;
}
