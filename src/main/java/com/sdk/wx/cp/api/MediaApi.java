package com.sdk.wx.cp.api;

import java.io.File;
import java.io.IOException;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 素材管理模块接口
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90391
 * @author yangtao
 * @date 2019/05/27
 */
public interface MediaApi {

	/**
	 * 上传临时素材接口地址
	 */
	public static final String UPLOAD_ADD = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?type=";
	
	/**
	 * 上传永久图片接口地址
	 */
	public static final String UPLOADIMG_ADD = "https://qyapi.weixin.qq.com/cgi-bin/media/uploadimg";

	/**
	 * 获取临时素材接口地址
	 */
	public static final String GET_TEMP_ADD = "https://qyapi.weixin.qq.com/cgi-bin/media/get?media_id=";

	/**
	 * 获取高清语音素材接口地址
	 */
	public static final String GET_JSSDK_ADD = "https://qyapi.weixin.qq.com/cgi-bin/media/get/jssdk?media_id=";

	/**
	 * <pre>
	 * 上传临时素材
	 * 使用multipart/form-data POST上传文件， 文件标识名为”media”
	 * POST的请求包中，form-data中媒体文件标识，应包含有 filename、filelength、content-type等信息
	 * filename标识文件展示的名称。比如，使用该media_id发消息时，展示的文件名由该字段控制
	 * 
	 * 素材上传得到media_id，该media_id仅三天内有效
	 * media_id在同一企业内应用之间可以共享
	 * 
	 * 限制：
	 * 所有文件size必须大于5个字节
	 * 图片（image）：2MB，支持JPG,PNG格式
	 * 语音（voice） ：2MB，播放长度不超过60s，仅支持AMR格式
	 * 视频（video） ：10MB，支持MP4格式
	 * 普通文件（file）：20MB
	 * 
	 * methods:POST
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90389
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param type （媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件（file））
	 * @param file 上传的文件对象
	 * @return media_id
	 */
	WxMediaUploadResult upload(String suiteId, String corpId, String type, File file) throws WxErrorException, IOException;
	
	/**
	 * <pre>
	 * 上传图片
	 * 上传图片得到图片URL，该URL永久有效
	 * 返回的图片URL，仅能用于图文消息（mpnews）正文中的图片展示；若用于非企业微信域名下的页面，图片将被屏蔽。
	 * 每个企业每天最多可上传100张图片
	 * 
	 * 限制：
	 * 图片文件大小应在 5B ~ 2MB 之间
	 * 
	 * 使用multipart/form-data POST上传文件， 文件标识名为 “media”
	 * POST的请求包中，form-data中媒体文件标识，应包含有filename、content-type等信息
	 * 
	 * methods:POST
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90392
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param file 上传的文件对象
	 * @return 上传永久图片的url
	 * 
	 */
	WxMediaUploadResult uploadImg(String suiteId, String corpId, File file) throws WxErrorException;
	
	/**
	 * <pre>
	 * 获取临时素材
	 * 完全公开，media_id在同一企业内所有应用之间可以共享。
	 * 正确时返回（和普通的http下载相同，请根据http头做相应的处理）
	 * 
	 * methods：GET
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90390
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param mediaId 媒体ID
	 * @return 临时文件
	 * 
	 */
	File download(String suiteId, String corpId, String mediaId ,File tempFile) throws WxErrorException;
	
	/**
	 * <pre>
	 * 获取高清语音素材
	 * 可以使用本接口获取从JSSDK的uploadVoice接口上传的临时语音素材，格式为speex，16K采样率。该音频比上文的临时素材获取接口（格式为amr，8K采样率）更加清晰，适合用作语音识别等对音质要求较高的业务。
	 * 仅企业微信2.4及以上版本支持。
	 * 权限说明：完全公开，media_id在同一企业内所有应用之间可以共享。
	 * 
	 * methods：GET
	 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90391
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param mediaId 媒体文件ID
	 * @return 高清语音素材
	 * 
	 */
	File getJssdkFile(String suiteId, String corpId, String mediaId , File tempFile) throws WxErrorException;
}
