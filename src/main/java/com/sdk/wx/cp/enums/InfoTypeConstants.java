package com.sdk.wx.cp.enums;

/**
 * 回调信息类别常量 与{@link MsgTypeConstants}为级别
 * @author yangtao
 * @date 2019/05/31
 */
public class InfoTypeConstants {

	/**
	 * 推送suite_ticket
	 */
	public static final String SUITE_TICKET = "suite_ticket";
	
	/**
	 * 授权成功通知事件
	 */
	public static final String CREATE_AUTH = "create_auth";
	
	/**
	 * 变更授权通知
	 */
	public static final String CHANGE_AUTH = "change_auth";
	
	/**
	 * 取消授权通知
	 */
	public static final String CANCEL_AUTH = "cancel_auth";
	
	/**
	 * 联系人变化通知
	 */
	public static final String CHANGE_CONTACT = "change_contact";
	
	/**
	 * 注册完成回调事件
	 */
	public static final String REGISTER_CORP = "register_corp";
	
	/**
	 * 外部联系人变更回调
	 */
	public static final String CHANGE_EXTERNAL_CONTACT = "change_external_contact";
	
}
