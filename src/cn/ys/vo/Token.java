package cn.ys.vo;

/**
 * 用户登录安全
 * 
 * @author Administrator
 *
 */
public class Token {
	String username;
	String uuid;

	public Token(String username, String uuid) {
		super();
		this.username = username;
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
