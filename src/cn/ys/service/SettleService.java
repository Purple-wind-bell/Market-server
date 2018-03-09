package cn.ys.service;

import cn.ys.vo.Cart;
import cn.ys.vo.Order;

/**
 * 结算服务
 * 
 * @author Administrator
 *
 */
public interface SettleService {
	/**
	 * 生成订单
	 * 
	 * @param carts
	 * @return
	 */
	Order createOrder(Cart... carts);

	
}
