package com.sdk.wx.cp.hander.action;

/**
 * 消息与事件解析处理接口
 * SDK版本代码只有：指令消息处理器，数据消息处理器。两个实现类
 * 上层应用需要扩展功能或对消息做更多处理时，可以继承该接口重写方法，或者增强实现类
 * @author yangtao
 * @date 2019/05/29
 */
public interface MessageHander<T> {
	
	/**
	 * 消息处理
	 * @param t
	 * @return
	 */
	T hander(T t);
}
