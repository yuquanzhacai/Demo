package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Front_Login1 extends BaseTest{


	@Test
	public void testSearch() throws Exception  {
		webtest.open("http://10.7.10.7/");
		Thread.sleep(1000);
		//登录账号
		webtest.click("xpath=//a[contains(.,'登录')]");
		webtest.type("xpath=//input[@name='username']","jojo@qq.com");
		webtest.type("xpath=//input[@name='password']","LAla852");
		webtest.click("xpath=//button[contains(.,'登录')]");
		
		
		//点击同步课
		webtest.click("xpath=//a[@href='/team/']");
		
		//申请加入同步课
		webtest.click("xpath=//button[@data-team='20']");
		webtest.type("xpath=//input[@maxlength='20']","测试");
		webtest.click("xpath=//button[contains(.,'申请加入')]");
		
		Thread.sleep(1000);
		//进入具体同步课申请加入
		webtest.click("xpath=//h1[contains(.,'大学俄语')]");
		webtest.click("xpath=//button[contains(.,'申请加入')]");
		webtest.type("xpath=//input[@maxlength='20']","测试");
		webtest.click("xpath=//button[@class='btn btn-primary apply-now']");
		
		//关注同步课成员
		webtest.click("xpath=//span[contains(.,' 成员')]");
		webtest.click("xpath=//h5[@title='老师']");
		webtest.click("xpath=//button[@id='id_fans']");
		
		//搜索同步课
		webtest.type("xpath=//input[@id='q']","wegr");
		webtest.click("xpath=//button[@class='btn btn-default']");
		
		Thread.sleep(3000);
		//查看已加入的同步课【新注册的号里没有已加入的同步课，换一个号才能看见】
		webtest.click("xpath=//a[contains(.,'首页')]");
		webtest.click("xpath=//a[@href='/u/teams/']");
		webtest.click("xpath=//h1[contains(.,'wegr')]");
		webtest.click("xpath=//span[contains(.,' 互动')]");
		
		//插入话题
		webtest.click("xpath=//a[@title='插入#话题#']");
		webtest.click("xpath=//button[contains(.,'发布')]");
		

	}

}
