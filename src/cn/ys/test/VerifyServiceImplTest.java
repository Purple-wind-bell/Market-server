package cn.ys.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.Test;

import cn.ys.service.impl.VerifyServiceImpl;

class VerifyServiceImplTest {

	@Test
	void testUpdateWebCode() {
		new VerifyServiceImpl().updateWebCode("111", new Timestamp(new Date().getTime()), "111");
	}

	@Test
	void testIsWebCodeEffective() {
		boolean s = new VerifyServiceImpl().isWebCodeEffective("111", new Timestamp(new Date().getTime()), "111");
		System.out.println(s);
	}

}
