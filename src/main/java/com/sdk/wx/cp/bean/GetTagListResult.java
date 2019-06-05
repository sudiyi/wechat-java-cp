package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取标签列表返回信息实体
 * 接口文档地址
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTagListResult implements Serializable{

	private static final long serialVersionUID = 7503302733554430627L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 标签列表
	 */
	private List<TagInfo> taglist;
}
