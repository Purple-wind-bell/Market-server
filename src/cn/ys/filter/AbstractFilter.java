package cn.ys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest;
		HttpServletResponse httpResponse;

		try {
			httpRequest = (HttpServletRequest) request;
			httpResponse = (HttpServletResponse) response;
			filter(httpRequest, httpResponse, chain);
		} catch (Exception e) {
			 e.printStackTrace();
		}

	}

	abstract void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain);

	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
