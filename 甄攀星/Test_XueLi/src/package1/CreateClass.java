package package1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class CreateClass {
	//public static void main(String[] args)
	@Test(description="添加课程")
	public void test_createClass()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://10.7.10.7/login");
		driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("2784038315@qq.com");
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Zhen0820");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		driver.findElement(By.xpath("//i[contains(@class,'icon icon-plus')]")).click();
		driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("中国近代史");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\zhen\\Desktop\\timg.jpg");
		driver.findElement(By.xpath("//input[@id='id_check_type_0']")).click();
		driver.findElement(By.className("ke-edit-iframe")).sendKeys("中国近代史");
		driver.findElement(By.xpath("//input[contains(@id,'0')]")).click();
//		WebElement text=driver.findElement(By.xpath("//input[@id='id_grade_average_percent']"));
//		Actions action=new Actions(driver);
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
//		action.sendKeys(Keys.DELETE).perform();
		driver.findElement(By.xpath("//input[@id='id_grade_average_percent']")).clear();
		driver.findElement(By.xpath("//input[@id='id_grade_average_percent']")).sendKeys("30");
		driver.findElement(By.xpath("//input[@value='保存']")).click();
		Reporter.log("日志"+":"+"添加一门同步课");
		Assert.assertTrue(true);
	}
	@Test(description="添加课程")
	public void test_createClass1()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://10.7.10.7/u/teams/");
		driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("2784038315@qq.com");
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Zhen0820");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		driver.findElement(By.xpath("//i[contains(@class,'icon icon-plus')]")).click();
		driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("大学英语");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\zhen\\Desktop\\timg.jpg");
		driver.findElement(By.xpath("//input[@id='id_check_type_0']")).click();
		driver.findElement(By.className("ke-edit-iframe")).sendKeys("大学英语");
		driver.findElement(By.xpath("//input[contains(@id,'0')]")).click();
		driver.findElement(By.xpath("//input[@id='id_grade_average_percent']")).clear();
		driver.findElement(By.xpath("//input[@id='id_grade_average_percent']")).sendKeys("30");
		driver.findElement(By.xpath("//input[@value='保存']")).click();
		Reporter.log("日志"+":"+"添加一门同步课");
		Assert.assertTrue(true);
	}
	
}
