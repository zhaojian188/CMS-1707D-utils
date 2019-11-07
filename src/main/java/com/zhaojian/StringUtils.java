/**
 * 
 */
package com.zhaojian;

/** 
 * @作者:ZJ 
 * @时间: 2019年11月7日 
 * 
 * 字符串工具类
 */
public class StringUtils {
	/**
	 * 判断一个字符串是否为空
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

}
