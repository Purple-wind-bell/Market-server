package cn.ys.vo;

import java.sql.Timestamp;

/**
 * 验证码类
 * 
 * @author Administrator
 *
 */
public class Code {
	String id;// 访问者id
	String code;
	Timestamp timestamp;

	public Code(String id, String code, Timestamp timestamp) {
		super();
		this.id = id;
		this.code = code;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
