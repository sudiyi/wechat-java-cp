package com.sdk.wx.cp.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 离职成员的外部联系人再分配-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91576
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnassignTransferSend implements Serializable{

	private static final long serialVersionUID = 5047458125814284310L;

	/**
	 * 	外部联系人的userid，注意不是企业成员的帐号
	 */
	@SerializedName("external_userid")
	private String externalUserid;
	
	/**
	 * 	离职成员的userid
	 */
	@SerializedName("handover_userid")
	private String handoverUserid;
	
	/**
	 * 	接替成员的userid
	 */
	@SerializedName("takeoverUserid")
	private String takeoverUserid;
}
