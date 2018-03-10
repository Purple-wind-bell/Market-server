package cn.ys.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

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
				try {
					addProduct(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			building(request, response);
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
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean isentype = ServletFileUpload.isMultipartContent(request);
		if (!isentype) {
			throw new RuntimeException("你的表单必须是enctype=\"multipart/form-data类型");
		}
		// 类型正确
		// 解析
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> items = new ArrayList<>(0);
		items = sfu.parseRequest(request);
		Product product = new Product();
		for (FileItem item : items) {
			if (item.isFormField()) {
				// 普通字段
				processFormField(item, product);
			} else {
				// 上传字段
				processUploadFormField(item, product);
			}
		}
		// 保存数据
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

	/**
	 * 创建文件目录
	 * 
	 * @param storeDirection
	 * @return
	 */
	private String makeChildDirection(String storeDirection) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String childDir = df.format(now);
		File file = new File(storeDirection, childDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return childDir;
	}

	/**
	 * 普通字段
	 * 
	 * @param item
	 * @param product
	 * @throws UnsupportedEncodingException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private void processFormField(FileItem item, Product product)
			throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException {
		// 表单name表单的输入域的name和book的属性名保持一致
		String fieldName = item.getFieldName();
		// name
		String fieldValue = item.getString("UTF-8");

		// 单独关联分类
		if ("categoryId".equals(fieldName)) {
			// 分类 关联分类的信息
			Category category = s.findCategoryById(Integer.parseInt(fieldValue));
			product.setCategory(category);
		} else {
			// 其他属性
			BeanUtils.setProperty(product, fieldName, fieldValue);// 相当于调用队形的setXXX
		}
	}

	/**
	 * 上传字段
	 * 
	 * @param item
	 * @param product
	 * @throws Exception
	 */
	private void processUploadFormField(FileItem item, Product product) throws Exception {
		// 得到书籍存放的路径 根目录下/images
		// C:\apache-tomcat-9\webapps\bookstore\images \1\2.....jpg
		String storeDirection = getServletContext().getRealPath("/images");
		String childDirection = makeChildDirection(storeDirection);
		product.setPath(childDirection);// 设置路径

		// 去掉原来的文件名 重新生成一个UUID 文件避免重复
		String fileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(item.getName());
		product.setFilename(fileName);
		item.write(new File(storeDirection + File.separator + childDirection, fileName));

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
