package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设置通讯录同步完成请求实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90584
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactSyncSuccessSend implements Serializable{

	private static final long serialVersionUID = -5890115670959078720L;

	/**
	 * 查询注册状态接口返回的access_token（跟注册完成回调事件的AccessToken参数一致，请注意与provider_access_token的区别）
	 */
	@SerializedName("access_token")
	private String accessToken;
}
