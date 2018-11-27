package com.edu.own;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Casetestng {
	
	WebDriver driver=null;
	@Test
	public void Open() {
		System.setProperty("webdriver.gecko.driver","E:\\Java\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "F:\\Firefox\\firefox.exe");	
		driver=new FirefoxDriver();
		driver.get("http://www.baidu.com");
	    driver.findElement(By.id("kw")).sendKeys("testerhome");
		
	}
	
//	@Test
//	public void Open2() {
//		System.setProperty("webdriver.gecko.driver","E:\\Java\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.bin", "F:\\Firefox\\firefox.exe");	
//		driver=new FirefoxDriver();
//		driver.get("http://www.baidu.com");
//	    driver.findElement(By.id("kw")).sendKeys("testerhome");
//	    Reporter.log("测试1通过");
//		
//	}
//	
//	@Test
//	public void Open3() {
//		System.setProperty("webdriver.gecko.driver","E:\\Java\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.bin", "F:\\Firefox\\firefox.exe");	
//		driver=new FirefoxDriver();
//		driver.get("http://www.baidu.com");
//	    driver.findElement(By.id("kw")).sendKeys("testerhome");
//	    Reporter.log("测试2通过");
//
//		
//	}
//	
//	@Test
//	public void Open4() {
//		System.setProperty("webdriver.gecko.driver","E:\\Java\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.bin", "F:\\Firefox\\firefox.exe");	
//		driver=new FirefoxDriver();
//		driver.get("http://www.baidu.com");
//	    driver.findElement(By.id("kw")).sendKeys("testerhome");
//	    Reporter.log("测试3通过");		
//	}
//	
	@AfterClass
    public void quit() throws InterruptedException 
    {

        driver.quit();
    }
	
	
}
