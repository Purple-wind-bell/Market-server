package cn.ys.vo;

import java.io.Serializable;

/**
 * 单商品购物车
 * 
 * @author Administrator
 *
 */
public class Cart implements Serializable {
	String username;
	String productId;
	Integer quantity;

	public Cart() {
		super();
	}

	public Cart(String username, String productId, Integer quantity) {
		super();
		this.username = username;
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getUsername() {
		return username;
	}

	public String getProductId() {
		return productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
