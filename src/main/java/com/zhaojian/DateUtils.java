/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: DateUtils.java 
 * @Prject: zhaojian-utils
 * @Package: com.zhaojian 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月7日
 * @version: V1.0   
 */
package com.zhaojian;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/** 
 * @ClassName: DateUtils 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月7日 
 */
public class DateUtils {
	
	/**
	 * 声明位常量: 一天有多少毫秒
	 */
	static final long millisecond = 1000 * 60 * 60 * 24;
	
	/**
	 * 
	 * @Title: compare 
	 * @Description: TODO
	 * @param date1
	 * @param date2
	 * @return
	 * @return: int
	 */
	public static int compare(Date date1,Date date2) {
		if(date1 == null || date2 == null){
			throw new RuntimeException("参数不能为空");
		}
			
			return date1.compareTo(date2);
		
	}
	
	/**
	 * 
	 * @Title: countAge 
	 * @Description: 根据生日计算年龄
	 * @param birthday
	 * @return
	 * @return: int
	 */
	public static int countAge(Date birthday){
		
		if(birthday.compareTo(new Date()) > 0){
			throw new RuntimeException("给定的生日不能大于当前日期:"+birthday);
		}
		
		//计算生日的年 月  日
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthday);
		
		//获取出生的年份
		int bdYear = calendar.get(Calendar.YEAR);
		//获取出生的月份
		int bdMonth = calendar.get(Calendar.MONTH);
		//获取出生的日份
		int bdDay = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(" bdYear: "+bdYear+ " bdMonth: "+bdMonth+
				" bdDay: "+bdDay);
		
		//计算当前日期的年月日
		calendar.setTime(new Date());
		//获取当前的年份
		int currentYear = calendar.get(Calendar.YEAR);
		//获取当前的月份
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		//获取当前的日份
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(" currentYear: "+currentYear+ " currentMonth: "+currentMonth+
				" currentDay: "+currentDay);
		int age = currentYear - bdYear;
		if(currentMonth < bdMonth) {
			age--;
		}else if(currentMonth == bdMonth && currentDay < bdDay) {
			age--;
		}
		return age;
	}
	/**
	 * 
	 * @Title: futureDays 
	 * @Description: 获取未来的某一天
	 * @param futureDate
	 * @return
	 * @return: int
	 * @throws MyException 
	 */
	public static int futureDays(Date futureDate) throws MyException {
		// 给定的参数是否合法，小于当前日期则认为不合法，抛出异常
		if(futureDate.compareTo(new Date()) < 0) {
			throw new MyException("未来的日期不能小于当前日期:" + futureDate);
		}
		// 计算有多少天
		int days = (int) ((futureDate.getTime() - new Date().getTime()) / millisecond);
		
		return 0;
	}
	/**
	 * 
	 * @Title: isToday 
	 * @Description: 判断当前日期是否为今天
	 * @param date
	 * @return
	 * @return: boolean
	 */
	public  static boolean isToday(Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//获取当前日期的字符串
		String dateStr = sdf.format(date);
		
		//获取系统日期的字符串
		String todayStr = sdf.format(new Date());
		
		//boolean类型默认值为false
		return !(dateStr.equals(todayStr));
	}
	/**
	 * 
	 * @Title: getBOM 
	 * @Description: 初始化到当前月份的1日0时0分0秒0毫秒
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getBOM(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		
		return calendar.getTime();
		
	}
	/**
	 * 
	 * @Title: getEOM 
	 * @Description: 获取当前月份的月末时间
	 * 	先求出下一个月的月初  然后减一秒。就是本月月末的时间
	 * @param date
	 * @return 
	 * @return: Date
	 */
	public static Date getEOM(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, -1);

		return calendar.getTime();
		
	}
	/**
	 * 
	 * @Title: isThisWeek 
	 * @Description: 判断是否为本周
	 * @param date
	 * @return
	 * @return: boolean
	 */
	public static boolean isThisWeek(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

		firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

		firstDayOfWeek.add(Calendar.DATE, -day + 1 + 1);// 后面的+1是因为从周日开始

		// 本周一的日期

		System.out.println(format.format(firstDayOfWeek.getTime()));

		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

		lastDayOfWeek.add(Calendar.DATE, 7 - day + 1);

		// 本周星期天的日期

		System.out.println(format.format(lastDayOfWeek.getTime()));

		return (date.getTime() < lastDayOfWeek.getTime().getTime()
				&& date.getTime() > firstDayOfWeek.getTime().getTime());

	}
	
	
}
