package cn.ys.vo;

import java.io.Serializable;

/**
 * 用户类
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	/** 用户名 */
	private String username;
	/** 昵称 */
	private String nickname;
	/** 密码 */
	private String password;
	/** 邮箱 */
	private String email;
	/** 手机 */
	private String phone;

	public User() {
		super();
	}

	public User(String username, String nickname, String password, String email, String phone) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.phone = phone;

	}

	public String getUsername() {
		return username;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
