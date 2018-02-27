package cn.ys.service;

import java.sql.Timestamp;

public interface VerifyService {

	/**
	 * 为访问者添加验证码
	 * 
	 * @param webCode
	 *            验证码
	 * @param currentTime
	 *            请求时间
	 * @param visitor
	 *            访问者信息
	 */
	void updateWebCode(String webCode, Timestamp currentTime, String visitor);

	/**
	 * 检查验证码是否有效
	 * 
	 * @param webCode
	 * @param currentTime
	 * @param visitor
	 * @return true-有效
	 */
	boolean isWebCodeEffective(String webCode, Timestamp currentTime, String visitor);
}
