package cn.ys.util;

import java.util.Properties;

/**
 * 参数配置，以及常量
 * 
 * @author Administrator
 *
 */
public final class Constant {
	/** MySQL数据库连接 */
	public static String MYSQL_URL;
	/** MySQL用户 */
	public static String MYSQL_USER;
	/** MySQL用户密码 */
	public static String MYSQL_PASSWORD;

	static {
		Properties properties = new Properties();
		// String mysqlConfigPath = "mysql.properties";
		// String.class.getClassLoader();
		// InputStream inStream =
		// ClassLoader.getSystemResourceAsStream(mysqlConfigPath);
		// try {
		// properties.load(inStream);
		// inStream.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		MYSQL_URL = properties.getProperty("mysqlUrl", "jdbc:mysql://localhost:3306/market-web");
		MYSQL_USER = properties.getProperty("mysqlUser", "root");
		MYSQL_PASSWORD = properties.getProperty("mysqlPassword", "123456");
	}

	private Constant() {
	}

	/**
	 * 获得数据库url
	 * 
	 * @return string类型的url
	 */
	public static String getMysqlUrl() {
		return MYSQL_URL;
	}

	/**
	 * 获得MySQL用户名
	 * 
	 * @return 用户名
	 */
	public static String getMysqlUser() {
		return MYSQL_USER;
	}

	/**
	 * 获得MySQL用户密码
	 * 
	 * @return 密码
	 */
	public static String getMysqlPassword() {
		return MYSQL_PASSWORD;
	}

}
