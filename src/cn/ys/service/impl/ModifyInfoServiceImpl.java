package cn.ys.service.impl;

import cn.ys.dao.UserDao;
import cn.ys.dao.impl.UserDaoImpl;
import cn.ys.service.ModifyInfoService;
import cn.ys.vo.User;

/**
 * 用户信息修改
 * 
 * @author Administrator
 * @since 1.0
 */
public class ModifyInfoServiceImpl implements ModifyInfoService {
	private UserDao uDao = new UserDaoImpl();

	@Override
	public int editUserInfo(User user, String password) {
		int status = 2;
		if (uDao.updateUser(user, password)) {
			status = 1;
		}
		return status;
	}

	@Override
	public int resetPassword(String username, String password) {
		int status = 3;
		User user = uDao.getUserByName(username);
		if (user == null) {
			status = 2;// 用户不存在
		} else {
			String passwd = user.getPassword();
			user.setPassword(password);
			if (uDao.updateUser(user, passwd)) {
				status = 1;
			}
		}
		return status;
	}

}
