package cn.ys.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制动态资源访问，不让客户端缓存
 * 
 * @author Administrator
 *
 */

@WebFilter(filterName = "DynamicResourseFilter", urlPatterns = { "*.jsp", "/manage/*" })

public class DynamicResourseFilter extends AbstractFilter {

	@Override
	public void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("pragma", "no-cache");
		System.out.println("dy");
		try {
			chain.doFilter(request, response);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}
