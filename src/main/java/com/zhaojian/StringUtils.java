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
	 * @Title: getSex 
	 * @Description: 随机生成性别"男"或"女"
	 * @return
	 * @return: String
	 */
	public static String getSex(){
        Random r = new Random();
        int i = r.nextInt(2);
        if(i==0){
            return "男";
        }else{
            return "女";
        }

    }
	/**
	 * 
	 * @Title: getName 
	 * @Description: 随机生成一个名字（3个字的名字）
	 * @return
	 * @return: String
	 */
	 public static String getName(){
	        String name = "";
//	        System.out.println(c);
	        for (int i = 0; i <3 ; i++) {
	            char c = (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
	            name+=c;
	        }
	        return name;
	    }
	
	/**
	 * 
	 * @Title: isHttpUrl 
	 * @Description:  验证是否为正确的URL
	 * @param str
	 * @return
	 * @return: boolean
	 */
	public static boolean isHttpUrl(String str){
		
		 //转换为小写
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184               
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "[0-9a-z]*"  // 或单域名
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        return  str.matches(regex);	
	}
	
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
	public static boolean isNumber(String str) {
		String regex = "^\\d$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
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
	 * @Title: getRandomNum 
	 * @Description: 生成一个随机数
	 * @return
	 * @return: int
	 */
	public static int getRandomNum() {

		int random=(int)(Math.random()*10+1);
		return random;
	}
	
	/**
	 * 
	 * @Title: getRandomNum 
	 * @Description: 生成n位随机数字
	 * @param n:代表生成数字的位数
	 * @return
	 * @return: String
	 */
	public static String getRandomNum(int n) {
		
		String str="";
		//循环生成一个数字，再用字符串把他们拼接在一起
		for (int i = 0; i < n; i++) {
			int random=(int)(Math.random()*10);
			str += random;
		}
		
		return str;
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
