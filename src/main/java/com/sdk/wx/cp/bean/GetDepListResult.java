package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取部门列表返回结果
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90344
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDepListResult implements Serializable{

	private static final long serialVersionUID = 8144162314073859153L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 部门列表数据。
	 */
	private List<DepartmentInfo> department;
}
