package cn.ys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
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
		PrintWriter out = response.getWriter();
		String op = request.getParameter("op");
		String visitorID = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("visitorID")) {
				visitorID = cookie.getValue();
			}
		}

		if (op != null) {
			switch (op) {
			case "login":
				loginManage(request, response, visitorID);
				break;
			case "regist":
				registManage(request, response, visitorID);
				break;
			case "logout":
				logoutManage(request, response);
				break;
			default:
				break;
			}
		} else {
			out.write("未知错误！！！即将前往主页");
			response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");
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
	 */
	private void loginManage(HttpServletRequest request, HttpServletResponse response, String visitorID)
			throws IOException {
		PrintWriter out = response.getWriter();
		// 读取信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");

		System.out.println(code);
		if (verify.isWebCodeEffective(code, visitorID)) {
			switch (lr.login(username, password)) {
			case 1:
				// 密码正确
				// 登录成功向HttpSession中放入一个标记记录用户信息
				Cookie cookie = new Cookie("usernickname", userDao.getUserByID(username).getNickname());
				cookie.setMaxAge(36000);
				cookie.setPath("/");
				response.addCookie(cookie);
				out.write("登录成功，即将跳转主页");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");
				break;
			case 2:
				out.write("密码错误，即将跳转登录页");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/login.html");
				break;
			case 3: // 用户不存在
				out.write("用户不存在！！！即将前往登录页");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/login.html");
				break;
			case 4:
				out.write("未知错误！！！即将前往主页");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");
				break;
			default:
				break;
			}
		} else {
			out.write("验证码错误！！！即将前往登录页");
			response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/login.html");
		}
		out.close();
	}

	/**
	 * 注册管理
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void registManage(HttpServletRequest request, HttpServletResponse response, String visitorID)
			throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		// 读取信息
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		String code = request.getParameter("code");

		if (verify.isWebCodeEffective(code, visitorID)) {
			// 检测用户是否存在
			switch (lr.registUser(user)) {
			case 1:
				// 用户不存在，添加用户进入数据库
				out.write("注册成功，即将跳转主页...");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");
				break;
			case 2:
				// 用户已存在
				out.write("用户已存在！！！即将前往主页，请在主页登录...");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");
				break;
			case 3:
				// 注册失败，未知错误
				out.write("注册失败，未知错误！！！即将前往主页...");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");
				break;
			default:
				out.write("即将前往主页...");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");
				break;
			}
		} else {
			out.write("验证码错误！！！即将前往注册页...");
			response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/regist.html");
		}
		out.close();
	}

	/**
	 * 注销服务
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void logoutManage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 清楚存储用户信息的cookie
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("usernickname".equals(cookie.getName())) {
				cookie.setMaxAge(0);
				cookie.setPath("/");
			}
		}
		System.out.println("zx");
		out.write("注销成功！！！即将前往主页...");
		response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");

	}
}
