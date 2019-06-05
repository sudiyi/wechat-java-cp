package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import com.sdk.wx.cp.bean.GetPermanentCodeResult.AuthCorpInfo;
import com.sdk.wx.cp.bean.GetPermanentCodeResult.AuthInfo;
import com.sdk.wx.cp.bean.GetPermanentCodeResult.DealerCorpInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业授权信息返回实体
 * 企业微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90604
 * @author yangtao
 * @date 2019/05/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthInfoResult implements Serializable{

	private static final long serialVersionUID = 6791291171357231543L;

	private String errcode;
	private String errmsg;
	
	/**
	 * 代理服务商企业信息
	 */
	@SerializedName("dealer_corp_info")
	private DealerCorpInfo dealerCorpInfo;
	
	/**
	 * 授权方企业信息
	 */
	@SerializedName("auth_corp_info")
	private AuthCorpInfo authCorpInfo;
	
	/**
	 * 授权信息。如果是通讯录应用，且没开启实体应用，是没有该项的。通讯录应用拥有企业通讯录的全部信息读写权限
	 */
	@SerializedName("auth_info")
	private AuthInfo authInfo;
	
}
