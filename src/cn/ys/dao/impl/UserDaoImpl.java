package cn.ys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.ys.dao.UserDao;
import cn.ys.util.C3P0Util;
import cn.ys.util.DBUtil;
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
	public boolean addUser(User user) {
		Connection conn = DBUtil.getconnection();
		String sql = "insert into user values(?,?,?,?,?)";
		int rows = -1;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getNickname());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			DBUtil.releaseConnection(conn);
		}
		return rows > 0;
	}

	@Override
	public boolean delUser(String username, String password) {
		Connection conn = DBUtil.getconnection();
		String sql = "delete from user where username = ? and password = ?";
		int rows = -1;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			DBUtil.releaseConnection(conn);
		}
		return rows > 0;
	}

	@Override
	public boolean updateUser(User user) {
		Connection conn = DBUtil.getconnection();
		String sql = "update user set nickname = ?, email = ?, phone = ? where username = ? and password = ?";
		int rows = -1;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getNickname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			DBUtil.releaseConnection(conn);
		}
		return rows > 0;
	}

	@Override
	public boolean updatePassword(String username, String oldPassword, String newPassword) {
		Connection conn = DBUtil.getconnection();
		String sql = "update user set password = ? where username = ? and password = ?";
		int rows = -1;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, newPassword);
			ps.setString(3, oldPassword);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			DBUtil.releaseConnection(conn);
		}
		return rows > 0;
	}

	@Override
	public boolean userExist(String username) {
		Connection conn = DBUtil.getconnection();
		String sql = "select username from user where username = ?";
		boolean status = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				status = true;
			}
			rs.close();
		} catch (SQLException e) {
			DBUtil.releaseConnection(conn);
		}
		return status;
	}

	@Override
	public boolean isPasswordCorrect(String username, String password) {
		Connection conn = DBUtil.getconnection();
		String sql = "select username from user where username = ? and password = ?";
		boolean status = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				status = true;
			}
			rs.close();
		} catch (SQLException e) {
			DBUtil.releaseConnection(conn);
		}
		return status;
	}

	@Override
	public User getUserByID(String username) {
		User user = null;
		try {
			user = qr.query("select * from product where username = ?", new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			throw new RuntimeException("ss");
		}
		return user;
	}

	@Override
	public String getEmailByID(String username) {
		Connection conn = DBUtil.getconnection();
		String sql = "select email from user where username = ?";
		String email = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				email = rs.getString("email");
			}
			rs.close();
		} catch (SQLException e) {
			DBUtil.releaseConnection(conn);
		}
		return email;
	}

	@Override
	public boolean resetPassword(String username, String password) {
		Connection conn = DBUtil.getconnection();
		String sql = "update user set password = ? where username = ?";
		int rows = -1;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			DBUtil.releaseConnection(conn);
		}
		return rows > 0;
	}

}
