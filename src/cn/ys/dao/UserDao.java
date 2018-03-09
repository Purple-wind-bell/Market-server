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
	 */
	void addUser(User user);

	/**
	 * 根据用户名删除用户
	 * 
	 * @param username
	 *            用户名
	 * @return true-删除成功；false-删除失败
	 */
	boolean delUser(String username, String password);

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 *            用户对象
	 * @param password
	 *            密码
	 * @return true-修改成功；false-修改失败
	 */
	public boolean updateUser(User user, String password);

	/**
	 * 
	 * /** 通过用户名获取用户信息
	 * 
	 * @param username
	 *            用户名
	 * @return user对象
	 */
	User getUserByName(String username);
}
