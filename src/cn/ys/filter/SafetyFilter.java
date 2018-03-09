package cn.ys.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置访问者id Servlet implementation class SafetyFilter
 */
@WebFilter(filterName = "SafetyFilter", urlPatterns = "/*", initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8") })
public class SafetyFilter extends AbstractFilter {

	@Override
	void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		// 生成并设置用户的随机id
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		String visitorID = null;
		for (Cookie cookie : cookies) {
			if (cookie.getValue().equals("visitorID")) {
				flag = true;
				visitorID = cookie.getValue();
			}
		}
		if (!flag) {
			visitorID = UUID.randomUUID().toString();
			Cookie cookie = new Cookie("visitorID", visitorID);
			cookie.setPath("/");
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
		try {
			chain.doFilter(request, response);
		} catch (IOException | ServletException e) {
			throw new RuntimeException("visitorID设置发生错误");
		}
	}

}
