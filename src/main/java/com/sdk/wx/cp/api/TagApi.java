package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.AddTaguserResult;
import com.sdk.wx.cp.bean.AddTaguserSend;
import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.CreateTagResult;
import com.sdk.wx.cp.bean.GetTagInfoResult;
import com.sdk.wx.cp.bean.GetTagListResult;
import com.sdk.wx.cp.bean.TagInfo;

import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 标签管理模块
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90345
 * @author yangtao
 * @date 2019/05/27
 */
public interface TagApi {

	/**
	 * 创建标签接口地址
	 */
	public static final String CREATE_TAG = "https://qyapi.weixin.qq.com/cgi-bin/tag/create";
	
	/**
	 * 更新标签名字接口地址
	 */
	public static final String UPDATE_TAG = "https://qyapi.weixin.qq.com/cgi-bin/tag/update";

	/**
	 * 删除标签接口地址
	 */
	public static final String DELETE_TAG = "https://qyapi.weixin.qq.com/cgi-bin/tag/delete?tagid=";

	/**
	 * 获取标签成员接口地址
	 */
	public static final String GET_TAG_INFO = "https://qyapi.weixin.qq.com/cgi-bin/tag/get?tagid=";


	/**
	 * 增加标签成员接口地址
	 */
	public static final String ADD_TAGUSERS = "https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers";

	/**
	 * 删除标签成员接口地址
	 */
	public static final String DEL_TAGUSERS = "https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers";
	
	/**
	 * 获取标签成员列表接口地址
	 */
	public static final String GET_TAG_LIST = "https://qyapi.weixin.qq.com/cgi-bin/tag/list";
	
	
	/**
	 * <pre>
	 * 创建标签
	 * methods：POST
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90346
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param tagInfo 标签信息
	 * @return 标签ID
	 * 
	 */
	CreateTagResult createTag(String suiteId, String corpId, TagInfo tagInfo) throws WxErrorException;

	/**
	 * <pre>
	 * 更新标签名字
	 * methods：POST
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90347
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param tagInfo 标签信息
	 * @return 公共返回实体
	 * 
	 */
	CommonResult updateTag(String suiteId, String corpId, TagInfo tagInfo) throws WxErrorException;
	
	/**
	 * <pre>
	 * 删除标签
	 * methods：GET
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90348
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param tagid 标签ID
	 * @return 公共返回实体
	 */
	CommonResult deleteTag(String suiteId, String corpId, String tagid) throws WxErrorException;

	/**<pre>
	 * 获取标签成员
	 * methods：GET
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90349
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param tagid 标签ID
	 * @return 公共返回实体
	 * 
	 */
	GetTagInfoResult getTagInfo(String suiteId, String corpId, String tagid) throws WxErrorException;

	/**
	 * <pre>
	 * 增加标签成员
	 * methods：POST
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90350
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param addTagusersSend 增加信息
	 * @return 返回结果信息
	 * 
	 */
	AddTaguserResult addTagusers(String suiteId, String corpId, AddTaguserSend addTagusersSend) throws WxErrorException;

	/**
	 * <pre>
	 * 删除标签成员
	 * methods：POST
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90351
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @param delTagusersSend 删除信息
	 * @return 返回结果信息
	 */
	AddTaguserResult delTagusers(String suiteId, String corpId, AddTaguserSend delTagusersSend) throws WxErrorException;
	
	/**
	 * <pre>
	 * 自建应用或通讯同步助手可以获取所有标签列表；第三方应用仅可获取自己创建的标签。
	 * methods：GET
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90352
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * @return 返回信息实体
	 * 
	 */
	GetTagListResult getTagList(String suiteId, String corpId) throws WxErrorException;
}
