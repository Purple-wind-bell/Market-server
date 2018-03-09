package cn.ys.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import cn.ys.dao.TokenDao;
import cn.ys.dao.impl.TokenDaoImpl;
import cn.ys.service.VerifyService;
import cn.ys.vo.Code;
import cn.ys.vo.Token;

public class VerifyServiceImpl implements VerifyService {
	private static Map<String, Code> codeMap = new HashMap<String, Code>();
	private static Map<String, Token> tokenMap = new HashMap<String, Token>();
	private TokenDao tdao = new TokenDaoImpl();

	@Override
	public void updateWebCode(String code, String visitorId) {
		if (codeMap.containsKey(visitorId)) {
			// 更新验证码
			codeMap.replace(visitorId, new Code(visitorId, code, new Timestamp(new Date().getTime())));
		} else {
			// 添加验证码
			codeMap.put(visitorId, new Code(visitorId, code, new Timestamp(new Date().getTime())));
		}
	}

	@Override
	public boolean isCodeEffective(String code, String visitorId) {
		Code c = codeMap.get(visitorId);
		if (c != null && code.equalsIgnoreCase(codeMap.get(visitorId).getCode())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void bindUser(String visitorID, String username) {
		Token token = new Token(username, visitorID);
		tokenMap.put(visitorID, token);
		tdao.save(token);
	}

	@Override
	public String queryBindUsername(String visitorID) {
		Token token = null;
		if (tokenMap.containsKey(visitorID)) {
			token = tokenMap.get(visitorID);
		} else {
			token = tdao.findByUUID(visitorID);
		}
		return token == null ? null : token.getUsername();
	}

	@Override
	public void clearToken(String visitorID) {
		tokenMap.remove(visitorID);
		tdao.delToken(visitorID);
	}

}
