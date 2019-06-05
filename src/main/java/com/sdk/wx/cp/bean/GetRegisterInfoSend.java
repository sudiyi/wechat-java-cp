package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询注册状态请求实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90582
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRegisterInfoSend implements Serializable{

	private static final long serialVersionUID = -2067408205789853160L;
	
	@SerializedName("register_code")
	private String registerCode;
}
