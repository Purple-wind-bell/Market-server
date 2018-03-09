package cn.ys.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ys.service.BusinessService;
import cn.ys.service.impl.BusinessServiceImpl;
import cn.ys.util.FillBeanUtil;
import cn.ys.vo.Category;
import cn.ys.vo.Product;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/manage/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BusinessService s = new BusinessServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String op = request.getParameter("op");
		if (op != null) {
			switch (op) {
			case "listCategory":
				listCategory(request, response);
				break;
			case "addCategories":
				addCategories(request, response);
				break;
			case "delCategoryById":
				delCategoryById(request, response);
				break;
			case "updateCategoryById":
				updateCategoryById(request, response);
				break;
			case "addProduct":
				addProduct(request, response);
				break;
			case "delProductById":
				delProductById(request, response);
				break;
			case "listAllProducts":
				listProducts(request, response);
				break;
			default:
				building(request, response);
				break;
			}
		} else {
			out.write("未知错误！！！即将前往主页");
			response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/index.html");
		}

	}

	/**
	 * 删除商品
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delProductById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("id");
		s.delProductById(Integer.valueOf(productId));
		request.getRequestDispatcher("/manage/ManageServlet?op=listProduct").forward(request, response);
	}

	/**
	 * 添加商品
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 封装数据
		Product product = FillBeanUtil.fillBean(request, Product.class);
		s.addProduct(product);
		request.setAttribute("message", "添加商品成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 查询商品
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> list = s.findAllProduct();
		request.setAttribute("listProducts", list);
		request.getRequestDispatcher("/manage/showAllProducts.jsp").forward(request, response);
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
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 修改分类
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void updateCategoryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 封装
		Category category = FillBeanUtil.fillBean(request, Category.class);
		// id
		Integer id = Integer.valueOf(request.getParameter("id"));
		if (s.updateCategory(id, category)) {
			request.setAttribute("message", "更新分类成功");
		} else {
			request.setAttribute("message", "更新分类失败");
		}
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 删除分类
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void delCategoryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryName = request.getParameter("id");
		s.delCategoryByName(categoryName);
		request.getRequestDispatcher("/manage/ManageServlet?op=listCategory").forward(request, response);
	}

	/**
	 * 添加分类
	 * 
	 * @param request
	 * @param response
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void addCategories(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 封装数据
		Category c = FillBeanUtil.fillBean(request, Category.class);
		s.addCategory(c);
		request.setAttribute("message", "添加分类成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 查询分类
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCategories = s.findAllCategory();
		request.setAttribute("listCategories", listCategories);
		request.getRequestDispatcher("/manage/showAllCategories.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
