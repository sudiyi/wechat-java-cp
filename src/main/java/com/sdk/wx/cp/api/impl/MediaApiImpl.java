package com.sdk.wx.cp.api.impl;

import java.io.File;
import java.io.IOException;
import com.sdk.wx.cp.api.MediaApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.BaseMediaDownloadRequestExecutor;
import me.chanjar.weixin.common.util.http.MediaUploadRequestExecutor;

/**
 * 素材管理模块实现
 * @author yangtao
 * @date 2019/05/27
 */
public class MediaApiImpl implements MediaApi{
	
	private WechatCommonApi wechatCommonApi;
	
	public MediaApiImpl(WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public WxMediaUploadResult upload(String suiteId, String corpId, String type, File file) throws WxErrorException, IOException {
		return wechatCommonApi.execute(MediaUploadRequestExecutor.create(wechatCommonApi.getRequestHttp()), UPLOAD_ADD+type, suiteId, corpId, UrlTypeEnum.ACCESS_TOKEN, file);
	}

	@Override
	public WxMediaUploadResult uploadImg(String suiteId, String corpId, File file) throws WxErrorException {
		return wechatCommonApi.execute(MediaUploadRequestExecutor.create(wechatCommonApi.getRequestHttp()), UPLOADIMG_ADD, suiteId, corpId, UrlTypeEnum.ACCESS_TOKEN, file);
	}

	@Override
	public File download(String suiteId, String corpId, String mediaId, File tempFile) throws WxErrorException {
		return wechatCommonApi.execute(BaseMediaDownloadRequestExecutor.create(wechatCommonApi.getRequestHttp(), tempFile), GET_TEMP_ADD+mediaId, suiteId, corpId, UrlTypeEnum.ACCESS_TOKEN, null);
	}

	@Override
	public File getJssdkFile(String suiteId, String corpId, String mediaId, File tempFile) throws WxErrorException {
		return wechatCommonApi.execute(BaseMediaDownloadRequestExecutor.create(wechatCommonApi.getRequestHttp(), tempFile), GET_TEMP_ADD+mediaId, suiteId, corpId, UrlTypeEnum.ACCESS_TOKEN, null);
	}

}
