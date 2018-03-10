package cn.ys.service.impl;

import java.util.List;

import cn.ys.dao.CartDao;
import cn.ys.dao.impl.CartDaoImpl;
import cn.ys.service.CartService;
import cn.ys.vo.Cart;

public class CartServiceImpl implements CartService {
	private CartDao cDao = new CartDaoImpl();

	@Override
	public List<Cart> findCartByUsername(String username) {
		return cDao.findAll(username);
	}

	@Override
	public void addCart(Cart... carts) {
		if (carts != null) {
			for (Cart cart : carts) {
				Cart c = cDao.findCart(cart.getUsername(), cart.getProductId());
				// 购物车中已有该商品
				if (c != null) {
					c.setQuantity(c.getQuantity() + 1);
					cDao.editCart(c);
				} else {
					// 没有该商品，添加
					cDao.save(cart);
				}
			}
		}
	}

	@Override
	public void delCart(Cart... carts) {
		for (Cart cart : carts) {
			cDao.delCart(cart);
		}
	}

	@Override
	public void editCarts(Cart... carts) {
		for (Cart cart : carts) {
			cDao.editCart(cart);
		}
	}

}
