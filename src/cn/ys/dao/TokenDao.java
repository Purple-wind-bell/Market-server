package cn.ys.dao;

import cn.ys.vo.Token;

/**
 * 登录验证存储
 * 
 * @author Administrator
 *
 */
public interface TokenDao {
	/**
	 * 保存登录验证
	 * 
	 * @param token
	 */
	void save(Token token);

	/**
	 * 查询登录信息
	 * 
	 * @param uuid
	 * @return
	 */
	Token findByUUID(String uuid);

	/**
	 * 删除登录验证
	 * 
	 * @param uuid
	 * @return
	 */
	boolean delToken(String uuid);

}
