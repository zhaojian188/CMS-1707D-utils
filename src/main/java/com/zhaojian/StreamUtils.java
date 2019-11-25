/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: StreamUtils.java 
 * @Prject: zhaojian-utils
 * @Package: com.zhaojian 
 * @Description: TODO
 * @作者: ZJ 
 * @时间: 2019年11月25日
 * @version: V1.0   
 */
package com.zhaojian;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** 
 * @ClassName: StreamUtils 
 * @Description: 文件下载的工具类
 * @作者: ZJ 
 * @时间: 2019年11月25日 
 */
public class StreamUtils {
	/**
	 * 
	 * @Title: closeStream 
	 * @Description: 把一个文件转换为io流传入到另一个文件中
	 * @param closeables
	 * @throws IOException
	 * @return: void
	 */
	public static void closeStream(Closeable ...closeables) throws IOException {
		for (Closeable closeable : closeables) {
			closeable.close();
		}
		
	}
	/**
	 * 
	 * @Title: copyStream 
	 * @Description: 写的io流
	 * @param is
	 * @param os
	 * @throws IOException
	 * @return: void
	 */
	public static void copyStream(InputStream is,OutputStream os) throws IOException {
			
			byte b[] = new byte[1024];
			while(is.read(b)>0) {
				os.write(b);
			}
			//刷新
			os.flush();
			
		}
}
