package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取配置了客户联系功能的成员列表-返回信息实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91569
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFollowUserListResult implements Serializable{

	private static final long serialVersionUID = -8735448044455588404L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 	配置了客户联系功能的成员userid列表
	 */
	@SerializedName("followUser")
	private List<String> followUser;
}
