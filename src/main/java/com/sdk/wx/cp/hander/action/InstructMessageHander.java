package com.sdk.wx.cp.hander.action;

import org.springframework.stereotype.Component;

/**
 * 指令消息处理器
 * @author yangtao
 * @date 2019/05/29
 * @param <T> 处理对象
 */
@Component
public class InstructMessageHander<T> implements MessageHander<T>{

	@Override
	public T hander(T t) {
		return null;
	}
	
}
