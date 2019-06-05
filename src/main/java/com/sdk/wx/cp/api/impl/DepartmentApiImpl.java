package com.sdk.wx.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sdk.wx.cp.api.DepartmentApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.CreateDepartmentResult;
import com.sdk.wx.cp.bean.DepartmentInfo;
import com.sdk.wx.cp.bean.GetDepListResult;
import com.sdk.wx.cp.enums.UrlTypeEnum;
import com.sdk.wx.cp.util.GsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 部门模块接口实现
 * @author yangtao
 * @date 2019/05/27
 */
public class DepartmentApiImpl implements DepartmentApi{
	
	/**
	 * 公共方法执行接口、token管理器
	 */
	private WechatCommonApi wechatCommonApi;
	
	public DepartmentApiImpl (WechatCommonApi wechatCommonApi){
		this.wechatCommonApi = wechatCommonApi;
	}

	@Override
	public CreateDepartmentResult createDep(String suiteId, String corpId, DepartmentInfo departmentInfo) throws WxErrorException {
		String result = wechatCommonApi.post(CREATE_DEPARTMENT, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(departmentInfo));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CreateDepartmentResult.class);
	}

	@Override
	public CommonResult updateDep(String suiteId, String corpId, DepartmentInfo departmentInfo) throws WxErrorException {
		String result = wechatCommonApi.post(UPDATE_DEPARTMENT, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, GsonUtil.create().toJson(departmentInfo));
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public CommonResult deleteDep(String suiteId, String corpId, String id) throws WxErrorException {
		String result = wechatCommonApi.get(DELETE_DEPARTMENT+"?id"+id, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, CommonResult.class);
	}

	@Override
	public GetDepListResult getDepList(String suiteId, String corpId, String id) throws WxErrorException {
		String result = wechatCommonApi.post(GET_DEPARTMENT_LIST+"?id"+id, UrlTypeEnum.ACCESS_TOKEN,suiteId, corpId, null);
		JsonElement tmpJsonElement = new JsonParser().parse(result);
		return GsonUtil.create().fromJson(tmpJsonElement, GetDepListResult.class);
	}

}
