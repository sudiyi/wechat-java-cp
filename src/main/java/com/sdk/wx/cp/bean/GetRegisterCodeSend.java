package com.sdk.wx.cp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取注册码请求实体
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90581
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRegisterCodeSend implements Serializable{

	private static final long serialVersionUID = 2476228289210938975L;

	/**
	 * 推广包ID，最长为128个字节
	 */
	@SerializedName("template_id")
	private String templateId;
	
	/**
	 * 企业名称
	 */
	@SerializedName("corp_name")
	private String corpName;
	
	/**
	 * 管理员姓名
	 */
	@SerializedName("admin_name")
	private String adminName;
	
	/**
	 * 管理员手机号
	 */
	@SerializedName("admin_mobile")
	private String adminMobile;
	
	/**
	 * 用户自定义的状态值。只支持英文字母和数字，最长为128字节。若指定该参数， 接口 查询注册状态 及 注册完成回调事件 会相应返回该字段值
	 */
	private String state;
	
	/**
	 * 跟进人的userid，必须是服务商所在企业的成员。若配置该值，则由该注册码创建的企业，在服务商管理后台，该企业的报备记录会自动标注跟进人员为指定成员
	 */
	@SerializedName("follow_user")
	private String followUser;
	
	
}
