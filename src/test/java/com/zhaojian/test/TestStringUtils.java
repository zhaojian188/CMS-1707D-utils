/**
 * 
 */
/*package com.zhaojian.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zhaojian.StringUtils;

*//** 
 * @作者:ZJ 
 * @时间: 2019年11月7日 
 * 
 * 测试字符串是否为空
 *//*
public class TestStringUtils {
	*//**
	 * 
	 * @Title: 测试空字符串 
	 * @Description: TODO
	 * @return: void
	 *//*
	@Test
	public void testIsBlank() {
		//assert==>断言测试
		//断言假
		assertFalse(StringUtils.isBlank("aaa"));
		
		//断言真
		assertTrue(StringUtils.isBlank(" "));
	}
	*//**
	 * 
	 * @Title: 测试随机英文字符 
	 * @Description: TODO
	 * @return: void
	 *//*
	@Test
	public void testRandom() {
		String s = StringUtils.getRandomStr(10);
		System.out.println("随机英文字符是:"+s);
	}
	*//**
	 * 
	 * @Title: testRandomStr 
	 * @Description: 测试随机英文+数字
	 * @return: void
	 *//*
	@Test
	public void testRandomStr() {
		String s = StringUtils.getRandomStr2(25);
		System.out.println("随机英文+数字 是:"+s + " 长度是:"+s.length());
	}
	*//**
	 * 
	 * @Title: testRandomCn 
	 * @Description: 测试随机中文
	 * @return: void
	 *//*
	@Test
	public void testRandomCn() {
		String s = StringUtils.getRandomCn(10);
		System.out.println("随机中文 是:"+s + " 长度是:"+s.length());
	}
	
	
}*/
