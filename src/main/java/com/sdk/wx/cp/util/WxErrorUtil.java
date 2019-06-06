package com.sdk.wx.cp.util;

import me.chanjar.weixin.common.error.WxMpErrorMsgEnum;

/**
 * 处理common模块的微信返回码中文msg
 * @author yangtao
 * @date 2019/06/06
 */
public class WxErrorUtil {

  public static String getErrorMsg(int code) {
    return WxMpErrorMsgEnum.findMsgByCode(code);
  }

}