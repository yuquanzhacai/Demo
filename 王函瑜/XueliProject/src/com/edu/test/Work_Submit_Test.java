package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;
import com.edu.models.Work_Submit_Action;



public class Work_Submit_Test extends BaseTest{

	Login_Action action;
	Work_Submit_Action wsaction;
	
	@BeforeClass
	public void before_Login() throws InterruptedException {
		wsaction=new Work_Submit_Action(webtest);
		action=new Login_Action(webtest);
		action.login("2798011643@qq.com","Whymm13145");

	}
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
		Assert.assertTrue(webtest.isTextPresent("提交成功"));
	}	
	@Test(enabled=false)
	public void file_txt() throws Exception  {
		wsaction.flieSubmit("E:\\8.jpg");
		wsaction.workSubmit("提交作业");
		Assert.assertTrue(webtest.isTextPresent("提交成功"));
	}
	@Test(enabled=false)
	public void code_txt() throws Exception  {
		wsaction.codeSubmit("java");
		wsaction.workSubmit("�ύ��ҵ");
		Assert.assertTrue(webtest.isTextPresent("�ύ�ɹ�"));
	}	

	@Test(enabled=false)
	public void code_file() throws Exception  {
		wsaction.codeSubmit("java");
		wsaction.flieSubmit("E:\\8.jpg");
		Assert.assertTrue(webtest.isTextPresent("提交成功"));
	}
	
	@Test//(enabled=false)
	public void change_txt() throws InterruptedException {
	    wsaction.workEdit("修改作业");
	    Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	@Test(enabled=false)
	public void change_txtAll() throws InterruptedException {
	    wsaction.workChange("修改作业");
	    Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	@Test(enabled=false)
	public void change_flie() throws InterruptedException {
	    wsaction.fileEdit("E:\\8.jpg");
	    Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	@Test(enabled=false)
	public void change_code() throws InterruptedException {
		wsaction.codeEdit("javaxiugai");
		Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	@Test(enabled=false)
	public void add_code() throws InterruptedException {
		wsaction.codeAdd("javaxiugai");
		Assert.assertTrue(webtest.isTextPresent("已完成"));
	}
	
	
	@Test(enabled=false)
	public void look_work() {		
	    wsaction.workCheck();
	}
}
