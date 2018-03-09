package cn.ys.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.ys.dao.CartDao;
import cn.ys.util.C3P0Util;
import cn.ys.vo.Cart;

public class CartDaoImpl implements CartDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public void save(Cart cart) {
		try {
			qr.update("insert into cart (userId,productId,quantity) values(?,?,?)", cart.getUserId(),
					cart.getProductId(), cart.getQuantity());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void delCart(Cart cart) {
		try {
			qr.update("delete from user where userId = ? and productId = ?", cart.getUserId(), cart.getProductId());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Cart> findAll(String userId) {
		try {
			return qr.query("select * from cart where userId = ?", new BeanListHandler<Cart>(Cart.class), userId);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void editCart(Cart cart) {
		try {
			qr.update("update cart set quantity =?  where userId = ? and productId = ?", cart.getQuantity(),
					cart.getUserId(), cart.getProductId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
