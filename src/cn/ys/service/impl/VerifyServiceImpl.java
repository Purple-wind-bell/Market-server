package cn.ys.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import cn.ys.service.VerifyService;
import cn.ys.vo.Code;

public class VerifyServiceImpl implements VerifyService {
	private static Map<String, Code> codeMap = new HashMap<String, Code>();

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
	public boolean isWebCodeEffective(String code, String visitorId) {
		Code c = codeMap.get(visitorId);
		if (c != null && code.equalsIgnoreCase(codeMap.get(visitorId).getCode())) {
			return true;
		} else {
			return false;
		}
	}

}
