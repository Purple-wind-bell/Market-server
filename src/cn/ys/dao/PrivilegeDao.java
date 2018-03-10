package cn.ys.dao;

import cn.ys.vo.Business;

/**
 * 数据库-商家
 * 
 * @author Administrator
 *
 */
public interface PrivilegeDao {

	/**
	 * 添加商家
	 * 
	 * @param business
	 *            商家对象
	 * @return true-添加成功；false-添加失败
	 */
	boolean save(Business business);

	/**
	 * 删除商家表对应信息
	 * 
	 * @param username
	 *            用户名
	 * @return true-删除成功；false-删除失败
	 */
	boolean delUser(String username, String password);

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
	 * 通过用户名获取用户信息，包括密码
	 * 
	 * @param username
	 *            用户名
	 * @return user对象
	 */
	Business getBusinessByID(String username);

}
