package cn.ys.vo;

/**
 * 用户登录安全
 * 
 * @author Administrator
 *
 */
public class Token {
	String userId;
	String uuid;

	public Token(String userId, String uuid) {
		super();
		this.userId = userId;
		this.uuid = uuid;
	}

	public Token() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
