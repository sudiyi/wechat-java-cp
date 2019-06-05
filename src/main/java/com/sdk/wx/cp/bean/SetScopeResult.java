package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设置授权应用可见范围返回实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90583
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetScopeResult implements Serializable{

	private static final long serialVersionUID = 1018211412146291995L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 非法成员列表
	 */
	private List<String> invaliduser;
	
	/**
	 * 非法部门列表
	 */
	private List<String> invalidparty;
	
	/**
	 * 非法标签列表
	 */
	private List<String> invalidtag;
	
	
}
