package cn.ys.util;

/**
 * 参数配置，以及常量
 * 
 * @author Administrator
 *
 */
public final class Constant {
	/** MySQL数据库连接 */
	public static String MYSQL_URL = "jdbc:mysql://127.0.0.1:3306/market-web";
	/** MySQL用户名 */
	public static String MYSQL_USER = "root";
	/** MySQL用户密码 */
	public static String MYSQL_PASSWORD = "123456";
	/** 购物页的message显示页面 */
	public static String SHOPPING_MESSAGE_URI = "/shopping/message.jsp";
	/** 登录注册页的message显示页面 */
	public static String LOGIN_MESSAGE_URI = "/message.jsp";

	private Constant() {
	}

}
