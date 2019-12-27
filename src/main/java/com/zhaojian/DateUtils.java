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
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;


/** 
 * @ClassName: DateUtils 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月7日 
 */
public class DateUtils {
	/**
	 * 
	 * @Title: random 
	 * @Description: 生成指定的随机日期 例2019-1-1 ~ 至今
	 * @param begin
	 * @param end
	 * @return
	 * @return: long
	 */
	public  static long randomDays(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return randomDays(begin, end);
        }
        return rtn;
    }
	
	
	/**
	 * 声明位常量: 一天有多少毫秒
	 */
	static final long millisecond = 1000 * 60 * 60 * 24;
	
	/**
	 * 
	 * @Title: getBirthday 
	 * @Description: 随机生成生日
	 * @return
	 * @return: String
	 */
    public static String getBirthday(){
        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1949, 2001);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
    }
    /**
     * 
     * @Title: randBetween 
     * @Description: 生成在start ~ end之间的随机数
     * @param start
     * @param end
     * @return
     * @return: int
     */
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
	
	
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
		
		//计算当前日期的年月 日
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
	 * 3.4.4判断是否为当月
	 * @param date
	 * @return
	 */
	public static boolean isCurrentMonth(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
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
	/**
	 * 
	 * @Title: randomDate 
	 * @Description: 获取随机日期(1980-至今)
	 * @return
	 * @return: String
	 */
	public static String randomDate(){
        Random rndYear=new Random();
        int year=rndYear.nextInt(39)+1980;  //生成[1980,2019]的整数；年
        Random rndMonth=new Random();
        int month=rndMonth.nextInt(12)+1;   //生成[1,12]的整数；月
        //生成[1,30)的整数；如果是2月只给他28天 
        int day = 0;
        if(month == 2){
        	 Random rndDay=new Random(); 
             day=rndDay.nextInt(28)+1; 
        }else{
        	 Random rndDay=new Random(); 
             day=rndDay.nextInt(30)+1;
        }
        
        Random rndHour=new Random();
        int hour=rndHour.nextInt(23);       //生成[0,23)的整数；小时
        Random rndMinute=new Random(); 
        int minute=rndMinute.nextInt(60);   //生成分钟
        Random rndSecond=new Random();
        int second=rndSecond.nextInt(60);   //秒
        return year+"-"+month+"-"+day+"  "+hour+":"+minute+":"+second;

	}
	
	
	
}
