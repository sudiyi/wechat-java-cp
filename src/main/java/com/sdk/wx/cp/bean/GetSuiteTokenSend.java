package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取第三方应用凭证请求实体 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90600
 * 
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSuiteTokenSend implements Serializable {

	private static final long serialVersionUID = -3628248795823449292L;

	@SerializedName("suite_id")
	private String suiteId;// 以ww或wx开头应用id（对应于旧的以tj开头的套件id）

	@SerializedName("suite_secret")
	private String suiteSecret;// 应用secret

	@SerializedName("suite_ticket")
	private String suiteTicket;// 企业微信后台推送的ticket

}
