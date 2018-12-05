package com.edu.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class WebTestListener2 extends TestListenerAdapter {
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  System.out.println(tr.getInstanceName()+"-"+tr.getName()+"运行失败，需要截屏");
		  
		  BaseTest tb = (BaseTest) tr.getInstance();
          WebDriver driver = tb.getDriver();    
		  SeleniumScreenShot ss = new SeleniumScreenShot(driver);
		  ss.screenShot();
		  
	  }
}