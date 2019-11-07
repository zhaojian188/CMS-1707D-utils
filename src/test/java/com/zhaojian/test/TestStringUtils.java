/**
 * 
 */
package com.zhaojian.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zhaojian.StringUtils;

/** 
 * @作者:ZJ 
 * @时间: 2019年11月7日 
 * 
 * 测试字符串是否为空
 */
public class TestStringUtils {
	
	@Test
	public void testIsBlank() {
		//assert==>断言测试
		//断言假
		assertFalse(StringUtils.isBlank("aaa"));
		//断言真
		assertTrue(StringUtils.isBlank(" "));
	}
}
