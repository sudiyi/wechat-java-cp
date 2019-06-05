package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import com.sdk.wx.cp.bean.SyncCUserSend.Callback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全量覆盖部门请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91132
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplacePartySend implements Serializable{

	private static final long serialVersionUID = 1247992804171400355L;

	/**
	 * 上传的csv文件的media_id
	 */
	@SerializedName("media_id")
	private String mediaId;
	
	/**
	 * 回调信息。如填写该项则任务完成后，通过callback推送事件给企业。具体请参考应用回调模式中的相应选项
	 */
	private Callback callback;
}
