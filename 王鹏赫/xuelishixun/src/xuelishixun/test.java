package xuelishixun;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class test {
	public static void main(String[] args)throws IOException{
		System.setProperty("webdriver.gecko.driver","E:\\firefox\\geckodriver.exe" );
		System.setProperty("webdriver.firefox.bin", "E:\\firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://10.7.10.7");
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.name("username")).sendKeys("2240024073@qq.com");
		driver.findElement(By.name("password")).sendKeys("980603");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.linkText("通知")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/course/')]")).click();
		driver.findElement(By.xpath("//h5[contains(.,'Github 开源之旅视频课程第一季：启程')]")).click();
		driver.findElement(By.xpath("//a[@class='cursor-pointer']")).click();
	}
}
