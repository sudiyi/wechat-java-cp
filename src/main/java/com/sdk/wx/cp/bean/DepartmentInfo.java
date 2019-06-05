
package com.sdk.wx.cp.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门实体信息，供部门模块相关接口使用
 * 微信文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90341
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentInfo implements Serializable{

	private static final long serialVersionUID = -5909436072281995350L;

	/**
	 * 部门名称。长度限制为1~32个字符，字符不能包括\:?”<>｜
	 */
	private String name;
	
	/**
	 * 父部门id，32位整型
	 */
	private String parentid;
	
	/**
	 * 在父部门中的次序值。order值大的排序靠前。有效的值范围是[0, 2^32)
	 */
	private String order;
	
	/**
	 * 部门id，32位整型，指定时必须大于1。若不填该参数，将自动生成id
	 */
	private String id;
	
}
