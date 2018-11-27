package com.edu.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {

	WebDriver driver=null;
	@BeforeClass
	public void initBrowser(){
		System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
	
	

	
	@Test(dataProvider="txt",dataProviderClass=TxtDataProvider.class)
	public void frontendLogin(String u_name,String u_pwd) throws InterruptedException {
		
		driver.get("http://localhost:8032/mymovie/");
		if(driver.getPageSource().contains("退出")) {
			driver.findElement(By.linkText("退出")).click();
			Thread.sleep(3000);
		}
		driver.findElement(By.linkText("登录")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(u_name);
		driver.findElement(By.name("password")).sendKeys(u_pwd);
//		driver.findElement(By.xpath("//input[@type='submit'][2]")).click();
		driver.findElement(By.xpath("//input[@value='马上登录']")).click();
		Thread.sleep(6000);
		Assert.assertTrue(driver.getPageSource().contains(u_name));
		
		
		
	}
	
}
