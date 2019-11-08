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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: FileUtils 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月8日 
 * 
 * 解析字符的工具类
 */
public class FileUtils {
	
	public static List<String> readFile(String fileName) throws IOException {
		List<String> lines = new ArrayList<String>();
		
		File file = new File(fileName);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		
		String str = null;
		while((str = reader.readLine()) != null) {
			lines.add(str);
		}
		return lines;
	}
}
