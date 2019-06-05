package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取应用的管理员列表请求实体
 * 企业微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90606
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAdminListSend implements Serializable{

	private static final long serialVersionUID = 3848899364840122996L;

	/**
	 * 授权方corpid
	 */
	@SerializedName("auth_corpid")
	private String authCorpid;
	
	/**
	 * 授权方安装的应用agentid
	 */
	private String agentid;
	
}
