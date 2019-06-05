package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserdetail3rdResult implements Serializable{

	private static final long serialVersionUID = -8817369189297014974L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 用户所属企业的corpid
	 */
	private String corpid;
	
	/**
	 * 成员UserID
	 */
	private String userid;
	
	/**
	 * 成员姓名
	 */
	private String name;
	
	/**
	 * 成员手机号，仅在用户同意snsapi_privateinfo授权时返回
	 */
	private String mobile;
	
	/**
	 * 性别。0表示未定义，1表示男性，2表示女性
	 */
	private String gender;
	
	/**
	 * 成员邮箱，仅在用户同意snsapi_privateinfo授权时返回
	 */
	private String email;
	
	/**
	 * 头像url。注：如果要获取小图将url最后的”/0”改成”/100”即可。仅在用户同意snsapi_privateinfo授权时返回
	 */
	private String avatar;
	
	/**
	 * 员工个人二维码（扫描可添加为外部联系人），仅在用户同意snsapi_privateinfo授权时返回
	 */
	@SerializedName("qr_code")
	private String qrCode;
}
