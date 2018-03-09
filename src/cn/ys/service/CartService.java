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
	 * @param userId
	 * @return
	 */
	List<Cart> findCartByUserId(String userId);

	/**
	 * 保存购物车商品
	 * 
	 * @param cart
	 */
	void saveCart(Cart... carts);

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
