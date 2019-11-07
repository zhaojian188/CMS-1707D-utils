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

import java.util.Date;

/** 
 * @ClassName: DateUtils 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月7日 
 */
public class DateUtils {
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
}
