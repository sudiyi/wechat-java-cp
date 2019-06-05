package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业已配置的「联系我」方式-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91572
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetContactWaySend implements Serializable{

	private static final long serialVersionUID = 4585234386043368694L;

	/**
	 * 	联系方式的配置id
	 */
	@SerializedName("config_id")
	private String configId;
}
