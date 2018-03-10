package cn.ys.dao;

import java.util.List;

import cn.ys.vo.Cart;

/**
 * 购物车
 * 
 * @author Administrator
 *
 */
public interface CartDao {
	/**
	 * 保存购物车
	 * 
	 * @param cart
	 */
	void save(Cart cart);

	/**
	 * 清空指定用户的购物车
	 * 
	 * @param username
	 */
	void delAllCarts(String username);

	/**
	 * 删除
	 * 
	 * @param cart
	 */
	void delCart(Cart cart);

	/**
	 * 查询该用户所有购物车
	 * 
	 * @param username
	 * @return
	 */
	List<Cart> findAll(String username);

	/**
	 * 修改，一般为修改数量
	 * 
	 * @param cart
	 */
	void editCart(Cart cart);

	/**
	 * 查询指定用户的购物车中的制定商品
	 * 
	 * @param username
	 * @param productId
	 * @return null-没有该商品；cart-返回指定商品在购物车中的数据
	 */
	Cart findCart(String username, String productId);
}
