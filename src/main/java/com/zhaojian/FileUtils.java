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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;


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
	 * @Title: writeFile
	 * @Description: 按照指定的编码把内容写入指定的文件中
	 * @param path
	 * @param content
	 * @param charset
	 * @throws IOException
	 * @return: void
	 */
	public static void writeFile(String path, String content, String charset) throws Exception {
		// 创建写入的文件
		File file = new File(path);
		// 判断父目录是否存在
		if (!file.getParentFile().exists()) {
			// 创建父目录
			file.getParentFile().mkdirs();
		}
		// 创建输出流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bw.write(content);
		bw.flush();
		bw.close();
	}

	/**
	 * @Title: readFile
	 * @Description: 读取文件内容
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static List<String> readFile(String fileName, String charset) throws Exception {
		//创建一个集合存入解析的字符串
		List<String> list = new ArrayList<String>();
		//创建文件
		File file = new File(fileName);
		// 创建输出流对象
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		// 定义读取每行的结果
		String content = null;
		// 循环读取
		while ((content = br.readLine()) != null) {
			// 把读取的字符串加入到list集合
			list.add(content);
		}
		// 关闭流
		br.close();
		// 返回结果为list集合
		return list;

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
	public static String readFileString(File file, String charset) throws IOException {
		
		//读取字符串为UTF-8
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		// 定义缓冲对象
		StringBuffer sb = new StringBuffer();
		// 定义读取每行的结果
		String str = null;
		while((str = reader.readLine()) != null) {
			// 加入缓冲对象
			sb.append(str);
		}
		return sb.toString();
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
	
	/**
	 * 
	 * @Title: processFile 
	 * @Description: 保存文件的相对路径
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @return: String
	 */
	public static String processFile(MultipartFile file,String uploadPath) throws IllegalStateException, IOException {
		//获取图片的扩展名:  "xxx.jpg"(最后一个jpg)
		String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		//获取图片文件名字
		String prefixName = UUID.randomUUID().toString();
		//获取新的文件的名称
		String fileName = prefixName + suffixName;
		
		//创建日期格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		//获取当前的日期
		Date date = new Date();
		//生成以日期为格式的路径
		String path = dateFormat.format(date);
		File pathFile = new File(uploadPath + "/" +path);
		//如果没有此文件夹，则创建一个文件夹
		if(!pathFile.exists()) {
			pathFile.mkdirs();
		}
		
		//最终的新的文件名称
		String newFileName = uploadPath+"/"+path+"/"+fileName;
		//生成最终的文件
		file.transferTo(new File(newFileName));
		//返回上传图片的文件名
		return path + "/" + fileName;
	}
	
}
