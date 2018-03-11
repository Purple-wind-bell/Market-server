package cn.ys.vo;

import java.sql.Timestamp;

/**
 * 验证码类
 * 
 * @author Administrator
 *
 */
public class Code {
	/** 访问者id */
	String id;
	/** 验证码 */
	String vcode;
	/** 验证码生成时间 */
	Timestamp timestamp;

	public Code(String id, String vcode, Timestamp timestamp) {
		super();
		this.id = id;
		this.vcode = vcode;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public String getVcode() {
		return vcode;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	//
}
