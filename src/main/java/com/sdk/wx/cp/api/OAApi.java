package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.GetOADataResult;
import com.sdk.wx.cp.bean.GetOADataSend;

import me.chanjar.weixin.common.error.WxErrorException;

/**
 * OA模块接口
 * @author yangtao
 * @date 2019/06/03
 */
public interface OAApi {

	/**
	 * 查询第三方应用审批申请当前状态接口地址
	 */
	public static final String GET_OA_DATA = "https://qyapi.weixin.qq.com/cgi-bin/corp/getopenapprovaldata";
	
	/**
	 * <pre>
	 * 查询第三方应用审批申请当前状态
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91189
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param oaSend 审批单号
	 * @return 审批信息
	 */
	public GetOADataResult getOAData(String suiteId, String corpId, GetOADataSend oaSend) throws WxErrorException;
}
