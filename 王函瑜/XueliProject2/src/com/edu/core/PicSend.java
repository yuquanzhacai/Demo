package com.edu.core;

/*
 * author：wanghanyu
 * 对失败截屏文件夹进行压缩
 */

public class PicSend {
//    public static String getTime()
//    {
//    	java.util.Calendar c=java.util.Calendar.getInstance();    
//        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyyMMdd");    
//       	return  f.format(c.getTime());    
//    }
	private static String file;
    public static String Zip() {
        ZipCompressor zc = new  ZipCompressor("D:\\测试报告.zip");  
        zc.compressExe("E:\\Java\\work\\XueliProject2\\test-output\\html");
        file = "D:\\测试报告.zip";
        return file;
     }
}
