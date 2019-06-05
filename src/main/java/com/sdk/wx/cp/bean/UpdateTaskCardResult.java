package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新任务卡片消息状态-返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91585
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskCardResult implements Serializable{

	private static final long serialVersionUID = -3120334596112116641L;

	private String errcode;
	
	private String errmsg;
	
	/**
	 * 无效用户
	 */
	private List<String> invaliduser;
}
