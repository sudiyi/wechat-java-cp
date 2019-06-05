package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 增量更新成员返回实体
 * 接口地址：https://work.weixin.qq.com/api/doc#90001/90143/91130
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SyncCUserResult implements Serializable{

	private static final long serialVersionUID = 5828051846665649166L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 	异步任务id，最大长度为64字节
	 */
	private String jobid;
	
}
