package com.sdk.wx.cp.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.sdk.wx.cp.hander.dto.WechatMessageIn;
import com.thoughtworks.xstream.XStream;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;

@SuppressWarnings("rawtypes")
public class XStreamTransformer {

protected static final Map<Class, XStream> CLASS_2_XSTREAM_INSTANCE = configXStreamInstance();

  /**
   * xml -> pojo
   */
  @SuppressWarnings("unchecked")
  public static <T> T fromXml(Class<T> clazz, String xml) {
    T object = (T) CLASS_2_XSTREAM_INSTANCE.get(clazz).fromXML(xml);
    return object;
  }

  @SuppressWarnings("unchecked")
  public static <T> T fromXml(Class<T> clazz, InputStream is) {
    T object = (T) CLASS_2_XSTREAM_INSTANCE.get(clazz).fromXML(is);
    return object;
  }

  /**
   * pojo -> xml.
   */
  public static <T> String toXml(Class<T> clazz, T object) {
    return CLASS_2_XSTREAM_INSTANCE.get(clazz).toXML(object);
  }
  
  private static Map<Class, XStream> configXStreamInstance() {
	    Map<Class, XStream> map = new HashMap<>();
	    map.put(WechatMessageIn.class, configWxCpXmlMessage());
	    return map;
  }
  
  private static XStream configWxCpXmlMessage() {
	    XStream xstream = XStreamInitializer.getInstance();
	    xstream.processAnnotations(WechatMessageIn.class);
	    Class<?>[] classes = new Class[] { WechatMessageIn.class};
	    xstream.allowTypes(classes);
	    return xstream;
	  }

}
