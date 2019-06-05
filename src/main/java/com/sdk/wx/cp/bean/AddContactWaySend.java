package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 配置客户联系「联系我」方式-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91572
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddContactWaySend implements Serializable{

	private static final long serialVersionUID = 3927439735264566093L;

	/**
	 * 	联系方式类型,1-单人, 2-多人
	 */
	private String type;
	
	/**
	 * 	场景，1-在小程序中联系，2-通过二维码联系
	 */
	private String scene;
	
	/**
	 * 在小程序中联系时使用的控件样式，详见附表
	 */
	private String style;
	
	/**
	 * 联系方式的备注信息，用于助记，不超过30个字符
	 */
	private String remark;
	
	/**
	 * 	外部客户添加时是否无需验证，默认为true
	 */
	@SerializedName("skip_verify")
	private String skipVerify;
	
	/**
	 * 	企业自定义的state参数，用于区分不同的添加渠道，在调用“获取外部联系人详情”时会返回该参数值
	 */
	private String  state;
	
	/**
	 * 使用该联系方式的用户userID列表，在type为1时为必填，且只能有一个
	 */
	private String[] user;
	
	/**
	 * 使用该联系方式的部门id列表，只在type为2时有效
	 */
	private String[] party;
}
