package com.edu.stu_test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.stu_models.Login_Action;
import com.edu.stu_models.Work_Change_Action;
import com.edu.stu_models.Work_Check_Action;
import com.edu.stu_models.Work_Submit_Action;

/*
 * author:lixinran
 * modifier:wanghanyu
 * 提交作业
 * 
 */

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
		action.login("952184149@qq.com","323841Lxr");

	}
	@BeforeMethod
	public void before_EveyrTest() {
		webtest.click("xpath=//i[@class='icon icon-edit']");
	}
	

	//老师先创建多个任务！！！
	
	@Test(description="提交文本") //提交文本
	public void txt() throws Exception  {
		wsaction.workSubmit("提交作业");
		webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
		Assert.assertTrue(webtest.isTextPresent("提交"));
	}
	@Test(description="只提交附件")  //只提交附件
	public void file() throws Exception  {
		wsaction.flieSubmit("E:\\8.jpg");
		webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
		Assert.assertTrue(webtest.isTextPresent("请填写内容"));
	}
	@Test(description="提交代码") //提交代码
	public void code() throws Exception  {
		wsaction.codeSubmit("java");
		Assert.assertTrue(webtest.isTextPresent("提交"));
	}	
	@Test(description="提交附件+文本") //提交附件+文本
	public void file_txt() throws Exception  {
		wsaction.flieSubmit("E:\\8.jpg");
		wsaction.workSubmit("提交作业");
		Assert.assertTrue(webtest.isTextPresent("提交"));
	}
	@Test(description="提交代码+文本") //提交代码+文本
	public void code_txt() throws Exception  {
		wsaction.codeSubmit("java");
		wsaction.workSubmit("java作业");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("提交"));
	}	

	@Test(description="提交代码+附件") //提交代码+附件
	public void code_file() throws Exception  {
		wsaction.codeSubmit("java");
		wsaction.flieSubmit("E:\\8.jpg");
		Assert.assertTrue(webtest.isTextPresent("提交"));
	}
	
	@Test(description="提交附件文本代码") //提交附件文本代码
	public void code_file_txt() throws Exception  {		
		wsaction.workSubmit("java作业");
		wsaction.codeSubmit("java");
		wsaction.flieSubmit("E:\\8.jpg");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("提交"));
		webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
    	Assert.assertTrue(webtest.isTextPresent("提交"));
	}
	
	
}
