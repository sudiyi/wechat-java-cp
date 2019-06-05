package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取注册码，返回信息实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90581
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRegisterCodeResult implements Serializable{

	private static final long serialVersionUID = 6314984636525264620L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 注册码，只能消费一次。在访问注册链接时消费。最长为512个字节
	 */
	@SerializedName("register_code")
	private String registerCode;
	
	/**
	 * register_code有效期，生成链接需要在有效期内点击跳转
	 */
	@SerializedName("expiress_id")
	private String expiressId;
}
