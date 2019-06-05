package com.sdk.wx.cp.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 标签实体数据，供标签模块使用
 * 接口文档地址：https://work.weixin.qq.com/api/doc#90001/90143/90345
 * @author yangtao
 * @date 2019/05/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagInfo implements Serializable{

	private static final long serialVersionUID = 1763812421728381965L;

	
	/**
	 * 标签名称，长度限制为32个字以内（汉字或英文字母），标签名不可与其他标签重名。
	 */
	private String tagname;
	
	/**
	 * 标签id，非负整型，指定此参数时新增的标签会生成对应的标签id，不指定时则以目前最大的id自增。
	 */
	private String tagid;
}
