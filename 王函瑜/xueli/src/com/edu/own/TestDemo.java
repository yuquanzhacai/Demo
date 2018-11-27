package com.edu.own;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestDemo {
	WebDriver driver=null;

	public void set_Massage(String num,String name,String massage) throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement wb=driver.findElement(By.xpath("//input[@id='uploadImageFile']")); 
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",wb,"style","display:block");	
		wb.sendKeys("E:\\8.jpg");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='id_student_number']")).sendKeys(num);
		Thread.sleep(2000);
		WebElement we1=driver.findElement(By.xpath("//input[@id='id_nickname']"));
		we1.click();
		we1.sendKeys(Keys.chord(Keys.CONTROL+"a"));
		Thread.sleep(1000);
		we1.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		we1.sendKeys(name);
		Thread.sleep(2000);
		WebElement we2=driver.findElement(By.xpath("//textarea[@class='form-control']"));
		we2.click();
		we2.sendKeys(Keys.chord(Keys.CONTROL+"a"));
		Thread.sleep(1000);
		we2.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		we2.sendKeys(massage);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();		
	}
	
	public void set_Password(String oldpawd,String newpawd) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='id_old_password']")).sendKeys(oldpawd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='id_new_password1']")).sendKeys(newpawd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='id_new_password2']")).sendKeys(newpawd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='btn']")).click();
	}
	
	@BeforeClass
	public void before_Login() {
		System.setProperty("webdriver.gecko.driver","E:\\Java\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "F:\\Firefox\\firefox.exe");	
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://10.7.10.7/login");		
		driver.findElement(By.name("username")).sendKeys("2798011643@qq.com");
		driver.findElement(By.name("password")).sendKeys("Whymm1314");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	@Test(enabled=false)
	public void own_Massage() throws InterruptedException{
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//img[@src='/static/img/m.png']"));
		action.moveToElement(ele).perform();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//a[contains(.,'个人主页')]")).click();	
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void massage_Change() throws InterruptedException{
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//img[@src='/static/img/m.png']"));
		action.moveToElement(ele).perform();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//a[@href='/settings/']")).click();
		Thread.sleep(2000);
		
		set_Massage("2016011713","8-王函瑜-8-8","12weerhrjtkiy3");
		Thread.sleep(2000);
	}
	
	@Test(enabled=false)
	public void password_Change() throws InterruptedException{
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//img[@src='/static/img/m.png']"));
		action.moveToElement(ele).perform();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//a[@href='/settings/']")).click();
		Thread.sleep(2000);		
		set_Password("Whymm1314","WHymm1314");
		Thread.sleep(2000);
	}
	
	
	@Test(enabled=false)
	public void Exit() throws InterruptedException{
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//img[@src='/static/img/m.png']"));
		action.moveToElement(ele).perform();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//a[@href='/logout/']")).click();
		Thread.sleep(1000);
	}
	
}
