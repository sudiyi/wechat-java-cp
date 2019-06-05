package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 应用消息实体
 * touser、toparty、totag不能同时为空
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90372
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageSend implements Serializable{

	private static final long serialVersionUID = 3172244927808276422L;

	/**
	 * 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向该企业应用的全部成员发送
	 */
	private String touser;
	
	/**
	 * 部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
	 */
	private String toparty;
	
	/**
	 * 标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
	 */
	private String totag;
	
	/**
	 * 消息类型，
	 */
	private String msgtype;
	
	/**
	 * 企业应用的id，整型。企业内部开发，可在应用的设置页面查看；第三方服务商，可通过接口 获取企业授权信息 获取该参数值
	 */
	private String agentid;
	
	/**
	 * 	表示是否是保密消息，0表示否，1表示是，默认0
	 *  mpnews:表示是否是保密消息，0表示可对外分享，1表示不能分享且内容显示水印，2表示仅限在企业内分享，默认为0；注意仅mpnews类型的消息支持safe值为2，其他消息类型不支持
	 */
	private String safe;
	
	/**
	 * 文本消息
	 */
	private MessageText text;
	
	/**
	 * 图片消息
	 */
	private MessageImage image;
	
	/**
	 * 语音消息
	 */
	private MessageVoice voice;
	
	/**
	 * 视频消息
	 */
	private MessageVideo video;
	
	/**
	 * 文件消息
	 */
	private MessageFile file;
	
	/**
	 * 文本卡片消息
	 */
	private MessageTextCard textcard;
	
	/**
	 * 图文消息
	 */
	private MessageNews news;
	
	/**
	 * mp图文消息
	 */
	private MessageMPNews mpnews;
	
	/**
	 * markdown消息
	 */
	private MessageMarkdown markdown;
	
	/**
	 * 小程序通知消息
	 */
	@SerializedName("miniprogram_notice")
	private MessageMiniprogramNotice miniprogramNotice;
	
	/**
	 * 任务卡片消息
	 */
	private MessageTaskCard taskcard;
	
	@Data
	public class MessageText implements Serializable{

		private static final long serialVersionUID = 2581687787743483874L;
		
		/**
		 * 	消息内容，最长不超过2048个字节，超过将截断
		 */
		private String content;
	}
	
	@Data
	public class MessageImage implements Serializable{

		private static final long serialVersionUID = -6320422718520989238L;
		
		/**
		 * 	图片媒体文件id，可以调用上传临时素材接口获取
		 */
		@SerializedName("media_id")		
		private String mediaId;
	}
	
	@Data
	public class MessageVoice implements Serializable{

		private static final long serialVersionUID = 352551574813898831L;
		
		/**
		 * 语音文件id，可以调用上传临时素材接口获取
		 */
		@SerializedName("media_id")
		private String mediaId;
	}
	
	@Data
	public class MessageVideo implements Serializable{

		private static final long serialVersionUID = 2489338994394852819L;
		
		/**
		 * 视频媒体文件id，可以调用上传临时素材接口获取
		 */
		@SerializedName("media_id")
		private String mediaId;
		
		/**
		 * 视频消息的标题，不超过128个字节，超过会自动截断
		 */
		private String title;
		
		/**
		 * 视频消息的描述，不超过512个字节，超过会自动截断
		 */
		private String description;
	}
	
	@Data
	public class MessageFile implements Serializable{

		private static final long serialVersionUID = 1L;
		
		/**
		 * 文件id，可以调用上传临时素材接口获取
		 */
		@SerializedName("media_id")
		private String mediaId;
	}
	
	@Data
	public class MessageTextCard implements Serializable{

		private static final long serialVersionUID = -5857106520015194383L;
		
		/**
		 * 标题，不超过128个字节，超过会自动截断
		 */
		private String title;
		
		/**
		 * 描述，不超过512个字节，超过会自动截断
		 */
		private String description;
		
		/**
		 * 	点击后跳转的链接。
		 */
		private String url;
		
		/**
		 * 按钮文字。 默认为“详情”， 不超过4个文字，超过自动截断。
		 */
		private String btntext;
	}
	
	@Data
	public class MessageNews implements Serializable{

		private static final long serialVersionUID = 8739630219038674581L;
		
		/**
		 * 图文消息，一个图文消息支持1到8条图文
		 */
		private List<MessageArticles> articles;
	}
	
	@Data
	public class MessageArticles implements Serializable{

		private static final long serialVersionUID = 6152575119580727414L;	
		
		/**
		 * 标题，不超过128个字节，超过会自动截断
		 */
		private String title;
		
		/**
		 * 描述，不超过512个字节，超过会自动截断
		 */
		private String description;
		
		/**
		 * 	点击后跳转的链接。
		 */
		private String url;
		
		/**
		 * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150。
		 */
		private String picurl;
	}
	
	@Data
	public class MessageMPNews implements Serializable{

		private static final long serialVersionUID = 8160910012639242504L;
		
		private List<MessageMPArticles> articles;
	}
	
	@Data
	public class MessageMPArticles implements Serializable{

		private static final long serialVersionUID = -736952575561829141L;
		
		/**
		 * 标题，不超过128个字节，超过会自动截断
		 */
		private String title;
		
		/**
		 * 图文消息缩略图的media_id, 可以通过素材管理接口获得。此处thumb_media_id即上传接口返回的media_id
		 */
		@SerializedName("thumb_media_id")
		private String thumbMediaId;
		
		/**
		 * 	图文消息的作者，不超过64个字节
		 */
		private String author;
		
		/**
		 * 图文消息点击“阅读原文”之后的页面链接
		 */
		@SerializedName("content_source_url")
		private String contentSourceUrl;
		
		/**
		 * 图文消息的内容，支持html标签，不超过666 K个字节
		 */
		private String content;
		
		/**
		 * 图文消息的描述，不超过512个字节，超过会自动截断
		 */
		private String digest;
	}
	
	@Data
	public class MessageMarkdown implements Serializable{

		private static final long serialVersionUID = 1884824825693221103L;
		
		/**
		 * markdown内容，最长不超过2048个字节，必须是utf8编码
		 */
		private String content;
	}
	
	@Data
	public class MessageMiniprogramNotice implements Serializable{

		private static final long serialVersionUID = 1866331516008446144L;
		
		/**
		 * 小程序appid，必须是与当前小程序应用关联的小程序
		 */
		private String appid;
		
		/**
		 * 点击消息卡片后的小程序页面，仅限本小程序内的页面。该字段不填则消息点击后不跳转。
		 */
		private String page;
		
		/**
		 * 	消息标题，长度限制4-12个汉字
		 */
		private String title;
		
		/**
		 * 	消息描述，长度限制4-12个汉字
		 */
		private String description;
		
		/**
		 * 是否放大第一个content_item
		 */
		@SerializedName("emphasis_first_item")
		private String emphasisFirstItem;
		
		/**
		 * 消息内容键值对，最多允许10个item
		 */
		@SerializedName("content_item")
		private List<ContentItem> contentItem;
	}
	
	@Data
	public class ContentItem implements Serializable{

		private static final long serialVersionUID = 5413327088979443600L;
		
		/**
		 * 长度10个汉字以内
		 */
		private String key;
		
		/**
		 * 长度30个汉字以内
		 */
		private String value;
	}
	
	@Data
	public class MessageTaskCard implements Serializable{
		 
		private static final long serialVersionUID = -790635575755924930L;
		
		/**
		 * 标题，不超过128个字节，超过会自动截断
		 */
		private String title;
		
		/**
		 * 描述，不超过512个字节，超过会自动截断
		 */
		private String description;
		
		/**
		 * 点击后跳转的链接。最长2048字节，请确保包含了协议头(http/https)
		 */
		private String url;
		
		/**
		 * 任务id，同一个应用发送的任务卡片消息的任务id不能重复，只能由数字、字母和“_-@.”组成，最长支持128字节
		 */
		@SerializedName("task_id")
		private String taskId;
		
		/**
		 * 按钮列表，按钮个数为为1~2个。
		 */
		private List<MessageBtn> btn;
	}
	
	@Data
	public class MessageBtn implements Serializable{

		private static final long serialVersionUID = 1032131926779107060L;
		
		/**
		 * 按钮key值，用户点击后，会产生任务卡片回调事件，回调事件会带上该key值，只能由数字、字母和“_-@.”组成，最长支持128字节
		 */
		private String key;
		
		/**
		 * 	按钮名称
		 */
		private String name;
		
		/**
		 * 	点击按钮后显示的名称，默认为“已处理”
		 */
		@SerializedName("replace_name")
		private String replaceName;
		
		/**
		 * 	按钮字体颜色，可选“red”或者“blue”,默认为“blue”
		 */
		private String color;
		
		/**
		 * 	按钮字体是否加粗，默认false
		 */
		@SerializedName("is_bold")
		private String isBold;
	}
}
