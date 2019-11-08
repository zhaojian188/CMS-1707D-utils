/**
 * 
 */
package com.zhaojian;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @作者:ZJ 
 * @时间: 2019年11月7日 
 * 
 * 字符串工具类
 */
public class StringUtils {
	/**
	 * 
	 * @Title: isBlank 
	 * @Description: 判断一个字符串是否为空
	 * @param str
	 * @return
	 * @return: boolean
	 */
	public static boolean isBlank(String str) {
		
		return (str == null || str.trim().equals(""));
		/*if(str == null || str.trim().equals("")){
			return true;
		}
		if("".equals(str)){
			return true;
		}
		return true;*/
		
	}
	/**
	 * 
	 * @Title: isMobile 
	 * @Description: 验证手机号
	 * @param str
	 * @return
	 * @return: boolean
	 */
	public static boolean isMobile(String str) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
	}
	/**
	 * 
	 * @Title: isMobile 
	 * @Description: 验证邮箱
	 * @param str
	 * @return
	 * @return: boolean
	 */
	public static boolean isEmail(String str) {
		String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
	}
	/**
	 * 
	 * @Title: getRandomStr 
	 * @Description: 获取随机的英文字母
	 * @param n
	 * @return
	 * @return: String
	 */
	public static String getRandomStr(int n) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			char c = (char) ('A' + random.nextInt(26));
			sb.append(c);
		}
		return sb.toString();
	}
	/**
	 * 
	 * @Title: getRandomStr2 
	 * @Description: 获取随机的英文字符+数字
	 * @param n
	 * @return
	 * @return: String
	 */
	public static String getRandomStr2(int n) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int r = random.nextInt(36);
			if(r<26) {
				char c = (char)('A'+ r);
				sb.append(c);
			} else {
				sb.append(r-26);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @Title: getRandomCn 
	 * @Description: 获取一个随机中文
	 * @return
	 * @return: char
	 */
	private static char getRandomCn() {
		String str = "";
		
		int hightPos;
		int lowPos;
		Random random = new Random();
		
		hightPos = (176 + Math.abs(random.nextInt(39)));
		lowPos = (161 + Math.abs(random.nextInt(93)));
		
		byte[] b = new byte[2];
		b[0] = (Integer.valueOf(hightPos)).byteValue();
		b[1] = (Integer.valueOf(lowPos)).byteValue();
		
		try {
			str = new String(b , "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("错误");
		}
		
		return str.charAt(0);
	}
	
	/**
	 * 
	 * @Title: getRandomCn 
	 * @Description: 获取多个随机中文
	 * @param n
	 * @return
	 * @return: String
	 */
	public static String getRandomCn(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getRandomCn());
		}
		return sb.toString();
	}
	
	

}
