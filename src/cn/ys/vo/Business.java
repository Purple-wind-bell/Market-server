package cn.ys.vo;

/**
 * 商家类
 * 
 * @author Administrator
 *
 */
public class Business {
	/** id */
	String id;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;

	public Business() {
		super();
	}

	public Business(String id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
