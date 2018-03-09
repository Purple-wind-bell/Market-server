package cn.ys.service;

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
	boolean isWebCodeEffective(String code, String visitorId);
}
