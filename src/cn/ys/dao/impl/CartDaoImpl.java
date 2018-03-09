package cn.ys.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.ys.dao.CartDao;
import cn.ys.util.C3P0Util;
import cn.ys.vo.Cart;

public class CartDaoImpl implements CartDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public void save(Cart cart) {
		try {
			qr.update("insert into cart (username,productId,quantity) values(?,?,?)", cart.getUsername(),
					cart.getProductId(), cart.getQuantity());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void delCart(Cart cart) {
		try {
			qr.update("delete from user where username = ? and productId = ?", cart.getUsername(), cart.getProductId());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Cart> findAll(String username) {
		try {
			return qr.query("select * from cart where username = ?", new BeanListHandler<Cart>(Cart.class), username);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void editCart(Cart cart) {
		try {
			qr.update("update cart set quantity =?  where username = ? and productId = ?", cart.getQuantity(),
					cart.getUsername(), cart.getProductId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cart findCart(String username, String productId) {
		try {
			return qr.query("select * from cart where username = ?", new BeanHandler<Cart>(Cart.class), username);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
