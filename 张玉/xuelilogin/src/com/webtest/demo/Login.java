package com.webtest.demo;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.NSDataProvider;


//截屏监听器：经测试可运行
@Listeners({ WebTestListener.class })
public class Login extends BaseTest{
	Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}

	 @Test(dataProvider="txt",dataProviderClass=NSDataProvider.class)
	//在txt驱动下输入正确的用户名和密码登录
	public void loginSuccess(String s1,String s2) throws Exception  {
		webtest.open("http://10.7.10.7/");
		action.login(s1, s2);
				
		//判断是否登录成功,不成功则输出不成功的信息
		boolean str=webtest.panduan("xpath=html/body/header/nav/div[2]/ul/li[1]/a");
		if(str==true) {
			//移动一下鼠
			webtest.mouseLong();
			webtest.mouseoverElement("xpath=//a[@class='avatar']");
			//点击二级列表
			webtest.click("link=退出");
		}else {
			System.out.println("未能成功登录");
		}
		
	}

	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class)
	//使用excel进行数据驱动 
	public void loginfail2(String s1,String s2) throws InterruptedException {
		webtest.open("http://10.7.10.7/");
		action.login(s1, s2);
				
		boolean str=webtest.panduan("xpath=html/body/header/nav/div[2]/ul/li[1]/a");
		if(str==true) {
			webtest.mouseLong();
			webtest.mouseoverElement("xpath=//a[@class='avatar']");
			webtest.click("link=退出");
		}else {
			System.out.println("未能成功登录");
		}
	}
	
	@Test
	//登录失败用例
	public void loginfail() throws InterruptedException {
		webtest.open("http://10.7.10.7/");
		webtest.click("link=登录");
		webtest.type("xpath=.//*[@id='id_username']", "13364191@qq.com");
		webtest.type("id=id_password","ZHANGyu123");
		webtest.click("id=submit");
		
		//判断是否登录成功,不成功则输出不成功的信息
			    boolean str=webtest.panduan("xpath=html/body/header/nav/div[2]/ul/li[1]/a");
				//如果登录成功就退出，登录失败就截图
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
	
	
}




















