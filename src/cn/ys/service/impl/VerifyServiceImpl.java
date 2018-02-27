package cn.ys.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import cn.ys.service.VerifyService;

public class VerifyServiceImpl implements VerifyService {
	private static Map<String, Code> codeMap = new HashMap<String, Code>();

	@Override
	public void updateWebCode(String webCode, Timestamp currentTime, String visitor) {
		String visitorID = visitor;
		if (codeMap.containsKey(visitorID)) {
			// 更新验证码
			codeMap.replace(visitorID, new Code(webCode, currentTime));
		} else {
			// 添加验证码
			codeMap.put(visitorID, new Code(webCode, currentTime));
		}

		System.out.println(codeMap.get(visitorID).code);
	}

	@Override
	public boolean isWebCodeEffective(String webCode, Timestamp currentTime, String visitor) {
		Code code = codeMap.get(visitor);
		if (code != null && webCode.equalsIgnoreCase(codeMap.get(visitor).code)) {
			return true;
		} else {
			return false;
		}
	}

	class Code {
		String code;
		Timestamp timestamp;

		protected Code(String code, Timestamp timestamp) {
			super();
			this.code = code;
			this.timestamp = timestamp;
		}

		public String getCode() {
			return code;
		}

		public Timestamp getTimestamp() {
			return timestamp;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public void setTimestamp(Timestamp timestamp) {
			this.timestamp = timestamp;
		}

	}
}
