package cn.ys.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ys.service.VerifyService;
import cn.ys.service.impl.VerifyServiceImpl;

/**
 * Servlet implementation class LoginBusinessFilter
 */
@WebFilter(filterName = "LoginBusinessFilter", value = { "/shopping/CartServlet", "/shopping/SettleServlet",
		"/user/ModifyInfoServlet", "/manage/ManageServlet", "/usermanage/*",
		"/shopping/cart.jsp" }, description = "需要登录的业务进行过滤")
public class LoginBusinessFilter extends AbstractFilter {
	private VerifyService verify = new VerifyServiceImpl();

	@Override
	void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		// 查询是否登录
		Cookie[] cookies = request.getCookies();
		String visitorID = null;
		String username = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("visitorID")) {
					visitorID = cookie.getValue();
				}
				if (cookie.getName().equals("username")) {
					username = cookie.getValue();
				}
			}
		}

		try {
			if (username != null && visitorID != null && verify.queryBindUsername(visitorID) != null
					&& username.equals(verify.queryBindUsername(visitorID).trim())) {
				// 已登录
				chain.doFilter(request, response);
			} else {
				// 未登录
				request.setAttribute("message", "您尚未登录或登录信息有误，请重新登录");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
		} catch (IOException | ServletException e) {
			throw new RuntimeException("visitorID设置发生错误");
		}
	}

}
