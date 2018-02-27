package cn.ys.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.dsna.util.images.ValidateCode;
import cn.ys.service.VerifyService;
import cn.ys.service.impl.VerifyServiceImpl;

/**
 * Servlet implementation class CaptchServlet
 */
@WebServlet("/CaptchServlet")

public class CaptchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VerifyService verify = new VerifyServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");// 客户端网页我们控制为UTF-8
		response.setCharacterEncoding("UTF-8");
		ValidateCode vCode = new ValidateCode(100, 25, 4, 10);
		String code = vCode.getCode();
		request.getSession().setAttribute("code", code);

		System.out.println(code);

		// 生成随机id
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

		// 添加验证码
		verify.updateWebCode(code, new Timestamp(new Date().getTime()), visitorID);
		try {
			vCode.write(response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
