package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取部门成员详情返回实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90337
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListDetailResult implements Serializable{

	private static final long serialVersionUID = 34935422399031379L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 	成员列表(冗余错误码及错误信息字段)
	 */
	private List<UserInfoResult> userlist;
	
}
