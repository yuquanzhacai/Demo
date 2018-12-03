package com.edu.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.WebTestListener;
import com.edu.core.WebTestListener2;
import com.edu.core.BaseTest;
import com.edu.models.Auto_test_action;
import com.edu.models.Login_Action;


@Listeners({WebTestListener2.class,WebTestListener.class})
public class Auto_test extends BaseTest{

	Auto_test_action Auaction=null;
	Login_Action la=null;
	@BeforeClass
	public void before_Login() throws InterruptedException {
		Auaction=new Auto_test_action(webtest);
		la=new Login_Action(webtest);
		//打开页面
		webtest.open("http://10.7.10.7/login");

		la.login("2798011643@qq.com","Whymm13145");

	}
	
	@BeforeMethod
	public void own_Beg() throws InterruptedException {
		webtest.mouseFloat("xpath=//img[@src='/static/img/m.png']");
	}
	
	@Test(priority=0)
	public void own_Message() throws InterruptedException{
		webtest.click("xpath=//a[contains(.,'个人主页')]");	
		Assert.assertTrue(webtest.isTextPresent("粉丝"));
	
	}
	
	@Test(priority=1)
	public void edit_Message() throws InterruptedException {
		webtest.click("xpath=//a[@href='/settings/']");
		Auaction.set_Massage("E:\\8.jpg","2016011713","8-王函瑜-8-8","12weerhrjtkiy3");
		Assert.assertTrue(webtest.isTextPresent("个人信息更新成功！"));
	}
	
	@Test(enabled=false)//(priority=2)
	public void edit_Password() throws InterruptedException {
		webtest.click("xpath=//a[@href='/settings/']");	
		Thread.sleep(2000);
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		Auaction.set_Password("Whymm1314","Whymm13145","Whymm13145");
		Assert.assertTrue(webtest.isTextPresent("登录 "));
	}
	
	@Test(enabled=false)//(priority=3)
	public void edit_PasswordFailed() throws InterruptedException {
		webtest.click("xpath=//a[@href='/settings/']");	
		Thread.sleep(2000);
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		Auaction.set_Password("Whymm1314","Whymm13145","Whymm1314");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("登录 "));
		
		
	}
	
	@Test(priority=4)
	public void exit() {
		webtest.click("xpath=//a[@href='/logout/']");
		Assert.assertTrue(webtest.isTextPresent("注册雪梨教育"));
	}
}
