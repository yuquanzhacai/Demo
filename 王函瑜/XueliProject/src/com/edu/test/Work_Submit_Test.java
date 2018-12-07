package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;
import com.edu.models.Work_Change_Action;
import com.edu.models.Work_Check_Action;
import com.edu.models.Work_Submit_Action;



public class Work_Submit_Test extends BaseTest{

	Login_Action action;
	Work_Submit_Action wsaction;
	Work_Change_Action wcsaction;
	Work_Check_Action wcesaction;
	
	
	@BeforeClass
	public void before_Login() throws InterruptedException {
		wsaction=new Work_Submit_Action(webtest);
		wcsaction=new Work_Change_Action(webtest);
		wcesaction=new Work_Check_Action(webtest);
		action=new Login_Action(webtest);
		action.login("2798011643@qq.com","Whymm13145");

	}
//	@BeforeMethod
//	public void before_EveyrTest() {
//		webtest.click("xpath=//i[@class='icon icon-edit']");
//	}
	

	//老师先创建多个任务！！！
	
	@Test(enabled=false)
	public void txt() throws Exception  {
		wsaction.workSubmit("提交作业");
		Assert.assertTrue(webtest.isTextPresent("提交成功"));
	}
	@Test(enabled=false)  //fail
	public void file() throws Exception  {
		wsaction.flieSubmit("E:\\8.jpg");
		Assert.assertTrue(webtest.isTextPresent("请填写内容"));
	}
	@Test(enabled=false)
	public void code() throws Exception  {
		wsaction.codeSubmit("java");
		Assert.assertTrue(webtest.isTextPresent("已完成"));
	}	
	@Test(enabled=false)
	public void file_txt() throws Exception  {
		wsaction.flieSubmit("E:\\8.jpg");
		wsaction.workSubmit("提交作业");
		Assert.assertTrue(webtest.isTextPresent("提交成功"));
	}
	@Test(enabled=false)//(priority=0)//
	public void code_txt() throws Exception  {
		wsaction.codeSubmit("java");
		wsaction.workSubmit("javaxiugai");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("提交成功"));
	}	

	@Test(enabled=false)
	public void code_file() throws Exception  {
		wsaction.codeSubmit("java");
		wsaction.flieSubmit("E:\\8.jpg");
		Assert.assertTrue(webtest.isTextPresent("提交成功"));
	}
	
	@Test//(enabled=false)
	public void code_file_txt() throws Exception  {
		webtest.click("xpath=//a[contains(.,' 未提交')]");
		webtest.click("xpath=//i[@class='icon icon-edit']");
		wsaction.codeSubmit("java");
		wsaction.workSubmit("javaxiugai");
		wsaction.flieSubmit("E:\\8.jpg");
		//Assert.assertTrue(webtest.isTextPresent("已完成"));
		webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	}
	
	
	
	@Test//(enabled=false)//(priority=1)//(enabled=false)
	public void change_Work() throws InterruptedException {
		webtest.click("xpath=//a[@href='/task/list/finished/']");
		webtest.click("xpath=//i[@class='icon icon-file-text']");
		wcsaction.fileEdit("E:\\8.jpg");
		Thread.sleep(2000);
	    wcsaction.workChange("修改作业");
	    Assert.assertTrue(webtest.isTextPresent("已完成"));
	    webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	}
	
	
	@Test
	public void look_work() {
	    wcesaction.workCheck();
	}
	
//	@AfterMethod
//	public void after_EveryTest() {
//    	webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
//    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
//	}
//	
}
