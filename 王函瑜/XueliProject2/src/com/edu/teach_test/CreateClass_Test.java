package com.edu.teach_test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.tec_models.Class_Action;
import com.edu.tec_models.Login_Action;

public class CreateClass_Test extends BaseTest{
	
    public Class_Action action=null;
	public Login_Action laction=null;
	@BeforeClass
	public void login()
	{
		action=new Class_Action(webtest);
		laction=new Login_Action(webtest);
		laction.login("2784038315@qq.com","Zhen0820");
	}
	@Test(description="测试创建同步课成功界面" )
	public void create_class()
	{
		action.CreateClass("E:\\1.png","青果", "青果", "10");
//		"true","webtest.ifContains("发布任务")";
//		Assert.assertTrue(webtest.isTextPresent("发布任务"));
		Assert.assertTrue(webtest.ifContains("发布任务"));
	}
}