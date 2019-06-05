package com.sdk.wx.cp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Gson工具类
 * @author yangtao
 * @date 2019/05/30
 */
public class GsonUtil {
	
	private static final GsonBuilder INSTANCE = new GsonBuilder();
	
	public static Gson create() {
	    return INSTANCE.create();
	}
}
