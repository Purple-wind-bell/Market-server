package cn.ys.service;

import java.util.List;

import cn.ys.vo.Product;
import cn.ys.vo.Category;

public interface BusinessService {

	/**
	 * 添加分类
	 * 
	 * @param category
	 */
	void addCategory(Category category);

	/**
	 * 查询分类名称是否存在
	 * 
	 * @param categoryName
	 * @return true-存在
	 */
	boolean categoryExit(String categoryName);

	/**
	 * 查询所有分类
	 * 
	 * @return
	 */
	List<Category> findAllCategory();

	/**
	 * 查询分类
	 * 
	 * @param categoryId
	 *            分类id
	 * @return
	 */
	Category findCategoryById(Integer categoryId);

	/**
	 * 添加商品
	 * 
	 * @param product
	 *            商品分类 不能为空
	 */
	void addProduct(Product product);

	/**
	 * 根据id查询商品对象，对应的分类也要查询出来。延迟加载（用到时再加载）
	 * 
	 * @param productId
	 *            商品id
	 * @return
	 */
	Product findProductById(Integer productId);

	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	List<Product> findAllProduct();

	/**
	 * 修改商品信息
	 * 
	 * @param product
	 */
	void editProduct(Product product);

	/**
	 * 删除商品
	 * 
	 * @param productIDs
	 *            商品id数组
	 */
	void delProduct(String... productIDs);

	/**
	 * 修改分类
	 * 
	 * @param categoryName
	 * @param category
	 * @return
	 */
	boolean updateCategory(Integer id, Category category);

	/**
	 * 删除分类
	 * 
	 * @param categoryName
	 */
	void delCategoryByName(String categoryName);

	/**
	 * 删除商品
	 * 
	 * @param productId
	 *            商品id
	 */
	void delProductById(Integer productId);

	/**
	 * 根据商品管理者查询商品
	 * 
	 * @return
	 */
	List<Product> findAllProductsByOwner(String ownername);

}
