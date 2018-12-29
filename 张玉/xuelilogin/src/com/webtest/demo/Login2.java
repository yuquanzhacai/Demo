package com.webtest.demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.utils.ReadProperties;

public class Login2{
	@Test(dataProvider="txt",dataProviderClass=NSDataProvider.class)
	//²âÊÔÁ½¸öÏàÍ¬ÕËºÅÍ¬Ê±µÇÂ½
	public void login_2(String s1,String s2) throws IOException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "E:\\huohu\\huohu\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://10.7.10.7/");
		Thread.sleep(1000);
		//µÇÂ¼ÕËºÅ
		driver.findElement(By.xpath("//a[contains(.,'µÇÂ¼')]")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(s1);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(s2);
		driver.findElement(By.xpath("//button[contains(.,'µÇÂ¼')]")).click();
	}
}
