package cn.ys.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import cn.ys.dao.UserDao;
import cn.ys.util.C3P0Util;
import cn.ys.vo.User;

/**
 * user的dao包，控制数据库user表
 * 
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public void addUser(User user) {
		try {
			qr.update("insert into user (id,username,nickname,password,email,phone) values(?,?,?,?,?,?)", user.getId(),
					user.getUsername(), user.getNickname(), user.getPassword(), user.getEmail(), user.getPhone());
		} catch (SQLException e) {
//			throw new RuntimeException();
			e.printStackTrace();
		}
	}

	@Override
	public boolean delUser(String username, String password) {
		int row = -1;
		try {
			row = qr.update("delete from user where username = ? and password = ?", username, password);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return row != -1;
	}

	@Override
	public boolean updateUser(User user, String password) {
		int row = -1;
		try {
			row = qr.update(
					"update user set username= ?, nickname = ?, password = ?, email = ?, phone = ? where username = ? and password = ?",
					user.getUsername(), user.getNickname(), user.getPassword(), user.getEmail(), user.getPhone(),
					user.getUsername(), password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row != -1;

	}

	@Override
	public User getUserByName(String username) {
		User user = null;
		try {
			user = qr.query("select * from user where username = ?", new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
//			throw new RuntimeException("ss");
			e.printStackTrace();
		}
		return user;
	}

}
