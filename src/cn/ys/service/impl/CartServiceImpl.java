package cn.ys.service.impl;

import java.util.List;

import cn.ys.dao.CartDao;
import cn.ys.dao.impl.CartDaoImpl;
import cn.ys.service.CartService;
import cn.ys.vo.Cart;

public class CartServiceImpl implements CartService {
	private CartDao cDao = new CartDaoImpl();

	@Override
	public List<Cart> findCartByUserId(String userId) {
		return cDao.findAll(userId);
	}

	@Override
	public void saveCart(Cart... carts) {
		for (Cart cart : carts) {
			cDao.save(cart);
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
