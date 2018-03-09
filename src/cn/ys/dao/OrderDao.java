package cn.ys.dao;

import java.util.List;
import cn.ys.vo.Order;

/**
 * 数据库订单Dao
 * 
 * @author Administrator
 *
 */
public interface OrderDao {
	/**
	 * 保存订单
	 * 
	 * @param order
	 */
	void save(Order order);

	/**
	 * 编辑订单
	 * 
	 * @param order
	 */
	void editOrder(Order order);

	/**
	 * 查询订单
	 * 
	 * @param userId
	 * @return
	 */
	List<Order> findAllByUserId(String userId);

	/**
	 * 删除订单
	 * 
	 * @param orderId
	 *            订单id
	 */
	void delOrder(String orderId);
}
