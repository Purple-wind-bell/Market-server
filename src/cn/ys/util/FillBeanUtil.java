package cn.ys.util;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

public class FillBeanUtil {
	
	private FillBeanUtil() {
	}

	public static <T> T fillBean(HttpServletRequest request, Class<T> clazz) {
		try {
			T bean = clazz.getDeclaredConstructor().newInstance();
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
