package cn.ys.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ys.service.BusinessService;
import cn.ys.service.impl.BusinessServiceImpl;
import cn.ys.vo.Product;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/shopping/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService s = new BusinessServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if (op != null) {
			switch (op) {
			case "listAllProducts":
				listAllProducts(request, response);
				break;
			default:
				building(request, response);
				break;
			}
		} else {
			building(request, response);
		}
	}

	/**
	 * 查询商品
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listAllProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> list = s.findAllProduct();
		request.setAttribute("listProducts", list);
		request.getRequestDispatcher("/shopping/showAllProducts.jsp").forward(request, response);
	}

	/**
	 * 建设中
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void building(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("message", "建设中...");
		request.getRequestDispatcher("/shopping/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
