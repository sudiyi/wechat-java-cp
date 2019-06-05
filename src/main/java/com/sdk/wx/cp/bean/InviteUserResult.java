package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 邀请成员返回实体信息
 * 接口地址：https://work.weixin.qq.com/api/doc#90001/90143/91127
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InviteUserResult implements Serializable{

	private static final long serialVersionUID = 6178146500116341655L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 非法成员列表
	 */
	private List<String> invaliduser;
	
	/**
	 * 非法部门列表
	 */
	private List<String> invalidparty;
	
	/**
	 * 非法标签列表
	 */
	private List<String> invalidtag;
}
