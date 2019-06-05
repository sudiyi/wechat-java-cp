package com.sdk.wx.cp.hander.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.sdk.wx.cp.common.ende.AesException;
import com.sdk.wx.cp.common.ende.WXBizMsgCrypt;
import com.sdk.wx.cp.storage.ConfigStorage;
import com.sdk.wx.cp.util.XStreamTransformer;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.util.XmlUtils;

/**
 * <pre>
 * 消息事件回调信息实体
 * 数据信息和指令信息都集成在该类中
 * 由于同一个字段在不同场景可能指代的业务类别不同
 * 请在使用消息内容时，配合企业微信第三方文档使用
 * </pre>
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90628
 * @author yangtao
 * @date 2019/05/29
 */
@Data
@Slf4j
@XStreamAlias("xml")
public class WechatMessageIn implements Serializable{

	private static final long serialVersionUID = -2225667035139867354L;

	/**
	 * 使用dom4j解析的存放所有xml属性和值的map.
	 */
	private Map<String, Object> allFieldsMap;
	
	/**
	 * 第三方应用的suiteId
	 */
	@XStreamAlias("SuiteId")
	private String suiteId;
	
	/**
	 * 事件类型
	 */
	@XStreamAlias("InfoType")
	private String infoType;
	
	/**
	 * 时间戳
	 */
	@XStreamAlias("TimeStamp")
	private String timeStamp;
	
	/**
	 * 微信端推送ticket，用于获取suiteAccessToken
	 */
	@XStreamAlias("SuiteTicket")
	private String suiteTicket;
	
	/**
	 * 企业微信授权码，用于获取企业永久授权码
	 */
	@XStreamAlias("AuthCode")
	private String authCode;
	
	/**
	 * 授权企业corpId
	 */
	@XStreamAlias("AuthCorpId")
	private String authCorpId;
	
	/**
	 * 变更类型
	 */
	@XStreamAlias("ChangeType")
	private String changeType;
	
	/**
	 * 成员userid
	 */
	@XStreamAlias("UserID")
	private String userid;
	
	@XStreamAlias("NewUserID")
	private String newUserid;
	
	/**
	 * 成员名称
	 */
	@XStreamAlias("Name")
	private String name;
	
	/**
	 * 成员部门
	 */
	@XStreamAlias("Department")
	private String department;
	
	/**
	 * 表示所在部门是否为上级，0-否，1-是，顺序与Department字段的部门逐一对应
	 */
	@XStreamAlias("IsLeaderInDept")
	private String isLeaderInDept;
	
	/**
	 * 手机号
	 */
	@XStreamAlias("Mobile")
	private String mobile;
	
	/**
	 * 职位信息
	 */
	@XStreamAlias("Position")
	private String position;
	
	/**
	 * 	性别。1表示男性，2表示女性
	 */
	@XStreamAlias("Gender")
	private String gender;
	
	/**
	 * 邮箱，仅通讯录管理应用可获取
	 */
	@XStreamAlias("Email")
	private String email;
	
	/**
	 * 激活状态：1=激活或关注， 2=禁用， 4=未激活（重新启用未激活用户或者退出企业并且取消关注时触发）
	 */
	@XStreamAlias("Status")
	private String status;
	
	/**
	 * 头像url。注：如果要获取小图将url最后的”/0”改成”/100”即可，仅通讯录管理应用可获取
	 */
	@XStreamAlias("Avatar")
	private String avatar;
	
	/**
	 * 成员别名
	 */
	@XStreamAlias("Alias")
	private String alias;
	
	/**
	 * 	座机，仅通讯录管理应用可获取
	 */
	@XStreamAlias("Telephone")
	private String telephone;
	
	/**
	 * 	扩展属性，仅通讯录管理应用可获取
	 */
	@XStreamAlias("ExtAttr")
	private MessageExtAttr extAttr;
	
	/**
	 * 部门id
	 */
	@XStreamAlias("Id")
	private String id;
	
	/**
	 * 父部门id
	 */
	@XStreamAlias("ParentId")
	private String parentId;
	
	/**
	 * 部门排序
	 */
	@XStreamAlias("Order")
	private String order;
	
	/**
	 * 标签id
	 */
	@XStreamAlias("TagId")
	private String tagId;
	
	/**
	 * 标签中新增的成员userid列表，用逗号分隔
	 */
	@XStreamAlias("AddUserItems")
	private String addUserItems;
	
	/**
	 * 标签中删除的成员userid列表，用逗号分隔
	 */
	@XStreamAlias("DelUserItems")
	private String delUserItems;
	
	/**
	 * 标签中新增的部门id列表，用逗号分隔
	 */
	@XStreamAlias("AddPartyItems")
	private String addPartyItems;
	
	/**
	 * 标签中删除的部门id列表，用逗号分隔
	 */
	@XStreamAlias("DelPartyItems")
	private String delPartyItems;
	
	/**
	 * 服务商corpid
	 */
	@XStreamAlias("ServiceCorpId")
	private String serviceCorpId;
	
	/**
	 * 通讯录迁移的凭证信息。仅当注册推广包开启通讯录迁移接口时返回该参数
	 */
	@XStreamAlias("ContactSync")
	private MessageContactSync contactSync;
	
	/**
	 * 授权管理员的信息
	 */
	@XStreamAlias("AuthUserInfo")
	private MessageAuthUserInfo authUserInfo;
	
	/**
	 * 用户自定义的状态值，参数值由接口 获取注册码 指定。若未指定，则无该字段
	 */
	@XStreamAlias("State")
	private String state;
	
	/**
	 * 企业微信CorpID
	 */
	@XStreamAlias("ToUserName")
	private String toUserName;
	
	/**
	 * 成员UserID
	 */
	@XStreamAlias("FromUserName")
	private String fromUserName;
	
	/**
	 * 消息创建时间（整型）
	 */
	@XStreamAlias("CreateTime")
	private String createTime;
	
	/**
	 * 消息类型
	 */
	@XStreamAlias("MsgType")
	private String msgType;
	
	/**
	 * 事件类型
	 */
	@XStreamAlias("Event")
	private String event;
	
	/**
	 * 异步任务信息
	 */
	@XStreamAlias("BatchJob")
	private MessageBatchJob batchJob;
	
	/**
	 * 外部联系人的userid，注意不是企业成员的帐号
	 */
	@XStreamAlias("ExternalUserID")
	private String ExternalUserID;
	
	
	/**
	 * 创建企业对应的注册码，仅当通过 生成注册链接 方式创建的企业会回调此参数
	 */
	@XStreamAlias("RegisterCode")
	private String registerCode;
	
	/**
	 * 文本消息内容
	 */
	@XStreamAlias("Content")
	private String content;
	
	/**
	 * 消息id，64位整型
	 */
	@XStreamAlias("MsgId")
	private String msgId;
	
	/**
	 * 企业应用的id，整型。可在应用的设置页面查看
	 */
	@XStreamAlias("AgentID")
	private String agentId;
	
	/**
	 * 	图片链接
	 */
	@XStreamAlias("PicUrl")
	private String picUrl;
	
	/**
	 * 图片媒体文件id，可以调用获取媒体文件接口拉取，仅三天内有效
	 */
	@XStreamAlias("MediaId")
	private String mediaId;
	
	/**
	 * 语音格式，如amr，speex等
	 */
	@XStreamAlias("Format")
	private String format;
	
	/**
	 * 视频消息缩略图的媒体id，可以调用获取媒体文件接口拉取数据，仅三天内有效
	 */
	@XStreamAlias("ThumbMediaId")
	private String thumbMediaId;
	
	/**
	 * 	地理位置纬度
	 */
	@XStreamAlias("Location_X")
	private String location_x;
	
	/**
	 * 	地理位置经度
	 */
	@XStreamAlias("Location_Y")
	private String location_y;
	
	/**
	 * 地图缩放大小
	 */
	@XStreamAlias("Scale")
	private String scale;
	
	/**
	 * 地理位置信息
	 */
	@XStreamAlias("Label")
	private String label;
	
	/**
	 * 标题
	 */
	@XStreamAlias("Title")
	private String title;
	
	/**
	 * 描述
	 */
	@XStreamAlias("Description")
	private String description;
	
	/**
	 * 事件key值
	 */
	@XStreamAlias("EventKey")
	private String eventKey;
	
	/**
	 * 地理位置纬度
	 */
	@XStreamAlias("Latitude")
	private String latitude;
	
	/**
	 * 地理位置经度
	 */
	@XStreamAlias("Longitude")
	private String longitude;
	
	/**
	 * 地理位置精度
	 */
	@XStreamAlias("Precision")
	private String precision;
	
	/**
	 * 扫描信息
	 */
	@XStreamAlias("ScanCodeInfo")
	private MessageScanCodeInfo scanCodeInfo;
	
	/**
	 * 发送的图片信息
	 */
	@XStreamAlias("SendPicsInfo")
	private MessageSendPicsInfo sendPicsInfo;
	
	/**
	 * 	发送的位置信息
	 */
	@XStreamAlias("SendLocationInfo")
	private MessageSendLocationInfo sendLocationInfo;
	
	/**
	 * 审批信息
	 */
	@XStreamAlias("approvalInfo")
	private MessageApprovalInfo ApprovalInfo;
	
	/**
	 * 与发送任务卡片消息时指定的task_id相同
	 */
	@XStreamAlias("TaskId")
	private String taskId;
	
	
	public static WechatMessageIn fromEncryptedXml(String suiteId, String encrytedXml,ConfigStorage configStorage,String timestamp, String nonce, String msgSignature) throws AesException{
		WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(configStorage.getToken(suiteId), configStorage.getAesKey(suiteId), configStorage.getCorpid(),new String []{configStorage.getCorpid(),suiteId});
		String plainText = wxcpt.DecryptMsg(msgSignature, timestamp, nonce, encrytedXml);
		log.info("解密后的原始xml消息内容：{}", plainText);
		WechatMessageIn message = fromXml(plainText);
		log.info("message实体内容："+ message);
		log.info("原始解密内容："+ JSONUtil.toJsonStr(plainText));
		return message;
	}
	
	public static WechatMessageIn fromXml(String xml){
		WechatMessageIn xmlMessage = XStreamTransformer.fromXml(WechatMessageIn.class, xml);
		xmlMessage.setAllFieldsMap(XmlUtils.xml2Map(xml));
	    return xmlMessage;
	}
	
	/**
	 * 扩展属性
	 * @author yangtao
	 * @date 2019/05/31
	 */
	@Data
	public class MessageExtAttr implements Serializable{
		 
		private static final long serialVersionUID = 3840562486966230355L;
		
		@XStreamAlias("Item")
		private List<MessageExtAttrItem> item;
	}
	
	@Data
	public class MessageExtAttrItem implements Serializable{
		
		private static final long serialVersionUID = -4166471179165001578L;

		@XStreamAlias("Name")
		private String name;
		
		/**
		 * 扩展属性类型: 0-本文 1-网页
		 */
		@XStreamAlias("Type")
		private String type;
		
		/**
		 * 	文本属性类型，扩展属性类型为0时填写
		 */
		@XStreamAlias("Text")
		private MessageExtAttrItemText text; 
		
		/**
		 * 网页类型属性，扩展属性类型为1时填写
		 */
		@XStreamAlias("Web")
		private MessageExtAttrItemWeb web;
	}
	
	@Data
	public class MessageExtAttrItemText implements Serializable{
		
		private static final long serialVersionUID = -7101441698629387436L;
		
		/**
		 * 文本属性内容
		 */
		@XStreamAlias("Value")
		private String value;
	}
	
	@Data
	public class MessageExtAttrItemWeb implements Serializable{

		private static final long serialVersionUID = 2091669798882841769L;
		
		/**
		 * 	网页的展示标题
		 */
		@XStreamAlias("Title")
		private String title;
		
		/**
		 * 	网页的url
		 */
		@XStreamAlias("Url")
		private String url;
	}
	
	@Data
	public class MessageContactSync implements Serializable{

		private static final long serialVersionUID = 6187404099592116419L;
		
		/**
		 * 通讯录api接口调用凭证，有全部通讯录读写权限
		 */
		@XStreamAlias("AccessToken")
		private String accessToken;
		
		/**
		 * AccessToken的有效时间（秒）
		 */
		@XStreamAlias("ExpiresIn")
		private String expiresIn;
	}
	
	@Data
	public class MessageAuthUserInfo implements Serializable{
		
		private static final long serialVersionUID = -8914181155785127021L;
		
		/**
		 * 	授权管理员的userid
		 */
		@XStreamAlias("UserId")
		private String userid;
	}
	
	@Data
	public class MessageBatchJob implements Serializable{

		private static final long serialVersionUID = -8814414356453060253L;
		
		/**
		 * 异步任务id，最大长度为64字符
		 */
		@XStreamAlias("JobId")
		private String jobId;
		
		/**
		 * 操作类型，字符串，目前分别有：sync_user(增量更新成员)、 replace_user(全量覆盖成员）、invite_user(邀请成员关注）、replace_party(全量覆盖部门)
		 */
		@XStreamAlias("JobType")
		private String jobType;
		
		/**
		 * 	返回码
		 */
		@XStreamAlias("ErrCode")
		private String errcode;
		
		/**
		 * 	对返回码的文本描述内容
		 */
		@XStreamAlias("ErrMsg")
		private String errmsg;
	}
	
	@Data
	public class MessageScanCodeInfo implements Serializable{

		private static final long serialVersionUID = 4822979853646099832L;
		
		/**
		 * 扫描类型，一般是qrcode
		 */
		@XStreamAlias("ScanType")
		private String scanType;
		
		/**
		 * 扫描结果，即二维码对应的字符串信息
		 */
		@XStreamAlias("ScanResult")
		private String scanResult;
	}
	
	@Data
	public class MessageSendPicsInfo implements Serializable{

		private static final long serialVersionUID = -294653341036109227L;
		
		/**
		 * 发送的图片数量
		 */
		@XStreamAlias("Count")
		private String count;
		
		/**
		 * 图片列表
		 */
		@XStreamAlias("PicList")
		private List<MessageSendPicInfoList> picList; 
	}
	
	@Data
	public class MessageSendPicInfoList implements Serializable{

		private static final long serialVersionUID = -6786121248668233158L;
		
		@XStreamAlias("item")
		private MessageSendPicInfoListItem item; 
	}
	
	@Data
	public class MessageSendPicInfoListItem implements Serializable{

		private static final long serialVersionUID = 6188055873521757368L;
		
		/**
		 * 图片的MD5值，开发者若需要，可用于验证接收到图片
		 */
		@XStreamAlias("PicMd5Sum")
		private String picMd5Sum;
	}
	
	@Data
	public class MessageSendLocationInfo implements Serializable{

		private static final long serialVersionUID = 3511251152370274793L;
		
		/**
		 * X坐标信息
		 */
		@XStreamAlias("Location_X")
		private String location_X;
		
		/**
		 * Y坐标信息
		 */
		@XStreamAlias("Location_Y")
		private String location_Y;
		
		/**
		 * 精度，可理解为精度或者比例尺、越精细的话 scale越高
		 */
		@XStreamAlias("Scale")
		private String scale;
		
		/**
		 * 地理位置的字符串信息
		 */
		@XStreamAlias("Label")
		private String label;
		
		/**
		 * POI的名字，可能为空
		 */
		@XStreamAlias("Poiname")
		private String poiname;
		
	}
	
	/**
	 * 审批信息
	 * @author yangtao
	 * @date 2019/05/31
	 */
	@Data
	public class MessageApprovalInfo implements Serializable{

		private static final long serialVersionUID = -597598330141260828L;
		
		/**
		 * 审批单编号，由开发者在发起申请时自定义
		 */
		@XStreamAlias("ThirdNo")
		private String thirdNo;
		
		/**
		 * 审批模板名称
		 */
		@XStreamAlias("OpenSpName")
		private String openSpName;
		
		/**
		 * 	审批模板id
		 */
		@XStreamAlias("OpenTemplateId")
		private String openTemplateId;
		
		/**
		 * 申请单当前审批状态：1-审批中；2-已通过；3-已驳回；4-已取消
		 */
		@XStreamAlias("OpenSpStatus")
		private String openSpStatus;
		
		/**
		 * 提交申请时间
		 */
		@XStreamAlias("ApplyTime")
		private String applyTime;
		
		/**
		 * 提交者姓名
		 */
		@XStreamAlias("ApplyUserName")
		private String applyUserName;
		
		/**
		 * 提交者userid
		 */
		@XStreamAlias("ApplyUserId")
		private String applyUserId;
		
		/**
		 * 提交者所在部门
		 */
		@XStreamAlias("ApplyUserParty")
		private String applyUserParty;
		
		/**
		 * 提交者头像
		 */
		@XStreamAlias("ApplyUserImage")
		private String applyUserImage;
		
		/**
		 * 审批流程信息
		 */
		@XStreamAlias("ApprovalNodes")
		private MessageApprovalNodes approvalNodes;
		
		/**
		 * 抄送信息，可能有多个抄送人
		 */
		@XStreamAlias("NotifyNodes")
		private MessageNotifyNodes notifyNodes;
		
		@XStreamAlias("approverstep")
		private String approverstep;
		
	}
	
	@Data
	public class MessageApprovalNodes implements Serializable{

		private static final long serialVersionUID = 5608325833895906754L;
		
		/**
		 * 审批流程信息，可以有多个审批节点
		 */
		@XStreamAlias("ApprovalNode")
		private List<MessageApprovalNode> approvalNode;
	}
	
	@Data
	public class MessageApprovalNode implements Serializable{

		private static final long serialVersionUID = 4831299363139016952L;
		
		/**
		 * 节点审批操作状态：1-审批中；2-已同意；3-已驳回；4-已转审
		 */
		@XStreamAlias("NodeStatus")
		private String nodeStatus;
		
		/**
		 * 审批节点属性：1-或签；2-会签
		 */
		@XStreamAlias("NodeAttr")
		private String nodeAttr;
		
		/**
		 * 	审批节点类型：1-固定成员；2-标签；3-上级
		 */
		@XStreamAlias("NodeType")
		private String nodeType;
		
		/**
		 * 审批节点信息，当节点为标签或上级时，一个节点可能有多个分支
		 */
		@XStreamAlias("Items")
		private MessageApprovalNodeItems items;
	}
	
	@Data
	public class MessageApprovalNodeItems implements Serializable{

		private static final long serialVersionUID = 438860607755750876L;
		
		/**
		 * 审批节点分支，当节点为标签或上级时，一个节点可能有多个分支
		 */
		@XStreamAlias("Item")
		private List<MessageApprovalNodeItem> item;
	}
	
	@Data
	public class MessageApprovalNodeItem implements Serializable{

		private static final long serialVersionUID = 7980364414651746499L;
		
		/**
		 * 分支审批人姓名
		 */
		@XStreamAlias("ItemName")
		private String itemName;
		
		/**
		 * 分支审批人userid
		 */
		@XStreamAlias("ItemUserid")
		private String itemUserid;
		
		/**
		 * 分支审批人所在部门
		 */
		@XStreamAlias("ItemParty")
		private String itemParty;
		
		/**
		 * 分支审批人头像
		 */
		@XStreamAlias("ItemImage")
		private String itemImage;
		
		/**
		 * 分支审批审批操作状态：1-审批中；2-已同意；3-已驳回；4-已转审
		 */
		@XStreamAlias("ItemStatus")
		private String itemStatus;
		
		/**
		 * 分支审批人审批意见
		 */
		@XStreamAlias("ItemSpeech")
		private String itemSpeech;
		
		/**
		 * 分支审批人操作时间
		 */
		@XStreamAlias("ItemOpTime")
		private String itemOpTime;
	}
	
	/**
	 * 审批流程信息
	 * @author yangtao
	 * @date 2019/05/31
	 */
	@Data
	public class MessageNotifyNodes implements Serializable{
		
		private static final long serialVersionUID = 4909969537016844776L;
		
		/**
		 * 抄送人信息
		 */
		@XStreamAlias("NotifyNode")
		private List<MessageNotifyNode> notifyNode;
	}
	
	/**
	 * 抄送人信息
	 * @author yangtao
	 * @date 2019/05/31
	 */
	@Data
	public class MessageNotifyNode implements Serializable{

		private static final long serialVersionUID = 7883463138284056641L;
		
		/**
		 * 抄送人姓名
		 */
		@XStreamAlias("ItemName")
		private String itemName;
		
		/**
		 * 抄送人userid
		 */
		@XStreamAlias("ItemUserid")
		private String itemUserid;
		
		/**
		 * 抄送人所在部门
		 */
		@XStreamAlias("ItemParty")
		private String itemParty;
		
		/**
		 * 抄送人头像
		 */
		@XStreamAlias("ItemImage")
		private String itemImage;
	}
	
}
