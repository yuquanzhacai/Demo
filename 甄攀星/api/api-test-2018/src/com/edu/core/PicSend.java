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
//       ZipCompressor zc = new  ZipCompressor("D:\\"+getTime()+".zip");  
//       zc.compressExe("D:\\demo\\"+getTime());
//       String file= "D:\\"+getTime()+".zip";
//       
//       ZipCompressor z = new  ZipCompressor("D:\\demo\\测试报告.zip");  
//       z.compressExe("D:\\大三上\\Demo\\王函瑜\\XueliProject\\test-output\\html");
//       String file = "D:\\demo\\测试报告.zip";
    	ZipCompressor zc=new ZipCompressor("D:\\demo\\青果接口测试报告.zip");
    	zc.compressExe("D:\\大三上\\PPT\\接口测试\\api-test-2018\\api-test-2018\\test-output\\html");
    	file="D:\\demo\\青果接口测试报告.zip";
    	return file;
    }
}
