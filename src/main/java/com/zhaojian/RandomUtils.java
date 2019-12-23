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
	 * @Title: getRandomForCMS
	 * @Description: 获取频道id和分类id，二级联动的工具类
	 * @param end
	 * @return
	 * @return: int[]
	 */
	public static int[] getRandomToCMS(int end) {
		Random random = new Random();
		int nextInt = random.nextInt(end);
		int nextInt2 = 1;
		while (nextInt == 0) {
			nextInt = random.nextInt(end);
		}
		switch (nextInt) {
		case 1:
			nextInt2 = random.nextInt(4);
			while (nextInt2 == 0) {
				nextInt2 = random.nextInt(4);
			}
			break;
		case 2:
			nextInt2 = random.nextInt(9);
			while (nextInt2 < 4) {
				nextInt2 = random.nextInt(9);
			}
			break;
		case 3:
			nextInt2 = random.nextInt(13);
			while (nextInt2 < 9) {
				nextInt2 = random.nextInt(13);
			}
			break;
		case 4:
			nextInt2 = random.nextInt(17);
			while (nextInt2 < 13) {
				nextInt2 = random.nextInt(17);
			}
			break;
		case 5:
			nextInt2 = random.nextInt(21);
			while (nextInt2 < 17) {
				nextInt2 = random.nextInt(21);
			}
			break;
		case 6:
			nextInt2 = random.nextInt(25);
			while (nextInt2 < 21) {
				nextInt2 = random.nextInt(25);
			}
			break;
		case 7:
			nextInt2 = random.nextInt(29);
			while (nextInt2 < 25) {
				nextInt2 = random.nextInt(29);
			}
			break;
		case 8:
			nextInt2 = random.nextInt(33);
			while (nextInt2 < 29) {
				nextInt2 = random.nextInt(33);
			}
			break;

		default:
			break;
		}
		int[] arr = new int[] { nextInt, nextInt2 };
		return arr;
	}
	
	
	/**
	 * 
	 * @Title: getRandomNum 
	 * @Description: 生成一个0~9之间的随机数 [1,9)
	 * @param num
	 * @return
	 * @return: int
	 */
	public static int getRandomNum(int num) {
		Random random = new Random();
		int result = random.nextInt(num);
		return result+1;
	}
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
