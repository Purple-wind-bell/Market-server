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
import cn.ys.web.bean.CartBean;

/**
 * Servlet implementation class CartServlet
 */
@SuppressWarnings("serial")
@WebServlet("/shopping/CartServlet")
public class CartServlet extends HttpServlet {
	private CartService cService = new CartServiceImpl();
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
			case "editCart":
				editCart(request, response);
				break;
			case "delCart":
				delCart(request, response);
				break;
			case "delAllCart":
				delAllCart(request, response);
				break;
			default:
				other(request, response);
				break;
			}
		} else {
			request.setAttribute("message", "参数错误");
			request.getRequestDispatcher("/shopping/message.jsp").forward(request, response);
		}

	}

	/**
	 * 删除全部购物车商品
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void delAllCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取username
		String username = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("username".equals(cookie.getName())) {
				username = cookie.getValue();
			}
		}

		// 更新购物车
		cService.delAllCarts(username);
		// 跳转至提示页面
		request.setAttribute("message", "购物车已清空！！！");
		request.getRequestDispatcher("/shopping/message.jsp").forward(request, response);
	}

	/**
	 * 删除商品
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void delCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取username
		String username = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("username".equals(cookie.getName())) {
				username = cookie.getValue();
			}
		}
		String productId = request.getParameter("productId");

		// 更新购物车
		if (productId != null) {
			cService.delCart(new Cart(username, productId, 1));
			// 跳转至购物车
			request.getRequestDispatcher("/CartServlet?op=listCarts").forward(request, response);
		} else {
			other(request, response);
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
	 * @throws IOException
	 * @throws ServletException
	 */
	private void other(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "参数错误");
		request.getRequestDispatcher("/shopping/message.jsp").forward(request, response);
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
		// 获取username
		String username = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("username".equals(cookie.getName())) {
				username = cookie.getValue();
			}
		}
		String productId = request.getParameter("productId");
		String quantity = request.getParameter("quantity");

		// 更新购物车
		Cart cart = new Cart();
		if (username != null && productId != null && quantity != null) {
			cart.setUsername(username);
			cart.setProductId(productId);
			cart.setQuantity(Integer.valueOf(quantity));
			cService.addCart(cart);
			// 跳转至购物车
			request.setAttribute("message", "成功添加到购物车！");
			request.getRequestDispatcher("/shopping/message.jsp").forward(request, response);
		} else {
			other(request, response);
		}
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
		// 获取username
		String username = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("username".equals(cookie.getName())) {
				username = cookie.getValue();
			}
		}

		List<Cart> list = cService.findCartByUsername(username);
		List<CartBean> carts = new ArrayList<CartBean>();
		Iterator<Cart> iterator = list.iterator();
		while (iterator.hasNext()) {
			// 查询购物车的商品信息并封装
			Cart cart = (Cart) iterator.next();
			Integer productId = Integer.valueOf(cart.getProductId());
			// 数量
			Integer quantity = cart.getQuantity();
			// 商品对象
			Product product = pDao.findById(productId);
			// 小计
			Float subprice = quantity * product.getPrice();
			// 封装
			carts.add(new CartBean(product, quantity, subprice));
		}
		request.setAttribute("carts", carts);

		// 跳转至购物车jsp
		request.getRequestDispatcher("/shopping/cart.jsp").forward(request, response);
	}

	/**
	 * 编辑购物车中的商品
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void editCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取username
		String username = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("username".equals(cookie.getName())) {
				username = cookie.getValue();
			}
		}

		String productId = request.getParameter("productId");
		String quantity = request.getParameter("quantity");

		// 更新购物车
		Cart cart = new Cart();
		if (username != null && productId != null && quantity != null) {
			cart.setUsername(username);
			cart.setProductId(productId);
			cart.setQuantity(Integer.valueOf(quantity));
			cService.addCart(cart);
			// 跳转至购物车
			request.getRequestDispatcher("/CartServlet?op=listCarts").forward(request, response);
		} else {
			other(request, response);
		}
	}
}
