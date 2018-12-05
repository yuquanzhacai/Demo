package com.edu.core;

/*
 * author：wanghanyu
 * 对失败截屏文件夹进行压缩
 */

public class PicSend {
    public static String getTime()
    {
    	java.util.Calendar c=java.util.Calendar.getInstance();    
        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyyMMdd");    
       	return  f.format(c.getTime());    
    }
    public static String Zip() {
       ZipCompressor zc = new  ZipCompressor("D:\\"+getTime()+".zip");  
       zc.compressExe("D:\\demo\\"+getTime());
       String file = "D:\\"+getTime()+".zip";
       return file;
    }
}
