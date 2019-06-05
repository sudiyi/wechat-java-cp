package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取用户敏感信息请求实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91122
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserdetail3rdSend implements Serializable{

	private static final long serialVersionUID = -4593940540954366773L;
	
	@SerializedName("user_ticket")
	private String userTicket;
}
