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
import org.testng.Reporter;
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
    	System.setProperty("org.uncommons.reportng.escape-output", "false");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String nowDateTime=sdf.format(new Date());
		File dir = new File("D://demo//"+getTime());
		if (!dir.exists()) {
		        dir.mkdir();
		}
		
		File s_file=((TakesScreenshot)driver).
				getScreenshotAs(OutputType.FILE);
		try {
//			FileUtils.copyFile(s_file, new File(dir+"\\"+nowDateTime+".jpg"));
			FileUtils.copyFile(s_file, new File(dir+"\\"+nowDateTime+".jpg"));
			String picName=dir+"\\"+nowDateTime;
			String escapePicName=escapeString(picName);
			Reporter.log("<img src='file:///"+picName+".png' onclick='window.open(\"file:///"+escapePicName+".png\")'  height='100px' width='100px' />",true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
    /**

     * 替换字符串

     * @param 待替换string

     * @return 替换之后的string

     */
    public String escapeString(String s)
    {
        if (s == null)
        {
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
        	buffer.append(escapeChar(s.charAt(i)));
        }
        return buffer.toString();
    }

    /**

     * 将\字符替换为\\

     * @param 待替换char

     * @return 替换之后的char

     */

    private String escapeChar(char character)
    {
        switch (character)
        {
            case '\\': return "\\\\";

            default: return String.valueOf(character);
        }
    }
	public String getTime()
    {
    	java.util.Calendar c=java.util.Calendar.getInstance();    
        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyyMMdd");    
       	return  f.format(c.getTime());    
    }
}