/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: RandomUtils.java 
 * @Prject: zhaojian-utils
 * @Package: com.zhaojian 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月18日
 * @version: V1.0   
 */
package com.zhaojian;

import java.util.Random;

/** 
 * @ClassName: RandomUtils 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月18日 
 */
public class RandomUtils {
	/**
	 * 
	 * @Title: getRandomInt 
	 * @Description: 取0~n位随机数值
	 * @param min 最小值 1
	 * @param max 最大值 3
	 * @return
	 * @return: int
	 */
	public static int getRandomInt(int min,int max) {
		Random random = new Random();
		
		return min + random.nextInt(max-min+1);
	}
	/**
	 * 
	 * @Title: getRandomLong 
	 * @Description: 生成超过10位数的数字 (亿以上的数字)
	 * @param min 
	 * @param max
	 * @return
	 * @return: long
	 */
	public static long getRandomLong(long min,long max) {
		//生成0~1之间double类型的随机数
		double random = Math.random();
		return (long)(random * (max - min) + min);
	}

}
