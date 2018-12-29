package com.edu.teach_test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.edu.tec_models.Class_Action;
import com.edu.tec_models.Login_Action;
/*
 * author:冯敏
 * description:老师创建同步课
 * */
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
		action.CreateClass("C:\\Users\\zhen\\Desktop\\img1.jpg","同步课课程二", "同步课课程二", "10");
//		"true","webtest.ifContains("发布任务")";
//		Assert.assertTrue(webtest.isTextPresent("发布任务"));
		Assert.assertTrue(webtest.ifContains("发布任务"));
	}
}