package com.webtest.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.action.CreateClass_Action;
import com.webtest.action.Login_Action;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Create_Class extends BaseTest{

	public CreateClass_Action action=null;
	
	@BeforeMethod//是说每个测试方法之前要 初始化一次action
	public void setup()
	{
		action=new CreateClass_Action(webtest);
//		System.out.println("实例化action");
	}
	@Test(description="测试创建同步课成功界面")
	public void create_class()
	{
		action.CreateClass("课程二", "课程二", "10");
	}
	
//	public void createClass(String a,String b,String c)
//	{
//		webtest.click("//a[@title='创建同步课']");
//		webtest.type("id=id_name",a);
//		webtest.type("//input[@type='file']", "C:\\Users\\zhen\\Desktop\\timg.jpg");	
//		webtest.click("id=id_check_type_1");
//		webtest.type("class=ke-edit-iframe","b");
//		webtest.click("//input[contains(@id,'1')]");
//		webtest.typeAndClear("id=id_grade_average_percent",c);
//		webtest.click("id=submit");
//	}
//	@Test(description="测试创建同步课成功界面")
//	public void CreateClass()
//	{
//		
//		webtest.open("http://10.7.10.7/login/");
//		webtest.type("name=username","2784038315@qq.com");
//		webtest.type("name=password","Zhen0820");
//		webtest.click("id=submit");
//
//		webtest.open("http://10.7.10.7/u/teams/create/");
////		webtest.click("//i[contains(@class,'icon icon-plus')]");
//		WebDriver driver=new FirefoxDriver();
//		webtest.click("//a[@title='创建同步课']");
////		webtest.click("//i[contains(@class,'icon icon-plus')]");
//		webtest.type("id=id_name","课程一");
////		driver.findElement(By.xpath("//input[@type='file']"));
////		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\zhen\\Desktop\\timg.jpg");
//		webtest.type("//input[@type='file']", "C:\\Users\\zhen\\Desktop\\timg.jpg");	
//		webtest.click("id=id_check_type_1");
//		webtest.type("class=ke-edit-iframe","课程一");
//		webtest.click("//input[contains(@id,'1')]");
//		webtest.typeAndClear("id=id_grade_average_percent", "30");
//		webtest.click("id=submit");
//		
//	}
	
}
