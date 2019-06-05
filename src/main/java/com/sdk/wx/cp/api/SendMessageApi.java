package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.MessageResult;
import com.sdk.wx.cp.bean.MessageSend;
import com.sdk.wx.cp.bean.UpdateTaskCardResult;
import com.sdk.wx.cp.bean.UpdateTaskCardSend;

import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 发送消息模块接口
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90372
 * @author yangtao
 * @date 2019/05/28
 */
public interface SendMessageApi {
	
	/**
	 * 发送应用消息接口地址
	 */
	public static final String SEND_MESSAGE = "https://qyapi.weixin.qq.com/cgi-bin/message/send";

	/**
	 * 更新任务卡片消息状态
	 */
	public static final String UPDATE_TASKCARD = "https://qyapi.weixin.qq.com/cgi-bin/message/update_taskcard";

	/**
	 * <pre>
	 * 发送消息文本消息
	 * 
	 * 特别注意：此接口涉及的消息类型很多，
	 * 各自都有各自的特性和限制，使用时请一定参考接口文档
	 * 
	 * 	支持消息类型：
	 *	图片消息
	 *	语音消息
	 *	视频消息
	 *	文件消息
	 *	文本卡片消息
	 *	图文消息
	 *	图文消息（mpnews）
	 *	markdown消息
	 *	小程序通知消息
	 * 	任务卡片消息
	 *  methods : POST
	 *  接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91585
	 * 	</pre>
	 * @param suiteId 第三方应用的suiteId
	 * @param corpId 授权企业微信的corpId
	 * @param msgSend 消息实体
	 * @return 发送结果
	 *
	 */
	MessageResult sendMessage(String suiteId,String corpId, MessageSend msgSend) throws WxErrorException;
	
	/**
	 * <pre>
	 * 更新任务卡片消息状态
	 * 应用可以发送任务卡片消息，发送之后可再通过接口更新用户任务卡片消息的选择状态。
	 * 如果部分指定的用户无权限或不存在，更新仍然执行，但会返回无效的部分（即invaliduser），常见的原因是用户不在应用的可见范围内或者不在消息的接收范围内。
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91585
	 * </pre>
	 * @param suiteId 第三方应用的suiteId
	 * @param corpId 授权企业微信的corpId
	 * @param taskcardSend 请求信息
	 * @param url 请求地址
	 * @return 失败数据
	 */
	UpdateTaskCardResult updateTaskCard(String suiteId,String corpId, UpdateTaskCardSend taskcardSend) throws WxErrorException;
}
