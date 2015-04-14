package uaas.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MenuUtil {
	private MenuUtil() {

	}

	/**
	 * 把对象序列号为字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String marshaller(Object object) {
		String menus = JsonUtil.marshaller(object);
		try {
			return URLEncoder.encode(menus, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 把一个Json格式字符串转换为对象
	 * 
	 * @param content
	 * @param valueType
	 * @return
	 */
	public static <T> T unmarshaller(String content, Class<T> valueType) {
		try {
			String menus = URLDecoder.decode(content, "UTF-8");
			T result = JsonUtil.unmarshaller(menus, valueType);
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
