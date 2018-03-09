package cn.ys.vo;

import java.util.Date;

/**
 * 订单类
 * 
 * @author Administrator
 *
 */
public class Order {
	/** 订单号 */
	String id;
	/** 订单状态 */
	Integer status;
	/** 购物者id */
	String userId;
	/** 支付金额 */
	Float pay;
	/** 订单生成时间 */
	Date gentime;
	/** 支付时间 */
	Date paytime;

	public Order() {
		super();
	}

	public Order(String id, Integer status, String userId, Float pay, Date gentime, Date paytime) {
		super();
		this.id = id;
		this.status = status;
		this.userId = userId;
		this.pay = pay;
		this.gentime = gentime;
		this.paytime = paytime;
	}

	public String getId() {
		return id;
	}

	public Integer getStatus() {
		return status;
	}

	public String getUserId() {
		return userId;
	}

	public Float getPay() {
		return pay;
	}

	public Date getGentime() {
		return gentime;
	}

	public Date getPaytime() {
		return paytime;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPay(Float pay) {
		this.pay = pay;
	}

	public void setGentime(Date gentime) {
		this.gentime = gentime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

}
