package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.CreateDepartmentResult;
import com.sdk.wx.cp.bean.DepartmentInfo;
import com.sdk.wx.cp.bean.GetDepListResult;

import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 部门模块接口
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90340
 * @author yangtao
 * @date 2019/05/27
 */
public interface DepartmentApi {

	/**
	 * 创建部门接口地址
	 */
	public static final String CREATE_DEPARTMENT = "https://qyapi.weixin.qq.com/cgi-bin/department/create";

	/**
	 * 更新部门接口地址
	 */
	public static final String UPDATE_DEPARTMENT = "https://qyapi.weixin.qq.com/cgi-bin/department/update";

	/**
	 * 删除部门接口地址
	 */
	public static final String DELETE_DEPARTMENT = "https://qyapi.weixin.qq.com/cgi-bin/department/delete";

	/**
	 * 获取部门列表接口地址
	 */
	public static final String GET_DEPARTMENT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/department/list";

	/**
	 * <pre>
	 * 创建部门
	 * methods：POST
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90341
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpIp 授权企业微信corpId
	 * @param departmentInfo 部门信息实体
	 * @return 返回信息实体ID
	 * 
	 */
	CreateDepartmentResult createDep(String suiteId, String corpId, DepartmentInfo departmentInfo) throws WxErrorException;

	/**
	 * <pre>
	 * 更新部门
	 * methods：POST
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90342
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param departmentInfo 部门信息实体
	 * @return 公共返回结果
	 */
	CommonResult updateDep(String suiteId, String corpId ,DepartmentInfo departmentInfo) throws WxErrorException;
	
	/**
	 * <pre>
	 * 删除部门
	 * methods：GET
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90343
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param id 部门ID
	 * @return 公共返回结果
	 * 
	 */
	CommonResult deleteDep(String suiteId,String corpId, String id) throws WxErrorException;

	/**
	 * <pre>
	 * 获取部门列表
	 *  methods：GET
	 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90344
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param id 部门ID
	 * @return 公共返回结果
	 */
	GetDepListResult getDepList(String suiteId, String corpId, String id) throws WxErrorException;
}
