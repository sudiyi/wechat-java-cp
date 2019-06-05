package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 增加成员标签返回实体信息
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90350
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTaguserResult implements Serializable{

	private static final long serialVersionUID = 5570184229039400584L;

	/**
	 * add 全部非法？40070:0
	 * delete 全部非法？40031:0
	 */
	private String errcode;
	
	/**
	 * 全部非法？all list invalid:ok:
	 */
	private String errmsg;
	
	/**
	 * 若部分userid、partylist非法，则返回
	 * 非法的成员帐号列表
	 */
	private String invalidlist;
	
	/**
	 * 若部分userid、partylist非法，则返回
	 * 非法的部门id列表
	 */
	private List<String> invalidparty;
	
}
