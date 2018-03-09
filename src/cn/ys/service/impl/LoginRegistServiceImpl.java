package cn.ys.service.impl;

import cn.ys.dao.UserDao;
import cn.ys.dao.impl.UserDaoImpl;
import cn.ys.service.LoginRegistService;
import cn.ys.vo.User;

/**
 * 登录注册服务
 * 
 * @author Administrator
 * 
 */
public class LoginRegistServiceImpl implements LoginRegistService {
	private UserDao udao = new UserDaoImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.ys.service.impl.LoginRegistService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public int login(String username, String password) {
		int status;
		// 检测用户是否存在
		if (udao.getUserByName(username) == null) {
			// 用户不存在
			status = 3;
		} else {
			// 密码校验
			if (udao.getUserByName(username).getPassword().equals(password)) {
				// 密码正确
				status = 1;
			} else {
				status = 2;
			}
		}
		return status;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.ys.service.impl.LoginRegistService#registUser(cn.ys.vo.User)
	 */
	@Override
	public int registUser(User user) {
		int status;
		// 检测用户是否存在
		if (udao.getUserByName(user.getUsername()) != null) {
			// 用户已存在
			status = 2;
		} else {
			// 用户不存在，添加用户进入数据库
			udao.addUser(user);
			// 检测用户数据是否写入数据库
			if (udao.getUserByName(user.getUsername()) != null) {
				status = 1;
			} else {
				udao.addUser(user); // 用户不存在，注册失败
				status = 3;
			}
		}

		return status;

	}
}
