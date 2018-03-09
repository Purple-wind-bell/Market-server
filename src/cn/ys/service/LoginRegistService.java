package cn.ys.service;

import cn.ys.vo.User;

public interface LoginRegistService {

	/**
	 * 用户登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 1-登录成功；2-密码错误；3-用户不存在；4-登录失败，未知错误
	 */
	int login(String username, String password);

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户对象
	 * @return 1-注册成功；2-用户已存在，无法注册；3-注册失败，原因未知
	 */
	int registUser(User user);

	/**
	 * 用户注销
	 * 
	 * @param uuid
	 */
	void logout(String uuid);

}