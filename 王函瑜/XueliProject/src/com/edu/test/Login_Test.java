package com.edu.test;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;
import com.webtest.dataprovider.NSDataProvider;



public class Login_Test extends BaseTest{
	Login_Action action;
	
	@BeforeClass
	public void setup()
	{
		action=new Login_Action(webtest);
	}

	//在txt驱动下输入正确的用户名和密码登录
	 @Test(enabled=false)//(dataProvider="txt",dataProviderClass=NSDataProvider.class)
	public void loginSuccess(String s1,String s2) throws Exception  {
		webtest.open("http://10.7.10.7/");
		action.login(s1, s2);			
		//判断是否登录成功,不成功则输出不成功的信息
		boolean str=webtest.panduan("xpath=html/body/header/nav/div[2]/ul/li[1]/a");
		Assert.assertTrue(str);
		if(str==true) {
			//移动一下鼠标
			webtest.mouseLong();
			webtest.mouseoverElement("xpath=//a[@class='avatar']");
			//点击二级列表
			webtest.click("link=退出");
		}else {
			System.out.println("未能成功登录");
		}
		
	}
	
	//登录失败用例
	@Test(enabled=false)//
	public void loginfail() throws InterruptedException {
		webtest.open("http://10.7.10.7/");
		action.login("13364191@qq.com","ZHANGyu1");
		//判断是否登录成功,不成功则输出不成功的信息
		boolean str=webtest.panduan("xpath=html/body/header/nav/div[2]/ul/li[1]/a");
		//如果登录成功就退出，登录失败就截图
		Assert.assertTrue(str);
		if(str==true) {
		//移动一下鼠标
		webtest.mouseLong();
		webtest.mouseoverElement("xpath=//a[@class='avatar']");
		//点击二级列表
		webtest.click("link=退出");
		}else {
			System.out.println("未能成功登录");
	    }
				
	}
	
	//使用excel进行数据驱动 
	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class)
	public void loginSuccess2(String s1,String s2) throws InterruptedException {
		webtest.open("http://10.7.10.7/");
		action.login(s1, s2);				
		boolean str=webtest.panduan("xpath=html/body/header/nav/div[2]/ul/li[1]/a");
		Assert.assertTrue(str);
		if(str==true) {
			webtest.mouseLong();
			webtest.mouseoverElement("xpath=//a[@class='avatar']");
			webtest.click("link=退出");
		}else {
			System.out.println("未能成功登录");
		}
	}
}




















