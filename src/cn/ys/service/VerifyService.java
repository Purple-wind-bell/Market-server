package cn.ys.service;

/**
 * 验证服务
 * 
 * @author Administrator
 *
 */
public interface VerifyService {

	/**
	 * 为访问者添加验证码
	 * 
	 * @param code
	 *            验证码
	 * @param visitorId
	 *            访问者id
	 * @return visitorId-code
	 */
	void updateWebCode(String code, String visitorId);

	/**
	 * 检查验证码是否有效
	 * 
	 * @param code
	 * @param visitorId
	 * @return true-有效
	 */
	boolean isCodeEffective(String code, String visitorId);

	/**
	 * 绑定用户名与浏览器
	 * 
	 * @param visitorID
	 * @param username
	 */
	void bindUser(String visitorID, String username);

	/**
	 * 根据cookie的visitorID查询是否绑定登录用户
	 * 
	 * @param visitorID
	 * @return 未绑定，返回null；否则返回username
	 */
	String queryBindUsername(String visitorID);

	/**
	 * 清除token
	 * 
	 * @param visitorID
	 */
	void clearToken(String visitorID);

	/**
	 * 查询绑定的visitorID
	 * @param username
	 * @return
	 */
	String queryUUIDByUsername(String username);
}
