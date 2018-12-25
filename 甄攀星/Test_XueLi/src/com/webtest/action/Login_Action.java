package com.webtest.action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;


public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }

	  
	  public void login(String email,String password) 
	  {		
//		  	http://10.7.10.7/login/
			webtest.open("http://10.7.10.7/login/");
			webtest.type("name=username",email);
			webtest.type("name=password",password);
			webtest.click("id=submit");

		
	  }
		public void CreateClass(String a,String b,String c)
		{
			
		    webtest.open("http://10.7.10.7/u/teams/");
			webtest.click("class=create-button");
			webtest.type("id=id_name",a);
			webtest.tapClick();
			webtest.type("name=icon","C:\\Users\\zhen\\Desktop\\timg.jpg");
			webtest.click("id=id_check_type_1");
			webtest.type("class=ke-edit-iframe",b);
			webtest.click("//input[contains(@id,'1')]");
			webtest.typeAndClear("id=id_grade_average_percent",c);
			webtest.click("id=submit");
			while(webtest.ifContains("当前同步课已经存在，请更换名称")) {
			if (webtest.ifContains("当前同步课已经存在，请更换名称")) {
					a=a+"*";
					webtest.typeAndClear("id=id_name",a);
					webtest.click("id=submit");
			}
			else {
					webtest.open("http://10.7.10.7/u/teams/");
				}
			}
		}
		public void throughAllAudit() throws InterruptedException
		{
//			driver.findElement(By.xpath("//span[@class='notification-box']"));
//			boolean str=webtest.panduan("//span[@class='notification-box']");
//			webtest.mouseLong();
//			webtest.mouseFloat("//i[@class='icon icon-bell']");
				webtest.open("http://10.7.10.7/u/teams/");
				Thread.sleep(3000);
//				webtest.runJs("xpath=//span[@class='notification-box']");
				webtest.click("//i[@class='icon icon-bell']");
				webtest.click("//a[@href='/u/teams/applications/']");
				webtest.click("//th[@class='check-all check-btn']");
				webtest.click("//button[contains(.,'批量通过')]");
		}
		public void throughSelectAudit(String name) throws InterruptedException {
			webtest.open("http://10.7.10.7/u/teams/");
//			webtest.click();
			Thread.sleep(5000);
//			webtest.mouseoverElement("//i[@class='icon icon-bell']");
//			webtest.runJs("arguments[0].click();","link=收到的赞");
//			driver.findElement(By.xpath("//span[@class='notification-box']"));
//			webtest.runJs("arguments[0].click();","xpath=//span[@class='notification-box']");
//			webtest.runJs("arguments[0].click();", "xpath=//i[@class='icon icon-bell']");
			webtest.runJs("arguments[0].click();","link=同步课申请");
//			webtest.click("//span[@class='notification-box']");
//			webtest.click("//a[@href='/u/teams/applications/']");
//			System.out.println("执行了点击申请");
//			webtest.type("//input[@id='id_nickname']", name);
//			System.out.println("执行了点击申请");
//			webtest.click("//button[@class='search-button']");
//			System.out.println("执行了点击申请");
//			webtest.click("//th[@class='check-all check-btn']");
//			System.out.println("执行了点击申请");
//			webtest.click("//button[contains(.,'批量通过')]");
//			System.out.println("执行了点击申请");
		}
		public void checkandclassAction()
		  {
			  	webtest.runJs("arguments[0].click();","link=收到的赞");
				webtest.click("xpath=//a[@data-toggle='dropdown']");
				webtest.click("xpath=//a[@data-toggle='dropdown']");
				webtest.click("xpath=//a[contains(.,'收到的评论')]");
				webtest.click("xpath=//a[@data-toggle='dropdown']");
				webtest.click("xpath=//a[contains(.,'发出的评论')]");
				webtest.click("xpath=//a[contains(.,'首页')]");
				webtest.click("xpath=//a[@class='cursor-pointer']");
				webtest.click("xpath=//a[@href='/u/courses/']");
				webtest.click("xpath=//a[@href='/u/courses/attention/']");
				webtest.click("xpath=//a[@href='/u/courses/interest/']");
				webtest.click("xpath=//a[contains(@href,'/course/')]");
				webtest.runJs("arguments[0].click();","link=课程分类");
				webtest.click("xpath=//a[@href='/course/category/5']");
				webtest.runJs("arguments[0].click();","link=课程体系");
				webtest.click("xpath=//a[contains(.,'软件测试工程师')]");
				webtest.click("xpath=//button[@data-interested='10']");
				webtest.click("xpath=//a[@class='cursor-pointer']");
				webtest.click("xpath=//a[@class='cursor-pointer']");
		  }
}


