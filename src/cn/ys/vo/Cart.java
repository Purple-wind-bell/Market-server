package cn.ys.vo;

/**
 * 单商品购物车
 * 
 * @author Administrator
 *
 */
public class Cart {
	String userId;
	String productId;
	Integer quantity;

	public Cart(String userId, String productId, Integer quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Cart() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public String getProductId() {
		return productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
