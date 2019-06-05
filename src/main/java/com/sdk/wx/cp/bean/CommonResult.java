package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基础返回实体
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult implements Serializable{

	private static final long serialVersionUID = -6735703949094071471L;

	private String errcode;
	
	private String errmsg;
	
}
