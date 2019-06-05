package com.sdk.wx.cp.api;

import com.sdk.wx.cp.bean.GetSyncResult;
import com.sdk.wx.cp.bean.ReplacePartySend;
import com.sdk.wx.cp.bean.SyncCUserResult;
import com.sdk.wx.cp.bean.SyncCUserSend;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 异步批量模块接口 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91128
 * 
 * @author yangtao
 * @date 2019/05/28
 */
public interface SyncBatchApi {

	/**
	 * 增量更新成员接口地址
	 */
	public static final String SYNCCUSER = "https://qyapi.weixin.qq.com/cgi-bin/batch/syncuser";

	/**
	 * 全量覆盖成员接口地址
	 */
	public static final String REPLACEUSER = "https://qyapi.weixin.qq.com/cgi-bin/batch/replaceuser";

	/**
	 * 全量覆盖部门接口地址
	 */
	public static final String REPLACEPARTY = "https://qyapi.weixin.qq.com/cgi-bin/batch/replaceparty";

	/**
	 * 获取异步任务结果接口地址
	 */
	public static final String GET_RESULT = "https://qyapi.weixin.qq.com/cgi-bin/batch/getresult?jobid=";

	/**
	 * <pre>
	 * 增量更新成员（须拥有通讯录的写权限。）
	 * 本接口以userid（帐号）为主键，增量更新企业微信通讯录成员。请先下载CSV模板(下载增量更新成员模版)，根据需求填写文件内容。
	 * 
	 * 注意事项：
	 * 
	 * 模板中的部门需填写部门ID，多个部门用分号分隔，部门ID必须为数字，根部门的部门id默认为1
	 * 文件中存在、通讯录中也存在的成员，更新成员在文件中指定的字段值 文件中存在、通讯录中不存在的成员，执行添加操作
	 * 通讯录中存在、文件中不存在的成员，保持不变
	 * 成员字段更新规则：可自行添加扩展字段。文件中有指定的字段，以指定的字段值为准；文件中没指定的字段，不更新
	 * methods：POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91130
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * 
	 * @param userSend
	 *            增量信息
	 * @return 异步任务ID 
	 */
	SyncCUserResult syncCUser(String suiteId,String corpId, SyncCUserSend userSend) throws WxErrorException;

	/**
	 * <pre>
	 * 全量覆盖成员（须拥有通讯录的写权限。）
	 * 本接口以userid为主键，全量覆盖企业的通讯录成员，任务完成后企业的通讯录成员与提交的文件完全保持一致。请先下载CSV文件(下载全量覆盖成员模版)，根据需求填写文件内容。
	 * 
	 * 注意事项：
	 * 
	 * 模板中的部门需填写部门ID，多个部门用分号分隔，部门ID必须为数字，根部门的部门id默认为1 文件中存在、通讯录中也存在的成员，完全以文件为准
	 * 文件中存在、通讯录中不存在的成员，执行添加操作
	 * 通讯录中存在、文件中不存在的成员，执行删除操作。出于安全考虑，下面两种情形系统将中止导入并返回相应的错误码。
	 * 需要删除的成员多于50人，且多于现有人数的20%以上 需要删除的成员少于50人，且多于现有人数的80%以上
	 * 成员字段更新规则：可自行添加扩展字段。文件中有指定的字段，以指定的字段值为准；文件中没指定的字段，不更新
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91131
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * 
	 * @param userSend
	 *            覆盖信息
	 * @return 异步任务ID 
	 * 
	 */
	SyncCUserResult replaceUser(String suiteId,String corpId, SyncCUserSend userSend) throws WxErrorException;

	/**
	 * <pre>
	 * 全量覆盖部门（须拥有通讯录的写权限。）
	 * 本接口以partyid为键，全量覆盖企业的通讯录组织架构，任务完成后企业的通讯录组织架构与提交的文件完全保持一致。请先下载CSV文件(下载全量覆盖部门模版)，根据需求填写文件内容。
	 * 
	 * 注意事项：
	 * 
	 * 文件中存在、通讯录中也存在的部门，执行修改操作 文件中存在、通讯录中不存在的部门，执行添加操作
	 * 文件中不存在、通讯录中存在的部门，当部门下没有任何成员或子部门时，执行删除操作
	 * 文件中不存在、通讯录中存在的部门，当部门下仍有成员或子部门时，暂时不会删除，当下次导入成员把人从部门移出后自动删除
	 * CSV文件中，部门名称、部门ID、父部门ID为必填字段，部门ID必须为数字，根部门的部门id默认为1；排序为可选字段，置空或填0不修改排序,
	 * order值大的排序靠前。
	 * methods:POST
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91132
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * 
	 * @param partySend
	 *            部门信息
	 * @return 异步任务ID
	 * 
	 */
	SyncCUserResult replaceParty(String suiteId,String corpId, ReplacePartySend partySend) throws WxErrorException;

	/**
	 * <pre>
	 * 获取异步任务结果
	 * methods：GET
	 * 接口文档：https://work.weixin.qq.com/api/doc#90001/90143/91133
	 * </pre>
	 * @param suiteId 第三方应用suiteId
	 * @param corpId 授权企业微信corpId
	 * 
	 * @param jobId
	 *            异步任务ID
	 * @return 任务结果 
	 * 
	 */
	GetSyncResult getResult(String suiteId,String corpId, String jobId) throws WxErrorException;
}
