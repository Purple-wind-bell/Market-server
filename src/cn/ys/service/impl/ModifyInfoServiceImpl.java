package cn.ys.service.impl;

import cn.ys.dao.UserDao;
import cn.ys.dao.impl.UserDaoImpl;
import cn.ys.service.ModifyInfoService;

/**
 * 用户信息修改
 * 
 * @author Administrator
 * @since 1.0
 */
public class ModifyInfoServiceImpl implements ModifyInfoService {
	private UserDao uDao = new UserDaoImpl();

	/* (non-Javadoc)
	 * @see cn.ys.service.impl.ModifyInfoService#ResetPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public int resetPassword(String username, String password) {
		int status = 2;
		if (uDao.resetPassword(username, password)) {
			status = 1;
		} else {
			status = 2;
		}
		return status;
	}

}
