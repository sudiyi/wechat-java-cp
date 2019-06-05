package com.sdk.wx.cp.enums;

/**
 * 事件类别常量
 * @author yangtao
 * @date 2019/05/31
 */
public class EventTypeConstants {
	
	/**
	 * 异步任务完成通知
	 */
	public static String BATCH_JOB_RESULT = "batch_job_result";
	
	/**
	 * 成员关注事件
	 */
	public static String SUBSCRIBE = "subscribe";
	
	/**
	 * 成员取消关注事件
	 */
	public static String UNSUBSCRIBE = "unsubscribe";
	
	/**
	 * 进入应用事件
	 */
	public static String ENTER_AGENT = "enter_agent";
	
	/**
	 * 上报地理位置
	 */
	public static String LOCATION = "LOCATION";

	/**
	 * 点击菜单拉取消息的事件推送
	 */
	public static String CLICK = "click";
	
	/**
	 * 点击菜单跳转链接的事件推送
	 */
	public static String VIEW = "view";
	
	/**
	 * 扫码推事件的事件推送
	 */
	public static String SCANCODE_PUSH  = "scancode_push";
	
	/**
	 * 扫码推事件且弹出“消息接收中”提示框的事件推送
	 */
	public static String SCANCODE_WAITMSG = "scancode_waitmsg";
	
	/**
	 * 弹出系统拍照发图的事件推送
	 */
	public static String PIC_SYSPHOTO = "pic_sysphoto";
	
	/**
	 * 弹出拍照或者相册发图的事件推送
	 */
	public static String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
	
	/**
	 * 弹出微信相册发图器的事件推送
	 */
	public static String PIC_WEXIN = "pic_weixin";
	
	/**
	 * 弹出地理位置选择器的事件推送
	 */
	public static String LOCATION_SELECT = "location_select";
	
	/**
	 * 审批状态通知事件
	 */
	public static String OPEN_APPROVAL_CHANGE = "open_approval_change";
	
	/**
	 * 任务卡片事件推送
	 */
	public static String TASKCARD_CLICK = "taskcard_click";
	

}
