package cn.ys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接及释放的工具类
 * 
 * @author 紫风铃
 *
 */
public class DBUtil {
	/** MySQL数据库连接 */
	private static String mysqlUrl = Constant.MYSQL_URL;
	/** MySQL用户 */
	private static String mysqlUser = Constant.MYSQL_USER;
	/** MySQL用户密码 */
	private static String mysqlPassword = Constant.MYSQL_PASSWORD;

	private DBUtil() {
	}

	/**
	 * 获得数据库连接
	 * 
	 * @return 数据库连接
	 */
	public static Connection getconnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 释放数据库连接
	 * 
	 * @param connection
	 *            数据库连接
	 */
	public static void releaseConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
