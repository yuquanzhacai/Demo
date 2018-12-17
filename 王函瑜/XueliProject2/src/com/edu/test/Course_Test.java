package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;

public class Course_Test extends BaseTest{

	Login_Action action;
	
	@BeforeClass
	public void before_Login() throws InterruptedException {
		action=new Login_Action(webtest);
		action.login("1336448191@qq.com", "ZHANGyu123");

	}
	
	@Test(description="直接搜索课程")
	public void  course_Search() throws Exception{		
		//课程
		webtest.click("xpath=//a[contains(@href,'/course/')]");
		webtest.click("xpath=//h5[contains(.,'Github 开源之旅视频课程第一季：启程')]");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("Github"));
	}
	
	@Test(description="搜索分类课程")
	public void  course_Search2() throws Exception{
		//课程
		webtest.click("xpath=//a[contains(@href,'/course/')]");
		webtest.runJs("arguments[0].click();","link=课程分类");
		webtest.click("xpath=//a[@href='/course/category/5']");
		webtest.click("xpath=//h5[contains(.,'软件测试实践')]");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("软件测试实践"));
		webtest.click("xpath=//a[@class='cursor-pointer']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("关注"));
	
	}
	
	@Test(description="搜索分类体系课程，并关注")
	public void  course_Search3() throws Exception{
		//课程
		webtest.click("xpath=//a[contains(@href,'/course/')]");
		webtest.runJs("arguments[0].click();","link=课程分类");
		webtest.click("xpath=//a[@href='/course/category/5']");
		webtest.runJs("arguments[0].click();","link=课程体系");
		webtest.click("xpath=//a[contains(.,'软件测试工程师')]");
		webtest.click("xpath=//button[@data-interested='10']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("软件测试工程师"));
		webtest.click("xpath=//a[@class='cursor-pointer']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isTextPresent("关注"));
	
	}
	
	@Test(description="查看我的课程")
	public void  course_Look() throws Exception{		
		//首页查看
		//webtest.click("xpath=//a[contains(.,'首页')]");
		webtest.click("xpath=//a[@class='cursor-pointer']");
		webtest.click("xpath=//a[@href='/u/courses/']");
		Assert.assertTrue(webtest.isTextPresent("正在学习"));
		webtest.click("xpath=//a[@href='/u/courses/attention/']");
		Assert.assertTrue(webtest.isTextPresent("我关注的"));
		webtest.click("xpath=//a[@href='/u/courses/interest/']");
		Assert.assertTrue(webtest.isTextPresent("我看过的"));
		
	}
}
