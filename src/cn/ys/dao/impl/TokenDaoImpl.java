package cn.ys.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.ys.dao.TokenDao;
import cn.ys.util.C3P0Util;
import cn.ys.vo.Token;

public class TokenDaoImpl implements TokenDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public void save(Token token) {
		try {
			qr.update("insert into token (username,uuid) values(?,?)", token.getUsername(), token.getUuid());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public boolean delToken(String uuid) {
		int row = -1;
		try {
			row = qr.update("delete from user where uuid = ?", uuid);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return row != -1;
	}

	@Override
	public Token findByUUID(String uuid) {
		Token token = null;
		try {
			token = qr.query("select * from token where uuid = ?", new BeanHandler<Token>(Token.class), uuid);
		} catch (SQLException e) {
			// throw new RuntimeException("token查询失败");
			e.printStackTrace();
		}
		return token;
	}

	@Override
	public Token findByUsername(String username) {
		Token token = null;
		try {
			token = qr.query("select * from token where username = ?", new BeanHandler<Token>(Token.class), username);
		} catch (SQLException e) {
			// throw new RuntimeException("token查询失败");
			e.printStackTrace();
		}
		return token;
	}

}
