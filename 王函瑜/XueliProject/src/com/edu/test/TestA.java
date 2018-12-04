package com.edu.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestA {
	
	@BeforeClass
	public void bf() {
		System.setProperty("webdriver.gecko.driver","E:\\Java\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "F:\\Firefox\\firefox.exe");	
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.baidu.com");	
	}
	@Test
	public void t1() {
		Assert.assertEquals(1, 1);
	}
	
	@Test
	public void t2() {
		Assert.assertEquals(2, 2);
	}
	
	@Test
	public void t3() {
		
		Assert.assertEquals(3, 3);
	}
}
