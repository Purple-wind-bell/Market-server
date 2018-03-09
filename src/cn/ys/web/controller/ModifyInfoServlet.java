package cn.ys.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ys.service.ModifyInfoService;
import cn.ys.service.VerifyService;
import cn.ys.service.impl.ModifyInfoServiceImpl;
import cn.ys.service.impl.VerifyServiceImpl;

/**
 * Servlet implementation class ModifyInfoServlet
 */
@SuppressWarnings("serial")
@WebServlet("/user/ModifyInfoServlet")
public class ModifyInfoServlet extends HttpServlet {
	private static ModifyInfoService modifyInfo = new ModifyInfoServiceImpl();
	private VerifyService verify = new VerifyServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");// 客户端网页我们控制为UTF-8
		response.setCharacterEncoding("UTF-8");
		String op = request.getParameter("op");
		String visitorID = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("visitorID")) {
				visitorID = cookie.getValue();
			}
		}

		if ("ResetPasswd".equalsIgnoreCase(op)) {
			resetPassword(request, response, visitorID);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 重置密码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void resetPassword(HttpServletRequest request, HttpServletResponse response, String visitorID)
			throws IOException, ServletException {
		// 读取信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");

		if (verify.isCodeEffective(code, visitorID)) {
			switch (modifyInfo.resetPassword(username, password)) {
			case 1:
				// 成功
				request.setAttribute("message", "重置成功，即将跳转主页");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");
				break;
			case 2: // 用户不存在
				request.setAttribute("message", "用户不存在！！！即将前往注册页");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/regist.html");
				break;
			case 3:
				request.setAttribute("message", "失败！！！即将前往密码重置页");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/UserManage/ResetPassword.html");
				break;
			default:
				request.setAttribute("message", "未知错误！！！即将前往主页");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");
				break;
			}
		} else {
			request.setAttribute("message", "验证码失效，即将跳转重置页");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/UserManage/ResetPassword.html");
		}
	}

}
