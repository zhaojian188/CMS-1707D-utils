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

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.zhaojian.DateUtils;
import com.zhaojian.MyException;

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
	/**
	 * 
	 * @Title: testAge 
	 * @Description: 计算年龄
	 * @return: void
	 */
	@Test
	public void testAge() {
		/*Date date = new Date();
		System.out.println();
		assertTrue(0==DateUtils.countAge(date));*/
		
		Date date2 = new Date(95,11,1);
		int age = DateUtils.countAge(date2);
		
		System.out.println("年龄是:"+age);
		
	}
	/**
	 * 
	 * @Title: testFuture 
	 * @Description: 测试未来的某一天距离今天差多少天
	 * @return: void
	 * @throws MyException 
	 */
	@Test
	public void testFuture() throws MyException {
	
		int days = DateUtils.futureDays(new Date(121,11,10));
		System.out.println("未来某一天距离今天相差:" + days);
	}
	/**
	 * 
	 * @Title: testToday 
	 * @Description: 测试当前时间是否为今天
	 * @return: void
	 */
	@Test
	public void testToday() {
		
		/*assertFalse(DateUtils.isToday(new Date(119,11,8)));*/
		System.out.println(DateUtils.isToday(new Date(119,11,8)));
		
	}
	/**
	 * 
	 * @Title: testBOM 
	 * @Description: 测试月初时间
	 * @return: void
	 */
	@Test
	public void testBOM() {
		Date bom = DateUtils.getBOM(new Date());
		System.out.println("当前月份的月初时间:" + bom);
	}
	/**
	 * 
	 * @Title: testEOM 
	 * @Description: 测试月末时间
	 * @return: void
	 */
	@Test
	public void testEOM() {
		Date eom = DateUtils.getEOM(new Date());
		System.out.println("当前月份的月末时间:" + eom);
	}
	
	
	
	
}
