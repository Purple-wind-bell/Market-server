package cn.ys.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.ys.dao.ProductDao;
import cn.ys.dao.impl.ProductDaoImpl;
import cn.ys.service.CartService;
import cn.ys.service.VerifyService;
import cn.ys.service.impl.CartServiceImpl;
import cn.ys.service.impl.VerifyServiceImpl;
import cn.ys.vo.Cart;
import cn.ys.vo.Product;

/**
 * Servlet implementation class CartServlet
 */
@SuppressWarnings("serial")
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private CartService cService = new CartServiceImpl();
	private VerifyService verify = new VerifyServiceImpl();
	private ProductDao pDao = new ProductDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if (op != null) {
			switch (op) {
			case "listCarts":
				listCarts(request, response);
				break;
			case "addToCart":
				addToCart(request, response);
				break;
			default:
				other(request, response);
				break;
			}
		} else {
			request.setAttribute("message", "参数错误");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 未知情况
	 * 
	 * @param request
	 * @param response
	 */
	private void other(HttpServletRequest request, HttpServletResponse response) {

	}

	/**
	 * 添加到购物车
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String username = null;
		for (Cookie cookie : cookies) {
			if ("visitorID".equals(cookie.getName())) {
				String visitorID = cookie.getValue();
				username = verify.queryBindUsername(visitorID);
			}
		}

		// 更新购物车
		Cart cart = new Cart();
		cart.setUsername(username);
		cart.setProductId(request.getParameter("productId"));
		cart.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		cService.addCart(cart);
		// 跳转至购物车
		request.getRequestDispatcher("/CartServlet?op=listCarts").forward(request, response);
	}

	/**
	 * 显示购物车
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listCarts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("visitorID".equals(cookie.getName())) {
				String visitorID = cookie.getValue();
				username = verify.queryBindUsername(visitorID);
			}
		}

		List<Cart> carts = cService.findCartByUsername(username);
		List<Product> products = new ArrayList<Product>();
		Iterator<Cart> iterator = carts.iterator();
		while (iterator.hasNext()) {
			Cart cart = (Cart) iterator.next();
			Integer productId = Integer.valueOf(cart.getProductId());
			products.add(pDao.findById(productId));
		}
		request.setAttribute("carts", carts);
		request.setAttribute("products", products);

		// 跳转至购物车jsp
		request.getRequestDispatcher("/Usermanage/carts.jsp").forward(request, response);
	}
}
