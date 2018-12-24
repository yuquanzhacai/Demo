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

/*
<<<<<<< HEAD:王函瑜/XueliProject/src/com/edu/test/Work_Submit_Test.java
 *欣然的提交任务 
=======
 * author:lixinran
 * modifier:wanghanyu
 * 提交作业
 * 
>>>>>>> 1191a5a979de8933a40535de839db9e33a7af004:王函瑜/XueliProject2/src/com/edu/test/Work_Submit_Test.java
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
		action.login("why2798011643@126.com","Whymm13145");

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
<<<<<<< HEAD:王函瑜/XueliProject/src/com/edu/test/Work_Submit_Test.java
		wsaction.flieSubmit("D:\\demo\\loginuser.txt");
=======
		wsaction.flieSubmit("E:\\8.jpg");
		webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
>>>>>>> 1191a5a979de8933a40535de839db9e33a7af004:王函瑜/XueliProject2/src/com/edu/test/Work_Submit_Test.java
		Assert.assertTrue(webtest.isTextPresent("请填写内容"));
	}
	@Test(description="提交代码") //提交代码
	public void code() throws Exception  {
		wsaction.codeSubmit("java");
		Assert.assertTrue(webtest.isTextPresent("提交"));
	}	
	@Test(description="提交附件+文本") //提交附件+文本
	public void file_txt() throws Exception  {
		wsaction.flieSubmit("D:\\demo\\loginuser.txt");
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
<<<<<<< HEAD:王函瑜/XueliProject/src/com/edu/test/Work_Submit_Test.java
		wsaction.flieSubmit("D:\\demo\\loginuser.txt");
		Assert.assertTrue(webtest.isTextPresent("提交成功"));
=======
		wsaction.flieSubmit("E:\\8.jpg");
		Assert.assertTrue(webtest.isTextPresent("提交"));
>>>>>>> 1191a5a979de8933a40535de839db9e33a7af004:王函瑜/XueliProject2/src/com/edu/test/Work_Submit_Test.java
	}
	
	@Test(description="提交附件文本代码") //提交附件文本代码
	public void code_file_txt() throws Exception  {		
		wsaction.codeSubmit("java");
<<<<<<< HEAD:王函瑜/XueliProject/src/com/edu/test/Work_Submit_Test.java
		wsaction.workSubmit("javaxiugai");
		Thread.sleep(2000);
		wsaction.flieSubmit("D:\\demo\\loginuser.txt");
		//Assert.assertTrue(webtest.isTextPresent("已完成"));
		webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	}
	
	
	
	@Test//(enabled=false)//(priority=1)//(enabled=false)
	public void change_Work() throws InterruptedException {
		webtest.click("xpath=//a[@href='/task/list/finished/']");
		webtest.click("xpath=//i[@class='icon icon-file-text']");
		wcsaction.fileEdit("D:\\demo\\loginuser.txt");
		Thread.sleep(2000);
	    wcsaction.workEdit("修改作业");
	    Assert.assertTrue(webtest.isTextPresent("已完成"));
	    webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
=======
		wsaction.workSubmit("java作业");
		wsaction.flieSubmit("E:\\8.jpg");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("提交"));
		webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
>>>>>>> 1191a5a979de8933a40535de839db9e33a7af004:王函瑜/XueliProject2/src/com/edu/test/Work_Submit_Test.java
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	}
	
	
}
