package com.sdk.wx.cp.bean;

import org.apache.commons.lang3.StringUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.EInvoiceApi;
import com.sdk.wx.cp.api.WechatCommonApi;
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
	public GetInvoiceInfoResult getInvoiceInfo(String corpId, GetInvoiceInfoSend invoiceSend, String url)
			throws WxErrorException {
		if(!StringUtils.isNotBlank(url)){//不传url使用默认url
			url = GET_INVOICE_INFO;
		}
		String result = wechatCommonApi.post(url, UrlTypeEnum.ACCESS_TOKEN, corpId, GsonUtil.create().toJson(invoiceSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetInvoiceInfoResult.class);
	}

	@Override
	public CommonResult updateInvoiceStatus(String corpId, UpdateInvoiceStatusSend updateStatusSend, String url)
			throws WxErrorException {
		if(!StringUtils.isNotBlank(url)){//不传url使用默认url
			url = UPDATE_INVOICE_STATUS;
		}
		String result = wechatCommonApi.post(url, UrlTypeEnum.ACCESS_TOKEN, corpId, GsonUtil.create().toJson(updateStatusSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public CommonResult updateStatusBatch(String corpId, UpdateStatusBatchSend updateBatchSend, String url)
			throws WxErrorException {
		if(!StringUtils.isNotBlank(url)){//不传url使用默认url
			url = UPDATE_STATUS_BATCH;
		}
		String result = wechatCommonApi.post(url, UrlTypeEnum.ACCESS_TOKEN, corpId, GsonUtil.create().toJson(updateBatchSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public GetInvoiceInfoBatchResult getInvoiceInfoBatch(String corpId, GetInvoiceInfoBatchSend invoiceInfoBatchSend,
			String url) throws WxErrorException {
		if(!StringUtils.isNotBlank(url)){//不传url使用默认url
			url = GET_INVOICE_INFO_BATCH;
		}
		String result = wechatCommonApi.post(url, UrlTypeEnum.ACCESS_TOKEN, corpId, GsonUtil.create().toJson(invoiceInfoBatchSend));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetInvoiceInfoBatchResult.class);
	}

}
