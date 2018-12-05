package com.webtest.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;

public class CreateClass_Action {
	private WebDriverEngine webtest;
	public CreateClass_Action(WebDriverEngine webtest)
	{
		this.webtest=webtest;
	}
	  
	  public void login(String email,String password) 
	  {		
			webtest.open("http://10.7.10.7/login/");
			webtest.type("name=username",email);
			webtest.type("name=password",password);
			webtest.click("id=submit");

		
	  }
	public void CreateClass(String a,String b,String c) throws InterruptedException
	{
		webtest.open("http://10.7.10.7/login/");
		webtest.type("name=username","2784038315@qq.com");
		webtest.type("name=password","Zhen0820");
//		webtest.open("http://10.7.10.7/u/teams/");
//		webtest.type("name=username","2784038315@qq.com");
//		webtest.type("name=password","Zhen0820");
		//点击右边的创建同步课
		webtest.click("class=create-button");
		webtest.type("id=id_name",a);
		webtest.tapClick();
		//上传同步课图标
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
}

