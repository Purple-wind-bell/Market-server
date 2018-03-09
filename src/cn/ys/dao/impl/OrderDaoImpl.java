package cn.ys.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.ys.dao.OrderDao;
import cn.ys.util.C3P0Util;
import cn.ys.vo.Order;

public class OrderDaoImpl implements OrderDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public void save(Order order) {
		try {
			qr.update("insert into order (id,status,userId,pay,gentime,paytime) values(?,?,?,?,?,?)", order.getId(),
					order.getStatus(), order.getUserId(), order.getPay(), order.getGentime(), order.getPaytime());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void editOrder(Order order) {
		try {
			qr.update("update product set status=?,userId=?,pay=?,gentime=?,paytime=? where id = ?", order.getStatus(),
					order.getUserId(), order.getPay(), order.getGentime(), order.getPaytime(), order.getId());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Order> findAllByUserId(String userId) {
		try {
			return qr.query("select * from order", new BeanListHandler<Order>(Order.class));
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void delOrder(String orderId) {
		try {
			qr.update("delete from product where id = ?", orderId);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
