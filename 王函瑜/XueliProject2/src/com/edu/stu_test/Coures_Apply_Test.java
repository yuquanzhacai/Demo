package com.edu.stu_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.stu_models.Login_Action;
 
/*
 * author:wangjuan
 * 同步课
 * 关注他人
 */



public class Coures_Apply_Test extends BaseTest{

	private Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
		action.login("why2798011643@126.com","Whymm13145");
	}

	@Test(description="申请同步课")
	public void course()throws InterruptedException{
		
		//点击同步课
		webtest.click("xpath=//a[@href='/team/']");
		Thread.sleep(2000);
		//申请加入同步课
		webtest.click("xpath=//button[@data-team='tong-bu']");
		webtest.type("xpath=//input[@maxlength='20']","测试");
		webtest.click("xpath=//button[contains(.,'申请加入')]");	
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("审核中"));
	}
	
	@Test(description="申请同步课，关注成员")
	public void course2()throws InterruptedException{
		
		//点击同步课
		webtest.click("xpath=//a[@href='/team/']");
		Thread.sleep(2000);
		//进入具体同步课申请加入
		webtest.click("xpath=//h1[contains(.,'同步**')]");
		webtest.click("xpath=//button[contains(.,'申请加入')]");
		webtest.type("xpath=//input[@maxlength='20']","测试");
		webtest.click("xpath=//button[@class='btn btn-primary apply-now']");
		Assert.assertTrue(webtest.isTextPresent("申请中"));
		//关注同步课成员
		webtest.click("xpath=//span[contains(.,' 成员')]");
		webtest.click("xpath=//h5[@title='老师']");
		webtest.click("xpath=//button[@id='id_fans']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("关注"));
	}
	
		
	@Test(description="查看已加入的同步课")
	public void ownCourse() throws InterruptedException {
		//查看已加入的同步课
		webtest.click("xpath=//a[contains(.,'首页')]");
		webtest.click("xpath=//a[@href='/u/teams/']");
		webtest.click("xpath=//h1[contains(.,'wegr')]");
		Assert.assertTrue(webtest.isTextPresent("任务"));
		//插入话题
		webtest.click("xpath=//span[contains(.,' 互动')]");
		Thread.sleep(2000);		
		webtest.click("xpath=//a[@title='插入#话题#']");
		webtest.click("class=ke-edit-iframe");
    	webtest.type("tag=body", "互动测试");
		webtest.click("xpath=//button[contains(.,'发布')]");
	}
}

	
	
	

