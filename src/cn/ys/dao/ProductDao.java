package cn.ys.dao;

import java.util.List;

import cn.ys.vo.Product;

public interface ProductDao {
	/**
	 * 添加商品
	 * 
	 * @param product
	 */
	boolean addProduct(Product product);

	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	List<Product> findAll();

	/**
	 * 修改商品信息
	 * 
	 * @param proId
	 *            商品id
	 * @param product
	 */
	void updateProduct(Integer proId, Product product);

	/**
	 * 删除商品
	 * 
	 * @param id
	 *            商品id
	 * @return
	 */
	boolean deleteProductById(Integer id);

	/**
	 * 查询商品
	 * 
	 * @param productStr
	 *            商品名称
	 * @return
	 */
	List<Product> findByName(String productName);

	/**
	 * 查询商品
	 * 
	 * @param id
	 *            商品名称
	 * @return
	 */
	Product findById(Integer id);

	/**
	 * 根据所有者查询
	 * 
	 * @return
	 */
	List<Product> findByOwner(String ownername);

}
