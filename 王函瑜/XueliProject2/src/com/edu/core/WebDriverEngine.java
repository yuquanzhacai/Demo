package com.edu.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * author:lihuanzhen
 * 页面对象操作类
 */
public class WebDriverEngine {

	WebDriver driver = null;
	ElementFinder finder = null;
	Actions action  =null;

	
	public String[] getAllWindowTitles() {
		// TODO Auto-generated method stub
	    String current = driver.getWindowHandle();

	    List<String> attributes = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	      driver.switchTo().window(handle);
	      attributes.add(driver.getTitle());
	    }

	    driver.switchTo().window(current);

	    return attributes.toArray(new String[attributes.size()]);
	}

	public WebDriverEngine(WebDriver driver) {
	
		this.driver = driver;
		driver.manage().window().maximize();
		finder = new ElementFinder(driver);
		action = new Actions(driver);
	}

	public void enterFrame(String frameID) {
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}
	public void enterFrame(int frameID) {
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}

	public void leaveFrame() {
		driver.switchTo().defaultContent();
		Log.info("Left the iframe");
	}

	public void open(String url) {

		try {
			driver.manage().window().maximize();
			driver.get(url);
			
			pause(3000);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Log.info("Opened url " + url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	private void pause(int time) {
		if (time <= 0) {
			return;
		}
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isTextPresent(String pattern) {

		String text = driver.getPageSource();
//		text = text.trim();
		if (text.contains(pattern)) {
			return true;
		}
		return false;
	}

	public void typeAndClear(String locator, String value) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.clear();
			element.sendKeys(value);

		}
	}

	public void type(String locator, String value) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.sendKeys(value);
		}
	}
//**
	public void type(String locator, Keys value) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.sendKeys(value);
		}
	}
//**
	public void type(String locator,String s,String s2,String value) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  WebElement element=finder.findElement(locator); 
	  js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",element,s,s2);	
	  if (element != null) {
			element.sendKeys(value);
		}
	}	
	public boolean isChecked(String locator) {
		WebElement element = finder.findElement(locator);
		return element.isSelected();
	}

	public void click(String locator) {

		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.click();
			this.pause(3000);
		}
	}

	public void clickLonger(String locator) {

		WebElement element = finder.findElement(locator);
		if (element != null) {
			runJs("window.scrollTo(0," + element.getLocation().x + ")");
			element.click();
			this.pause(3000);
		}
	}

	public void doubleClick(String locator) throws InterruptedException {
		WebElement element = finder.findElement(locator);
		Actions builder = new Actions(driver);
		builder.doubleClick(element).build().perform();
	}

	public boolean isDisplayed(String locator) {

		WebElement element = finder.findElement(locator);
		if (element != null) {
			return true;
		}
		return false;
	}

	public String getText(String locator) {

		return finder.findElement(locator).getText().trim();
	}

	public boolean isElementPresent(String locator) {

		WebElement element = null;
		try {
			element = finder.findElement(locator);
		} catch (Exception e) {

			Log.info(e.getMessage());
		}
		if (element != null) {
			return true;
		}
		{
			return false;
		}
	}

	public String getValue(String locator) {

		return finder.findElement(locator).getAttribute("value");
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void goForward() {

		driver.navigate().forward();
	}

	public Alert getAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	public Select getSelect(String locator) {
		Select inputSelect = new Select(finder.findElement(locator));
		return inputSelect;
	}

	public void selectByValue(String locator, String value) {
		getSelect(locator).selectByValue(value);
		this.pause(5000);
	}

	public void selectByVisibleText(String locator, String value) {
		getSelect(locator).selectByVisibleText(value);
	}

	public void selectByIndex(String locator, int index) {
		getSelect(locator).selectByIndex(index);
	}

	public String getAlertTest() {

		return getAlert().getText();
	}

	public void alertAccept() {

		getAlert().accept();
	}

	public String getHtmlSource() {

		return driver.getPageSource();
	}

	public void runJs(String js) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(js);
	}

	public void runJs(String js,String locator) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(js,finder.findElement(locator));
	}
	
	public void mouseoverElement(String locator) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(finder.findElement(locator)).perform();
		this.pause(3000);
	}
	//切换窗口
	public void switchWidow(int i){
	    List<String> windows = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	    
	    	windows.add(handle);
	    }
	    driver.switchTo().window(windows.get(i));
	}
	//右键
	public void rightClickMouse(String locator) throws InterruptedException {
		action.contextClick(finder.findElement(locator)).perform();
		}
	//Tab键
	public void tapClick(){
	
		action.sendKeys(Keys.TAB).perform();;
	}
//*	//
    public void ENTERClick(){
		
		action.sendKeys(Keys.ENTER).perform();;
	}
	
////*	//鼠标悬浮
	public void mouseFloat(String locator) {
		WebElement element = finder.findElement(locator);
		if(element!=null) {
			  action.moveToElement(element).perform();
		      this.pause(3000);
	    }
	}
		
	public void tapType(String content){
		
			action.sendKeys(content).perform();
		}
	
	public void getWindow(int i){
		List<String> windows = new ArrayList<String>();
		for (String handle : driver.getWindowHandles())
		{
			//System.out.println(handle);  //杩涘叆鍒扮浜屼釜椤甸潰
			windows.add(handle);
		}
		driver.switchTo().window(windows.get(i));
	}

	public boolean ifContains(String content) {
		return driver.getPageSource().contains(content);
	}
	
	public boolean ifContains2(String content) {
		String pHandle=driver.getWindowHandle();
		System.out.println(driver.switchTo().window(pHandle).getPageSource());
		return driver.getPageSource().contains(content);
	}
	
//	public boolean isTextPresent(String pattern) {
//
//		String text = driver.getPageSource();
//		text = text.trim();
//		if (text.contains(pattern)) {
//			return true;
//		}
//		return false;
//	}

	public void mouseLong() throws InterruptedException {

		action.clickAndHold().moveByOffset(20, 20).release().perform();
	}
	
//!	
	//判断是否登录成功
	public boolean panduan(String locator) {

		WebElement element = finder.findElement(locator);

		String str=element.getText();

		if(str.equals("任务"))

			return true;

		else

			return false;

	}
	
	
///!
	public void close() {
		driver.close();
	}
	
	//全部通过审核
	public void through() throws InterruptedException {
		action.moveToElement(driver.findElement(By.className("notification-box"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href, '/u/teams/applications/')]")).click();
		driver.findElement(By.xpath("//i[@class='icon-check-empty']")).click();
		
//		driver.findElement(By.className("check-all check-btn")).click();
//		driver.findElement(By.xpath("/html/body/div[0]/div[0]/div[0]/div[1]/div[1]/div[0]/li[@class='icon-check-empty']"));
		driver.findElement(By.xpath("//button[contains(.,'批量通过')]")).click();
//		driver.findElement(By.xpath("//a[@title='通过']")).click();
	}
	//部分通过审核
	public void throughSelectAudit(String name) throws InterruptedException
	{
		action.moveToElement(driver.findElement(By.className("notification-box"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href, '/u/teams/applications/')]")).click();
//		webtest.type("//input[@id='id_nickname']", "name");
		driver.findElement(By.xpath("//input[@id='id_nickname']")).sendKeys(name);
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		driver.findElement(By.xpath("//i[@class='icon-check-empty']")).click();
		driver.findElement(By.xpath("//button[contains(.,'批量通过')]")).click();
	}
	//点击只查看申请同步课的人
	public void look() throws InterruptedException
	{
		action.moveToElement(driver.findElement(By.className("notification-box"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href, '/u/teams/applications/')]")).click();
	}
	
	//任务描述
	public void taskdescription()
	{
		action.sendKeys(Keys.TAB).perform();		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
	    driver.findElement(By.tagName("body")).sendKeys("任务描述");
		driver.switchTo().defaultContent();		
		action.sendKeys(Keys.TAB).perform();
		driver.findElement(By.tagName("body")).sendKeys("答案解析");
	}
	//批阅作业0分
	public void grade()
	{
		action.sendKeys(Keys.ENTER).perform();
	}	
	
	public void click() {

		action.click();
	}

}
