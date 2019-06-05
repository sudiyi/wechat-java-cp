package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设置应用可见范围请求实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90583
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetScopeSend implements Serializable{

	private static final long serialVersionUID = -1944721387598884696L;

	/**
	 * 授权方应用id
	 */
	private String agentid;
	
	/**
	 * 应用可见范围（成员）若未填该字段，则清空可见范围中成员列表
	 */
	@SerializedName("allow_user")
	private String[] allowUser;
	
	/**
	 * 应用可见范围（部门）若未填该字段，则清空可见范围中部门列表
	 */
	@SerializedName("allow_party")
	private String[] allowParty;
	
	/**
	 * 应用可见范围（标签）若未填该字段，则清空可见范围中标签列表
	 */
	@SerializedName("allow_tag")
	private String[] allowTag;
}
