package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.CommonResult;
import com.sdk.wx.cp.bean.GetInvoiceInfoBatchResult;
import com.sdk.wx.cp.bean.GetInvoiceInfoBatchSend;
import com.sdk.wx.cp.bean.GetInvoiceInfoResult;
import com.sdk.wx.cp.bean.GetInvoiceInfoSend;
import com.sdk.wx.cp.bean.UpdateInvoiceStatusSend;
import com.sdk.wx.cp.bean.UpdateStatusBatchSend;

import me.chanjar.weixin.common.error.WxErrorException;

/**
 * <pre>
 * 电子发票模块接口
 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90419
 * </pre>
 * @author yangtao
 * @date 2019/06/03
 */
public interface EInvoiceApi {
	
	/**
	 * 查询电子发票接口地址
	 */
	public static final String GET_INVOICE_INFO = "https://qyapi.weixin.qq.com/cgi-bin/card/invoice/reimburse/getinvoiceinfo";

	/**
	 * 更新发票状态接口地址
	 */
	public static final String UPDATE_INVOICE_STATUS = "https://qyapi.weixin.qq.com/cgi-bin/card/invoice/reimburse/updateinvoicestatus";

	/**
	 * 批量更新发票状态接口地址
	 */
	public static final String UPDATE_STATUS_BATCH = "https://qyapi.weixin.qq.com/cgi-bin/card/invoice/reimburse/updatestatusbatch";

	/**
	 * 批量查询电子发票
	 */
	public static final String GET_INVOICE_INFO_BATCH = "https://qyapi.weixin.qq.com/cgi-bin/card/invoice/reimburse/getinvoiceinfobatch";

	/**
	 * <pre>
	 * 查询电子发票
	 * 报销方在获得用户选择的电子发票标识参数后，可以通过该接口查询电子发票的结构化信息，并获取发票PDF文件。
	 * methods：POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90420
	 * </pre>
	 * @param suiteId 第三方应用的suiteId
	 * @param corpId 授权企业微信corpId
	 * @param invoiceSend 发票id、加密code
	 * @return 电子发票信息
	 */
	public GetInvoiceInfoResult getInvoiceInfo(String suiteId, String corpId, GetInvoiceInfoSend invoiceSend) throws WxErrorException;

	/**
	 * <pre>
	 * 更新发票状态
	 * 仅认证的企业微信账号有接口权限
	 * 接口说明：报销企业和报销服务商可以通过该接口对某一张发票进行锁定、解锁和报销操作。各操作的业务含义及在用户端的表现如下：
锁定：电子发票进入了企业的报销流程时应该执行锁定操作，执行锁定操作后的电子发票仍然会存在于用户卡包内，但无法重复提交报销。
解锁：当电子发票由于各种原因，无法完成报销流程时，应执行解锁操作。执行锁定操作后的电子发票将恢复可以被提交的状态。
报销：当电子发票报销完成后，应该使用本接口执行报销操作。执行报销操作后的电子发票将从用户的卡包中移除，用户可以在卡包的消息中查看到电子发票的核销信息。注意，报销为不可逆操作，请开发者慎重调用。
	 * methods：POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90421
	 * </pre>
	 * @param suiteId 第三方应用的suiteId
	 * @param corpId 授权企业微信corpId
	 * @param updateStatusSend 更新发票信息
	 * @return 公共返回结果
	 */
	public CommonResult updateInvoiceStatus(String suiteId, String corpId, UpdateInvoiceStatusSend updateStatusSend) throws WxErrorException;
	
	/**
	 * <pre>
	 * 批量更新发票状态
	 * 接口说明：发票平台可以通过该接口对某个成员的一批发票进行锁定、解锁和报销操作。注意，报销状态为不可逆状态，请开发者慎重调用。
	 * 权限说明：仅认证的企业微信账号有接口权限
	 * 报销方须保证在报销、锁定、解锁后及时将状态同步至微信侧，保证用户发票可以正常使用
批量更新发票状态接口为事务性操作，如果其中一张发票更新失败，列表中的其它发票状态更新也会无法执行，恢复到接口调用前的状态
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90422
	 * </pre>
	 * @param suiteId 第三方应用的suiteId
	 * @param corpId 授权企业问下corpId
	 * @param updateBatchSend 批量信息
	 * @return 公共返回实体
	 */
	public CommonResult updateStatusBatch(String suiteId, String corpId, UpdateStatusBatchSend updateBatchSend) throws WxErrorException;
	
	/**
	 * <pre>
	 * 批量查询发票信息
	 * 接口说明：报销方在获得用户选择的电子发票标识参数后，可以通过该接口批量查询电子发票的结构化信息。
	 * 权限说明：仅认证的企业微信账号有接口权限
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/90423
	 * </pre>
	 * @param suiteId 第三方应用的suiteId
	 * @param corpId 授权企业微信id
	 * @param invoiceInfoBatchSend 发票id列表及openid
	 * @return 批量发票信息
	 */
	public GetInvoiceInfoBatchResult getInvoiceInfoBatch(String suiteId, String corpId, GetInvoiceInfoBatchSend invoiceInfoBatchSend) throws WxErrorException;
}
