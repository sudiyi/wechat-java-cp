package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取员工行为数据-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91584
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserBehaviorSend implements Serializable{

	private static final long serialVersionUID = 5838049359762589893L;

	/**
	 * 	userid列表
	 */
	private String[] userid;
	
	/**
	 * 数据起始时间
	 */
	@SerializedName("start_time")
	private String startTime;
	
	/**
	 * 	数据结束时间
	 */
	@SerializedName("end_time")
	private String endTime;
}
