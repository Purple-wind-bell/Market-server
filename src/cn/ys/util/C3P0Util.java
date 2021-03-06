package cn.ys.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();

	private C3P0Util() {
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("获取连接失败");
		}
	}
}
