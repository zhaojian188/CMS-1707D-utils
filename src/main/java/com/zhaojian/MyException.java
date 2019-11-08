/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: MyException.java 
 * @Prject: zhaojian-utils
 * @Package: com.zhaojian 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月8日
 * @version: V1.0   
 */
package com.zhaojian;

/** 
 * @ClassName: MyException 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月8日 
 */
public class MyException extends Exception{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 获取序列化的版本号
	 */
	private static final long serialVersionUID = -7089928091012028974L;

	public MyException(String str) {
		super(str);
	}
}
