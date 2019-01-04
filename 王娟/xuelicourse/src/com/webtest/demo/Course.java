package com.webtest.demo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.demo.Login_Action;
import com.webtest.dataprovider.NSDataProvider;

public class Course extends BaseTest {
	private Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
		action.login("89@85.com","LAla852");
	}

	@Test//(dataProvider="txt",dataProviderClass=NSDataProvider.class)
	public void course()throws InterruptedException, IOException{
		//点击同步课
		webtest.click("xpath=//a[@href='/team/']");
		
		//进入第二页
		webtest.click("xpath=//a[@href='?page=2']");
		
		//申请加入同步课
		webtest.click("xpath=//button[@data-team='tong-bu-ke-ke-cheng-er']");
		webtest.type("xpath=//input[@maxlength='20']","测试");
		webtest.click("xpath=//button[contains(.,'申请加入')]");
		
		//进入具体同步课申请加入
		webtest.click("xpath=//h1[contains(.,'同步课一')]");
		webtest.click("xpath=//button[contains(.,'申请加入')]");
		webtest.type("xpath=//input[@maxlength='20']","测试");
		webtest.click("xpath=//button[@class='btn btn-primary apply-now']");
		
		//关注同步课成员
		webtest.click("xpath=//span[contains(.,' 成员')]");
		webtest.click("xpath=//h5[@title='老师']");
		webtest.click("xpath=//button[@id='id_fans']");
		
		//搜索同步课
		webtest.type("xpath=//input[@name='q']","青果");
		webtest.click("xpath=//button[@class='btn btn-default']");
		
		//查看已加入的同步课【新注册的号里没有已加入的同步课，换一个号才能看见】
		webtest.click("xpath=//a[contains(.,'首页')]");
		webtest.click("xpath=//a[@href='/u/teams/']");
		webtest.click("xpath=//h1[contains(.,'help')]");
		Assert.assertTrue(webtest.isTextPresent("任务"));
		
		//插入话题
		webtest.click("xpath=//span[contains(.,' 互动')]");
		webtest.click("xpath=//a[@title='插入#话题#']");
		webtest.click("xpath=//button[contains(.,'发布')]");
		
	}
	
}
