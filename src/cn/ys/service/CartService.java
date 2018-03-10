package cn.ys.service;

import java.util.List;

import cn.ys.vo.Cart;

/**
 * 购物车服务
 * 
 * @author Administrator
 *
 */
public interface CartService {
	/**
	 * 查询购物车
	 * 
	 * @param username
	 * @return
	 */
	List<Cart> findCartByUsername(String username);

	/**
	 * 添加到购物车，购物车中单种商品的数量增加
	 * 
	 * @param cart
	 */
	void addCart(Cart... carts);

	/**
	 * 删除购物车商品
	 * 
	 * @param carts
	 */
	void delCart(Cart... carts);

	/**
	 * 修改购物车商品数量
	 * 
	 * @param carts
	 */
	void editCarts(Cart... carts);
}
