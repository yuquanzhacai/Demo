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

import com.edu.models.Login_Action;
import com.edu.models.Own_Message_Action;

public class Own_Message_Test extends BaseTest{

	Own_Message_Action Auaction=null;
	Login_Action la=null;
	@BeforeClass
	public void before_Login() throws InterruptedException {
		Auaction=new Own_Message_Action(webtest);
		la=new Login_Action(webtest);


		la.login("why2798011643@126.com","Whymm13145");

	}
	
	@BeforeMethod
	public void own_Beg() throws InterruptedException {
		webtest.mouseFloat("xpath=//a[@class='avatar']");
		Thread.sleep(2000);
	}
	
	@Test  //查看个人主页
	public void own_Message() throws InterruptedException{
		webtest.click("xpath=//a[contains(.,'个人主页')]");	
		Thread.sleep(2000);		
	    Assert.assertTrue(webtest.isTextPresent("粉丝"));
	
	}
	
	@Test  //修改个人简介
	public void edit_Message() throws InterruptedException {
		webtest.click("xpath=//a[@href='/settings/']");
		Auaction.set_Massage("E:\\8.jpg","2016011713","2016-测试","个人简介");
		Assert.assertTrue(webtest.isTextPresent("个人信息更新成功！"));
	}
	
	@Test  //新密码与确认密码不同
	public void edit_PasswordFailed() throws InterruptedException {
		webtest.click("xpath=//a[@href='/settings/']");	
		Thread.sleep(2000);
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		Auaction.set_Password("Whymm13145","Whymm1314","Whymm131455");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("失败"));
			
	}
	
	@Test  //新旧密码相同
	public void edit_PasswordFailed2() throws InterruptedException {
		webtest.click("xpath=//a[@href='/settings/']");	
		Thread.sleep(2000);
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		Auaction.set_Password("Whymm13145","Whymm13145","Whymm13145");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("失败"));
			
	}
	
	@Test  //旧密码错误
	public void edit_PasswordFailed3() throws InterruptedException {
		webtest.click("xpath=//a[@href='/settings/']");	
		Thread.sleep(2000);
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		Auaction.set_Password("Whymm1314","Whymm131456","Whymm131456");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("失败"));
			
	}
	
	@Test(enabled=false)  //更新密码成功
	public void edit_Password() throws InterruptedException {
		webtest.click("xpath=//a[@href='/settings/']");	
		Thread.sleep(2000);
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		Auaction.set_Password("Whymm1314","Whymm13145","Whymm13145");
		Assert.assertTrue(webtest.isTextPresent("登录"));
	}
	
	@Test //退出
	public void exit() {
		webtest.click("xpath=//a[@href='/logout/']");
		Assert.assertTrue(webtest.isTextPresent("注册雪梨教育"));
	}
}
