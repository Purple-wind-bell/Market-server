package cn.ys.service.impl;

import java.util.List;

import cn.ys.dao.ProductDao;
import cn.ys.dao.CategoryDao;
import cn.ys.dao.impl.ProductDaoImpl;
import cn.ys.dao.impl.CateGoryDaoImpl;
import cn.ys.service.BusinessService;
import cn.ys.vo.Product;
import cn.ys.vo.Category;

public class BusinessServiceImpl implements BusinessService {
	private CategoryDao catedao = new CateGoryDaoImpl();
	private ProductDao productDao = new ProductDaoImpl();

	@Override
	public void addCategory(Category category) {
		if (category == null) {
			throw new IllegalArgumentException("category not null");
		}
		catedao.save(category);
	}

	@Override
	public boolean categoryExit(String categoryName) {
		return catedao.findByName(categoryName);
	}

	@Override
	public List<Category> findAllCategory() {
		return catedao.findAll();
	}

	@Override
	public Category findCategoryById(Integer categoryId) {
		return catedao.findById(categoryId);
	}

	@Override
	public boolean updateCategory(Integer id, Category category) {
		return catedao.update(id, category);
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public Product findProductById(Integer productId) {
		return productDao.findById(productId);
	}

	@Override
	public void delCategoryByName(String categoryName) {
		catedao.deleteByName(categoryName);
	}

	@Override
	public void delProductById(Integer productId) {
		productDao.deleteProductById(productId);
	}

	@Override
	public List<Product> findAllProduct() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findAllProductsByOwner(String ownername) {
		return productDao.findByOwner(ownername);
	}

	@Override
	public void editProduct(Product product) {
		productDao.updateProduct(product.getId(), product);
	}

	@Override
	public void delProduct(String... productIDs) {
		for (String productID : productIDs) {
			productDao.deleteProductById(Integer.valueOf(productID));
		}
	}

}
