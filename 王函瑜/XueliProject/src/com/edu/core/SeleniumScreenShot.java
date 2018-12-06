package com.edu.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * author:lihaunzhen
 * 截屏类
 */
public class SeleniumScreenShot {
    public WebDriver driver;
 
    public SeleniumScreenShot(WebDriver driver) {
        this.driver = driver;
    }
    public void screenShot(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String nowDateTime=sdf.format(new Date());
		
		File dir = new File("D://demo//"+getTime());
		if (!dir.exists()) {
		        dir.mkdir();
		}
		
		File s_file=((TakesScreenshot)driver).
				getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(s_file, new File(dir+"\\"+nowDateTime+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
    
    public String getTime()
    {
    	java.util.Calendar c=java.util.Calendar.getInstance();    
        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyyMMdd");    
       	return  f.format(c.getTime());    
    }
}