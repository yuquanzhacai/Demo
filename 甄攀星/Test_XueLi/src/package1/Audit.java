package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Audit{
	WebDriver driver=new FirefoxDriver();
//	@BeforeClass
//	public void before_Login() throws InterruptedException {
//		//打开页面
//		webtest.open("http://10.7.10.7/login");
//		//文本框输入
//		webtest.type("name=username","2784038315@qq.com");
//		webtest.type("name=password","Zhen0820");
//		webtest.click("xpath://button[@type='submit']");
//	}
//	@Test
//	public void audit() throws InterruptedException {
//	driver.get("http://10.7.10.7/login");
//	driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("2784038315@qq.com");
//	driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Zhen0820");
//	driver.findElement(By.xpath("//button[@id='submit']")).click();
////	Thread.sleep(3000);
////	driver.findElement(By.name("icon icon-bell")).click();
////	JavascriptExecutor js=(JavascriptExecutor)driver;
////	WebElement wb=driver.findElement(By.xpath("//span[@class='notification-box']"));
////	js.executeScript("arguments[0].setAttribute(arguments[1],agruments[2])","wb","style","display:block");
////	js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",wb,"style","display:block");	
//
////	WebElement w=driver.findElement(By.xpath("//span[@class='notification-box']"));
////	action.moveToElement(w).perform();
////	driver.findElement(By.xpath("//a[@href='/u/teams/applications/']"));
//	Actions action =new Actions(driver);
//	WebElement w=driver.findElement(By.xpath("//i[@class='icon icon-bell']"));
//	action.moveToElement(w).perform();
//	driver.findElement(By.xpath("//a[@href='/u/teams/applications/']")).click();
////	driver.findElement(By.xpath("//a[@href='/notifications/comments/']")).click();
//	driver.findElement(By.xpath("//th[@class='check-all check-btn']")).click();
//	driver.findElement(By.xpath("//button[contains(.,'批量通过')]")).click();
//	}
	@Test
	public void throughSelectaudit()
	{
		driver.get("http://10.7.10.7/login");
		driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("2784038315@qq.com");
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Zhen0820");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Actions action =new Actions(driver);
//		WebElement w=driver.findElement(By.xpath("//i[@class='icon icon-bell']"));
//		action.moveToElement(w).perform();
//		driver.findElement(By.xpath("//a[@href='/u/teams/applications/']")).click();
		Actions action1 =new Actions(driver);
		WebElement ws=driver.findElement(By.xpath("//i[@class='icon icon-bell']"));
		action1.moveToElement(ws).perform();
		driver.findElement(By.xpath("//a[@href='/u/teams/applications/']")).click();
		driver.findElement(By.xpath("//input[@id='id_nickname']")).sendKeys("苏东坡");
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		//如果不存在苏东坡该怎么办
		driver.findElement(By.xpath("//th[@class='check-all check-btn']")).click();
		driver.findElement(By.xpath("//button[contains(.,'批量通过')]")).click();
	}
	//	@BeforeMethod
//	public void moveonBell() throws InterruptedException
//	{
//		
//		webtest.mouseoverElement("//span[@class='notification-box']");
//	}
//	driver.findElement(By.xpath("//span[@class='notification-box']"));
//	driver.findElement(By.xpath("//a[@href='/u/teams/applications/']"));
//	driver.findElement(By.xpath("//i[@class='icon-check-empty']"));
//	driver.findElement(By.xpath("//button[contains(.,'批量通过')]"));
}

