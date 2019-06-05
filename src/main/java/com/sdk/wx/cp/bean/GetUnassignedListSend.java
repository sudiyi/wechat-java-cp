package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取离职成员的客户列表-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91575
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUnassignedListSend implements Serializable{

	private static final long serialVersionUID = -8750810409176167793L;

	/**
	 * 	分页查询，要查询页号，从0开始
	 */
	@SerializedName("page_id")
	private String pageId;
	
	/**
	 * 	每次返回的最大记录数，默认为1000，最大值为1000
	 */
	@SerializedName("page_size")
	private String pageSize;
}
