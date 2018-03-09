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
	 * 删除
	 * 
	 * @param cart
	 */
	void delCart(Cart cart);

	List<Cart> findAll(String userId);

	/**
	 * 修改，一般为修改数量
	 * 
	 * @param cart
	 */
	void editCart(Cart cart);
}
