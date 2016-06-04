package com.bar3.util;


import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;

public class LogInitTest {
    private static Logger log;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	    log=LogInit.getlog(LogInitTest.class);
	}

	@Test
	public void test() {
		log.info("我是大傻逼");
	}

}
