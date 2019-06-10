package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.EInvoiceApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.GetInvoiceInfoBatchResult;
import com.sdk.wx.cp.bean.GetInvoiceInfoBatchSend;
import com.sdk.wx.cp.bean.GetInvoiceInfoResult;
import com.sdk.wx.cp.bean.GetInvoiceInfoSend;
import com.sdk.wx.cp.bean.UpdateInvoiceStatusSend;
import com.sdk.wx.cp.bean.UpdateStatusBatchSend;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 电子发票模块实现
 * @author yangtao
 * @date 2019/06/03
 */
public class EInvoiceApiImpl implements EInvoiceApi{
	
	private WechatCommonApi wechatCommonApi;
	
	public EInvoiceApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public GetInvoiceInfoResult getInvoiceInfo(String suiteId, String corpId, GetInvoiceInfoSend invoiceSend)
			throws WxErrorException {
		String result = wechatCommonApi.post(GET_INVOICE_INFO, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(invoiceSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetInvoiceInfoResult.class);
	}

	@Override
	public CommonResult updateInvoiceStatus(String suiteId, String corpId, UpdateInvoiceStatusSend updateStatusSend)
			throws WxErrorException {
		String result = wechatCommonApi.post(UPDATE_INVOICE_STATUS, UrlTypeEnum.ACCESS_TOKEN,suiteId,  corpId, GsonUtil.create().toJson(updateStatusSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public CommonResult updateStatusBatch(String suiteId, String corpId, UpdateStatusBatchSend updateBatchSend)
			throws WxErrorException {
		String result = wechatCommonApi.post(UPDATE_STATUS_BATCH, UrlTypeEnum.ACCESS_TOKEN,suiteId,  corpId, GsonUtil.create().toJson(updateBatchSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public GetInvoiceInfoBatchResult getInvoiceInfoBatch(String suiteId, String corpId, GetInvoiceInfoBatchSend invoiceInfoBatchSend) throws WxErrorException {
		String result = wechatCommonApi.post(GET_INVOICE_INFO_BATCH, UrlTypeEnum.ACCESS_TOKEN,suiteId,  corpId, GsonUtil.create().toJson(invoiceInfoBatchSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetInvoiceInfoBatchResult.class);
	}

}
