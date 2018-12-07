package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;
import com.edu.models.Work_Change_Action;

public class Work_Change_Test extends BaseTest{
	
	
	Login_Action action;
	Work_Change_Action wsaction;
	
	@BeforeClass
	public void before_Login() throws InterruptedException {
		wsaction=new Work_Change_Action(webtest);
		action=new Login_Action(webtest);
		action.login("2798011643@qq.com","Whymm13145");

	}
	
	@BeforeMethod
	public void before() {
		webtest.click("xpath=//a[@href='/task/list/finished/']");
		webtest.click("xpath=//i[@class='icon icon-file-text']");
	}
	
	@Test(enabled=false)
	public void change_txt() throws InterruptedException {
	    wsaction.workEdit("修改作业");
	    Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	@Test(enabled=false)//(priority=1)//(enabled=false)
	public void change_txtAll() throws InterruptedException {
	    wsaction.workChange("修改作业");
	    Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	@Test(enabled=false)
	public void change_flie() throws InterruptedException {
	    wsaction.fileEdit("E:\\8.jpg");
	    Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	@Test//(enabled=false)
	public void change_code() throws InterruptedException {
		wsaction.codeEdit("javaxiugai123456");
		Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	@Test(enabled=false)
	public void add_code() throws InterruptedException {
		wsaction.codeAdd("javaxiugai");
		Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	@Test(enabled=false)
	public void add_file() throws InterruptedException {
		wsaction.Addfile("E:\\8.jpg");
		Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	@AfterMethod
	public void after() {

		  webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
		  webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	
	}
}
