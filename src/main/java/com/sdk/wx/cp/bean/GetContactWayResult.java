package com.sdk.wx.cp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业已配置的「联系我」方式- 返回实体
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91572
 * @author yangtao
 * @date 2019/05/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetContactWayResult implements Serializable{

	private static final long serialVersionUID = 970101353149263026L;

	private String errcode;
	
	private String errmsg;
	
	@SerializedName("contact_way")
	private List<GetContactWay> contactWay;
	
	@Data
	public class GetContactWay implements Serializable{

		private static final long serialVersionUID = -6484717440632662822L;
		
		/**
		 * 新增联系方式的配置id
		 */
		@SerializedName("config_id")
		private String configId;
		
		/**
		 * 联系方式类型，1-单人，2-多人
		 */
		private String type;
		
		/**
		 * 场景，1-在小程序中联系，2-通过二维码联系
		 */
		private String scene;
		
		/**
		 * 小程序中联系按钮的样式，仅在scene为1时返回，详见附录
		 */
		private String style;
		
		/**
		 * 联系方式的备注信息，用于助记
		 */
		private String remark;
		
		/**
		 * 	外部客户添加时是否无需验证
		 */
		@SerializedName("skip_verify")
		private String skipVerify;
		
		/**
		 * 企业自定义的state参数，用于区分不同的添加渠道，在调用“获取外部联系人详情”时会返回该参数值
		 */
		private String state;
		
		/**
		 * 	联系二维码的URL，仅在scene为2时返回
		 */
		@SerializedName("qr_code")
		private String qrCode;
		
	}
}
