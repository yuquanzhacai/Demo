package com.edu.core;

/*
 * author：wanghanyu
 * 对TestNG文件夹进行压缩
 */

public class PicSend {

	private static String file;
    public static String Zip() {
        ZipCompressor zc = new  ZipCompressor("D:\\测试报告.zip");  
        zc.compressExe("E:\\Java\\work\\XueliProject2\\test-output\\html");
        file = "D:\\测试报告.zip";
        return file;
     }
}
