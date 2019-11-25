/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: FileUtils.java 
 * @Prject: zhaojian-utils
 * @Package: com.zhaojian 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月8日
 * @version: V1.0   
 */
package com.zhaojian;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/** 
 * @ClassName: FileUtils 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月8日 
 * 
 * 解析字符的工具类
 */
public class FileUtils {
	
	public static Logger log = Logger.getLogger(FileUtils.class); 
	/**
	 * 
	 * @Title: getSize 
	 * @Description: 返回文件以指定单位大小表示
	 * @param fileName
	 * @param fileUnit
	 * @return
	 * @return: long
	 */
	public long  getSize(String fileName,FileUnit fileUnit) {
		File file = new File(fileName);
		
		long  size = file.length();
		switch (fileUnit) {
			case B:
				return size;
			case KB:
				return size/1024;
			case MB:
				return size/1024/1024;
			case GB:
				return size/1024/1024/1024;
			case TB:
				return size/1024/1024/1024/1024;
			case PB:
				return size/1024/1024/1024/1024/1024;
			default:
				return 0;
		}
		
	}
	/**
	 * 
	 * @Title: readFile 
	 * @Description: 解析字符串
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @return: List<String>
	 */
	public static List<String> readFile(String fileName) throws IOException {
		//创建一个集合存入解析的字符串
		List<String> lines = new ArrayList<String>();
		//创建文件
		File file = new File(fileName);
		//读取字符串为UTF-8
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		
		String str = null;
		while((str = reader.readLine()) != null) {
			lines.add(str);
		}
		return lines;
	}
	/**
	 * 
	 * @Title: getSuffix 
	 * @Description: 获取文件扩展名
	 * @param fileName
	 * @return
	 * @return: String
	 */
	public static String getSuffix(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		//没有扩展名
		if(dotIndex<0) {
			return "";
		}
		//最后一位是 .
		if(dotIndex>=fileName.length()) {
			return "";
		}
		//
		return fileName.substring(dotIndex+1);
	}
	
public static void delFilePath(String fileName) {
		
		File file = new File(fileName);
		// 文件不存在  则直接返回
		if(!file.exists()) {
			return;
		}
		
		// 如果是文件  则删除后返回
		if(file.isFile()) {
			log.info(" 删除文件 " + fileName);
			file.delete();
			return;
		}
		
		//如果是目录
		if(file.isDirectory()) {
			// 则列出目录下所有的子目录和文件
			 String[] list = file.list();
			 //针对每一项
			 for (String subPath : list) {
				 //调用删除功能
				 delFilePath(fileName + "/" + subPath);
			}
			 log.info(" ------------ 删除文件 夹 ： " + fileName); 
			file.delete(); 
		}
		
		
	}
	

}
