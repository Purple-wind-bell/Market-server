package cn.ys.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "StaticResourseFilter", initParams = {
		@WebInitParam(name = "html", value = "1") }, value = "/*", description = "不同资源的缓存时间设置")
public class StaticResourseFilter extends AbstractFilter {
	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		long time = 0;// 毫秒值，缓存时间

		// 不同资源设置不同缓存时间
		String uri = request.getRequestURI();
		String fileName = uri.substring(uri.indexOf(".") + 1);
		// html
		if (fileName.equals("html")) {
			String resourse = filterConfig.getInitParameter("html");
			time = Long.valueOf(resourse) * 60 * 60 * 1000;

		}
		response.setDateHeader("Expires", System.currentTimeMillis() + time);
		try {
			chain.doFilter(request, response);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}
