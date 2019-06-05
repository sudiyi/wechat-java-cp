package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新企业已配置的「联系我」方式-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91572
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactWaySend implements Serializable{

	
	private static final long serialVersionUID = -6884979673030096460L;

	/**
	 * 	企业联系方式的配置id
	 */
	private String configId;
	
	/**
	 * 	联系方式的备注信息，不超过30个字符，将覆盖之前的备注
	 */
	private String remark;
	
	/**
	 * 外部客户添加时是否无需验证
	 */
	private String skipVerify;
	
	/**
	 * 	样式，只针对“在小程序中联系”的配置生效
	 */
	private String style;
	
	/**
	 * 	企业自定义的state参数，用于区分不同的添加渠道，在调用“获取外部联系人详情”时会返回该参数值
	 */
	private String state;
	
	/**
	 * 使用该联系方式的用户列表，将覆盖原有用户列表
	 */
	private List<String> user;
	
	/**
	 * 	使用该联系方式的部门列表，将覆盖原有部门列表，只在配置的type为2时有效
	 */
	private List<String> party;
}
