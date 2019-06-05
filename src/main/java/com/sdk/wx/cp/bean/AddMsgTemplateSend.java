package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 添加企业群发消息模板-请求实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91573
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMsgTemplateSend implements Serializable{

	private static final long serialVersionUID = -2441751910975983207L;

	/**
	 * 客户的外部联系人id列表，不可与sender同时为空，最多可传入1万个客户
	 */
	@SerializedName("enternal_userid")
	private List<String> erternalUserid;
	
	/**
	 * 发送企业群发消息的成员userid，不可与external_userid同时为空
	 */
	private String sender;
	
	/**
	 * 消息文本内容
	 */
	private TemplateText text;
	
	/**
	 * 
	 */
	private TemplateMedia image;
	
	/**
	 * 
	 */
	private TemplateLink link;
	
	/**
	 * 
	 */
	private TemplateMiniprogram miniprogram;
	
	@Data
	public class TemplateText implements Serializable{

		private static final long serialVersionUID = 7749054211279200773L;
		
		/**
		 * 消息文本内容
		 */
		private String content;
	}
	
	@Data
	public class TemplateMedia implements Serializable{

		private static final long serialVersionUID = 1496773163350419651L;
		
		/**
		 * 图片的media_id
		 */
		@SerializedName("media_id")
		private String mediaId;
	}
	
	@Data
	public class TemplateLink implements Serializable{

		private static final long serialVersionUID = -2476497410837098893L;
		
		/**
		 * 图文消息标题
		 */
		private String title;
		
		/**
		 * 	图文消息封面的url
		 */
		private String picurl;
		
		/**
		 * 	图文消息的描述
		 */
		private String desc;
		
		/**
		 * 	图文消息的链接
		 */
		private String url;
	}
	
	@Data
	public class TemplateMiniprogram implements Serializable{

		private static final long serialVersionUID = -7238108313914310997L;
		
		/**
		 * 小程序消息标题
		 */
		private String title;
		
		/**
		 * 小程序消息封面的mediaid，封面图建议尺寸为520*416
		 */
		private String picMediaId;
		
		/**
		 * 	小程序appid，必须是关联到企业的小程序应用
		 */
		private String appid;
		
		/**
		 * 小程序page路径
		 */
		private String page;
	}
}
