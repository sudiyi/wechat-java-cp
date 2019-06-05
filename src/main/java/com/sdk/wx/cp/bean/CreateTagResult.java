package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建标签返回实体信息
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90346
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTagResult implements Serializable{

	private static final long serialVersionUID = -726622393296155175L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 标签id
	 */
	private String tagid;
}
