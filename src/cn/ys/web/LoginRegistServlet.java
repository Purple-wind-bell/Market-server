package cn.ys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.ys.dao.UserDao;
import cn.ys.dao.impl.UserDaoImpl;
import cn.ys.service.LoginRegistService;
import cn.ys.service.VerifyService;
import cn.ys.service.impl.LoginRegistServiceImpl;
import cn.ys.service.impl.VerifyServiceImpl;
import cn.ys.vo.User;

/**
 * 用户登录请求处理
 */
@SuppressWarnings("serial")
@WebServlet("/user/LoginRegistServlet")
public class LoginRegistServlet extends HttpServlet {
	private LoginRegistService lr = new LoginRegistServiceImpl();
	private VerifyService verify = new VerifyServiceImpl();
	private UserDao userDao = new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");

		if (op != null) {
			switch (op) {
			case "login":
				loginManage(request, response);
				break;
			case "regist":
				registManage(request, response);
				break;
			case "logout":
				logoutManage(request, response);
				break;
			default:
				break;
			}
		} else {
			request.setAttribute("message", "未知错误！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * 登录管理
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void loginManage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 读取信息
		String visitorID = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("visitorID")) {
				visitorID = cookie.getValue();
			}
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");

		if (verify.isCodeEffective(code, visitorID)) {
			switch (lr.login(username, password)) {
			case 1:
				// 密码正确
				// 登录成功向HttpSession中放标记记录用户信息
				Cookie cookie1 = new Cookie("usernickname", userDao.getUserByName(username).getNickname());
				cookie1.setMaxAge(36000);
				cookie1.setPath("/");
				Cookie cookie2 = new Cookie("username", username);
				cookie2.setMaxAge(36000);
				cookie2.setPath("/");

				response.addCookie(cookie1);
				response.addCookie(cookie2);
				verify.bindUser(visitorID, username);

				request.setAttribute("message", "登录成功");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				break;
			case 2:
				request.setAttribute("message", "密码错误");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				break;
			case 3: // 用户不存在
				request.setAttribute("message", "用户不存在！！！");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				break;
			case 4:
			default:
				request.setAttribute("message", "未知错误！！！");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				break;
			}
		} else {
			request.setAttribute("message", "验证码错误！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	/**
	 * 注册管理
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void registManage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 读取信息
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		String code = request.getParameter("code");

		String visitorID = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("visitorID")) {
				visitorID = cookie.getValue();
			}
		}

		if (verify.isCodeEffective(code, visitorID)) {
			// 检测用户是否存在
			switch (lr.registUser(user)) {
			case 1:
				// 用户不存在，添加用户进入数据库
				request.setAttribute("message", "注册成功");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				break;
			case 2:
				// 用户已存在
				request.setAttribute("message", "用户已存在！！！");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				break;
			case 3:
				// 注册失败，未知错误
				request.setAttribute("message", "注册失败，未知错误！！！");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				break;
			default:
				request.setAttribute("message", "前往主页...");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				break;
			}
		} else {
			request.setAttribute("message", "验证码错误！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	/**
	 * 注销服务
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void logoutManage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 清除存储用户信息的cookie
		Cookie[] cookies = request.getCookies();
		String visitorID = null;
		for (Cookie cookie : cookies) {
			if ("usernickname".equals(cookie.getName()) || "username".equals(cookie.getName())) {
				cookie.setMaxAge(0);
				cookie.setPath("/");
			}
			if ("visitorID".equalsIgnoreCase(cookie.getName())) {
				visitorID = cookie.getValue();
			}
		}
		// 清除token
		verify.clearToken(visitorID);

		request.setAttribute("message", "注销成功！！！");
		request.getRequestDispatcher("/message.jsp").forward(request, response);

	}
}
