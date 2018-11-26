package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.action.Login_Action;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

import com.webtest.core.WebTestListener;

//@Listeners({ WebTestListener.class })
public class Login extends BaseTest{
	public Login_Action action=null;
	
	@BeforeMethod//是说每个测试方法之前要 初始化一次action
	public void setup()
	{
		action=new Login_Action(webtest);
//		System.out.println("实例化action");
	}
	
	@Test(description="测试登录成功界面",dataProvider="txt",dataProviderClass=NSDataProvider.class,priority=0)
	public void loginSuccess(String a,String b) {
//		action=new Login_Action(webtest);
		action.login(a,b);
		webtest.isTextPresent("首页");
//		"913884616@qq.com""654321xiangshang"
	}
	@Test(description="测试登录成功界面",dataProvider="excel",dataProviderClass=NSDataProvider.class)
	public void loginSuccess1(String a,String b)
	{
		action.login(a,b);
	}

	
	@Test
	public void loginFail() {
//		action=new Login_Action(webtest);
		action.login("913884616@qq.com", "654321xiangshang*");
//		webtest.isChecked("");
//		webtest.isDisplayed("");
//		webtest.isElementPresent("");
//		webtest.selectByVisibleText("", "");
	}
	
	
	
//	@Test
//	public void test_login()
//	{
//		webtest.open("http://www.edu2act.net/login/");
////		System.out.println(action);
////		action.login("913884616@qq.com","654321xiangshang");
//
//		webtest.type("name=username","913884616@qq.com");
//		webtest.type("name=password","654321xiangshang");
//		webtest.click("id=submit");
//	}
}
