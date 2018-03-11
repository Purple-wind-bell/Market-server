package cn.ys.web;

import java.io.IOException;
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
 * 
 * 验证码
 */
@WebServlet("/CaptchServlet")

public class CaptchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VerifyService verify = null;

	@Override
	public void init() throws ServletException {
		super.init();
		verify = new VerifyServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ValidateCode vCode = new ValidateCode(100, 25, 4, 10);
		String code = vCode.getCode();
		request.getSession().setAttribute("code", code);

		// 查询访问者id
		Cookie[] cookies = request.getCookies();
		String visitorID = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("visitorID")) {
				visitorID = cookie.getValue();
			}
		}
		// 添加验证码
		verify.updateWebCode(code, visitorID);
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
