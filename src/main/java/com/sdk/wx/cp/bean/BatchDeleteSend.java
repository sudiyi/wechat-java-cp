package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量删除成员请求实体
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90335
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDeleteSend implements Serializable{

	private static final long serialVersionUID = 5458052927279979907L;

	/**
	 * 成员UserID列表。对应管理端的帐号。最多支持200个。若存在无效UserID，直接返回错误
	 */
	private String[] useridlist;
}
