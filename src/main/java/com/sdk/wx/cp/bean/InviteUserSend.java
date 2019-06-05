package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 邀请成员请求实体信息
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/91127
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InviteUserSend implements Serializable{

	private static final long serialVersionUID = 1417596121149878650L;

	/**
	 * 成员ID列表, 最多支持1000个。
	 */
	private String[] user;
	
	/**
	 * 	部门ID列表，最多支持100个。
	 */
	private String[] party;
	
	/**
	 * 标签ID列表，最多支持100个。
	 */
	private String[] tag;
}
