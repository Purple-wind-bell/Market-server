package cn.ys.service;

public interface ModifyInfoService {

	/**
	 * 通过用户名，邮箱验证码重置密码
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            新密码
	 * @return 1-成功；2-失败；3-未知错误；
	 */
	int resetPassword(String username, String password);

}