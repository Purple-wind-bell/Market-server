package cn.ys.web.bean;

import java.io.Serializable;

import cn.ys.vo.Product;

/**
 * 购物车封装，传递给jsp
 * 
 * @author Administrator
 *
 */
public class CartBean implements Serializable {
	private Product product;
	private Integer quantity;
	// 小计
	private Float subprice;

	public CartBean() {
		super();
	}

	public CartBean(Product product, Integer quantity, Float subprice) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.subprice = subprice;
	}

	public Product getProduct() {
		return product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Float getSubprice() {
		return subprice;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setSubprice(Float subprice) {
		this.subprice = subprice;
	}

}
