package cn.ys.dao;

import cn.ys.vo.User;

/**
 * 数据库用户表接口
 * 
 * @author Administrator
 *
 */
public interface UserDao {

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户对象
	 * @return true-添加成功；false-添加失败
	 */
	boolean addUser(User user);

	/**
	 * 根据用户名删除用户
	 * 
	 * @param username
	 *            用户名
	 * @return true-删除成功；false-删除失败
	 */
	boolean delUser(String username, String password);

	/**
	 * 修改用户信息，不包含密码
	 * 
	 * @param user
	 *            用户对象，存储修改后的用户信息，其中password不可以修改，仅用于校验，username数据库唯一，不可修改
	 * @return true-修改成功；false-修改失败
	 */
	boolean updateUser(User user);

	/**
	 * 通过用户名，旧密码修改为新密码
	 * 
	 * @param username
	 *            用户名
	 * @param oldPassword
	 *            旧密码，用于内部校验
	 * @param newPassword
	 *            新密码
	 * @return true-修改成功；false-修改成功
	 */
	boolean updatePassword(String username, String oldPassword, String newPassword);

	/**
	 * 检测用户是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return true-存在；false-不存在
	 */
	boolean userExist(String username);

	/**
	 * 判断所有该用户名与密码的用户是否存在
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return true-用户名与密码正确；false-用户名与密码错误
	 */
	boolean isPasswordCorrect(String username, String password);

	/**
	 * 通过用户名获取用户信息，不包括密码
	 * 
	 * @param username
	 *            用户名
	 * @return user对象
	 */
	User getUserByID(String username);

	/**
	 * 通过用户名获取邮箱
	 * 
	 * @param username
	 *            用户名
	 * @return 邮箱string
	 */
	String getEmailByID(String username);

	/**
	 * 通过用户名，重置密码
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            新密码
	 * @return true-修改成功；false-修改成功
	 */
	boolean resetPassword(String username, String password);
}
