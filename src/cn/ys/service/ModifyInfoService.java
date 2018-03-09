package cn.ys.service;

import cn.ys.vo.User;

public interface ModifyInfoService {

	/**
	 * 通过用户名，密码修改信息
	 * 
	 * @param user
	 *            用户
	 * @param password
	 *            密码
	 * @return 1-成功；2-失败；3-未知错误；
	 */
	int editUserInfo(User user, String password);

	/**
	 * 
	 * @param username
	 * @param password
	 * @return 1-成功;2-用户不存在;3-失败
	 */
	int resetPassword(String username, String password);

}