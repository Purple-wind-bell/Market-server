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
	private static Map<String, Code> codeMap = new HashMap<>();
	private TokenDao tdao = new TokenDaoImpl();

	@Override
	public void updateWebCode(String code, String visitorId) {
		if (codeMap.containsKey(visitorId)) {
			// 更新验证码
			codeMap.replace(visitorId, new Code(visitorId, code, new Timestamp(new Date().getTime())));
			System.out.println("replace:" + code);
		} else {
			// 添加验证码
			codeMap.put(visitorId, new Code(visitorId, code, new Timestamp(new Date().getTime())));
			System.out.println("add:" + code);
		}
		System.out.println("已添加" + codeMap.get(visitorId).getCode());
		System.out.println("codeMap.length:" + codeMap.size());
		System.out.println("update-id:" + visitorId);
	}

	@Override
	public boolean isCodeEffective(String code, String visitorId) {
		Code c = codeMap.get(visitorId);
		System.out.println(code);
		System.out.println(c == null);
		System.out.println("e- codeMap.length:" + codeMap.size());
		System.out.println("query-id:" + visitorId);

		if (c != null && c.getCode().equalsIgnoreCase(code)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void bindUser(String visitorID, String username) {
		Token token = new Token(username, visitorID);
		clearToken(visitorID);
		tdao.save(token);
	}

	@Override
	public String queryBindUsername(String visitorID) {
		Token token = null;
		token = tdao.findByUUID(visitorID);
		return token == null ? null : token.getUsername();
	}

	@Override
	public void clearToken(String visitorID) {
		// tokenMap.remove(visitorID);
		tdao.delToken(visitorID);
	}

}
