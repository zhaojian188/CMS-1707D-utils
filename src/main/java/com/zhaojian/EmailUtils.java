/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: EmailUtils.java 
 * @Prject: zhaojian-utils
 * @Package: com.zhaojian 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年12月7日
 * @version: V1.0   
 */
package com.zhaojian;

import java.util.Random;

/** 
 * @ClassName: EmailUtils 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年12月7日 
 */
public class EmailUtils {
	/**
	 * 
	 * @Title: getMail 
	 * @Description: 随机生成邮箱
	 * @return
	 * @return: String
	 */
	public static String getMail(){
        String [] last = {"@qq.com", "@gmail.com", "@163.com", "@sina.com", "@hotmail.com", "@sohu.com"};
        StringBuffer sb = new StringBuffer();
        // 3~20长度，包含3及20
        int length = 3 + (int) (Math.random() * 9);
        String word = "";
        for (int i = 0; i < length; i++) {
            word += (char) randomChar();
        }
        sb.append(word);
        Random r = new Random();
        final int j = r.nextInt(6);
        sb.append(last[j]);
        return sb.toString();
    }
	/**
	 * 
	 * @Title: randomChar 
	 * @Description: 生成邮箱的前缀 （@前面的字符）
	 * @return
	 * @return: byte
	 */
	private static byte randomChar() {
        // 0<= Math.random()< 1
        int flag = (int) (Math.random() * 2);// 0小写字母1大写字母
        byte resultBt;
        if (flag == 0) {
            byte bt = (byte) (Math.random() * 26);// 0 <= bt < 26
            resultBt = (byte) (65 + bt);
        } else {
            byte bt = (byte) (Math.random() * 26);// 0 <= bt < 26
            resultBt = (byte) (97 + bt);
        }
        return resultBt;
    }
}
