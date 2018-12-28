package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;
import com.edu.models.Work_Change_Action;

/*
 * author:lixinran
 * modifier:wanghanyu
 * 修改作业
 * 
 */

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
	
	@Test(description="修改文本")
	public void change_txt() throws InterruptedException {
	    wsaction.workEdit("修改作业");
	    webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
		webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
		Thread.sleep(2000);
	    Assert.assertTrue(webtest.isTextPresent("提交"));
	}
	
	@Test(description="重写文本")
	public void change_txtAll() throws InterruptedException {
	    wsaction.workChange("清空作业，重新修改作业");
	    webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	    Assert.assertTrue(webtest.isTextPresent("提交"));
	}
	
	@Test(description="修改文件")
	public void change_flie() throws InterruptedException {
	    wsaction.fileEdit("E:\\8.jpg");
	    webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	    Assert.assertTrue(webtest.isTextPresent("提交"));
	}
	
	@Test(description="修改代码")
	public void change_code() throws InterruptedException {
		wsaction.codeEdit("javaxiugai123456");
		webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
		Assert.assertTrue(webtest.isTextPresent("提交"));
	}
	
	@Test(description="增加代码")
	public void add_code() throws InterruptedException {
		wsaction.codeAdd("javaxiugai");
		webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
		Assert.assertTrue(webtest.isTextPresent("提交"));
	}
	//增加文件
	@Test(description="作业修改")
	public void change_work() throws InterruptedException {
		wsaction.fileEdit("E:\\8.jpg");
		 wsaction.workChange("清空作业，重新修改作业");
		wsaction.codeAdd("javaxiugai");
		webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
		
	}
	
}
