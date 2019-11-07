/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: TestDate.java 
 * @Prject: zhaojian-utils
 * @Package: com.zhaojian.test 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月7日
 * @version: V1.0   
 */
package com.zhaojian.test;

import java.util.Date;

import org.junit.Test;

import com.zhaojian.DateUtils;

/** 
 * @ClassName: TestDate 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月7日 
 */
public class TestDate {
	/**
	 * 
	 * @Title: testDate 
	 * @Description: 测试时间是否正确
	 * @return: void
	 */
	@Test
	public void testDate() {
		DateUtils.compare(null, new Date());
	}
}
