package cn.ys.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.ys.dao.TokenDao;
import cn.ys.util.C3P0Util;
import cn.ys.vo.Token;

public class TokenDaoImpl implements TokenDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public void save(Token token) {
		try {
			qr.update("insert into token (userId,uuid) values(?,?)", token.getUserId(), token.getUuid());
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

}
