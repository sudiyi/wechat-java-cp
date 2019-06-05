package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业永久授权码请求实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90603
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPermanentCodeSend implements Serializable{

	private static final long serialVersionUID = -4822040751294333778L;

	/**
	 * 临时授权码，会在授权成功时附加在redirect_uri中跳转回第三方服务商网站，或通过回调推送给服务商。长度为64至512个字节
	 */
	@SerializedName("auth_code")
	private String authCode;
	
}
