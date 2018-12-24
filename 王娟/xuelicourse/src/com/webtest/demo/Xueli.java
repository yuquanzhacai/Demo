package com.webtest.demo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Xueli extends BaseTest{

//	@Test(dataProvider="txt",dataProviderClass=NSDataProvider.class)
//	public void course(String s1)throws InterruptedException, IOException{
//		//打开雪梨
//		
//		webtest.open("http://10.7.10.7/");
//		Thread.sleep(1000);
//		//登录账号
//		webtest.click("xpath=//a[contains(.,'登录')]");
//		webtest.type("xpath=//input[@name='username']","hua8@qq.com");
//		webtest.type("xpath=//input[@name='password']","LAla852");
//		webtest.click("xpath=//button[contains(.,'登录')]");
//		
//		//点击同步课
//		webtest.click("xpath=//a[@href='/team/']");
//		
//		//申请加入同步课
//		
//		webtest.click("xpath=//button[@data-team='a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-']");
//		webtest.type("xpath=//input[@maxlength='20']","测试");
//		webtest.click("xpath=//button[contains(.,'申请加入')]");
//		
//		//进入具体同步课申请加入
//		webtest.click("xpath=//h1[contains(.,'大学俄语')]");
//		webtest.click("xpath=//button[contains(.,'申请加入')]");
//		webtest.type("xpath=//input[@maxlength='20']","测试");
//		webtest.click("xpath=//button[@class='btn btn-primary apply-now']");
//		
//		//关注同步课成员
//		webtest.click("xpath=//span[contains(.,' 成员')]");
//		webtest.click("xpath=//h5[@title='老师']");
//		webtest.click("xpath=//button[@id='id_fans']");
//		
//		//搜索同步课
//		webtest.type("xpath=//input[@name='q']",s1);
//		webtest.click("xpath=//button[@class='btn btn-default']");
//		
//		//查看已加入的同步课【新注册的号里没有已加入的同步课，换一个号才能看见】
//		webtest.click("xpath=//a[contains(.,'首页')]");
//		webtest.click("xpath=//a[@href='/u/teams/']");
//		webtest.click("xpath=//h1[contains(.,'wegr')]");
//		webtest.click("xpath=//span[contains(.,' 互动')]");
//		
//		//插入话题
//		webtest.click("xpath=//a[@title='插入#话题#']");
//		webtest.click("xpath=//button[contains(.,'发布')]");
//		
//		driver.close();	
//	}
	
	//社区的功能测试
	@Test
	public void talk() throws InterruptedException {
		//打开雪梨
		webtest.open("http://10.7.10.7/");
		Thread.sleep(1000);
		//登录账号
		webtest.click("xpath=//a[contains(.,'登录')]");
		webtest.type("xpath=//input[@name='username']","hua8@qq.com");
		webtest.type("xpath=//input[@name='password']","LAla852");
		webtest.click("xpath=//button[contains(.,'登录')]");
		//点击社区
		webtest.click("xpath=//a[contains(.,'社区')]");
		Thread.sleep(5000);
		//点击文章
		webtest.click("xpath=//html/body/div[1]/div/div/div[1]/div/section/div[1]/div[2]/div[1]/div/div[2]/a/div[2]");
		Thread.sleep(5000);
		//点击收藏
		webtest.click("xpath=//a[@class='favorite']");
		//取消收藏
		webtest.click("xpath=//a[@class='favorite']");
		//转发
		webtest.click("xpath=//a[@class='forward']");
		webtest.type("xpath=//a[@class='forward']", "测试");
		webtest.click("xpath=//button[contains(.,'转发')]");
		//评论
		webtest.click("xpath=//a[@title='插入#话题#']");
		webtest.click("xpath=//button[contains(.,'评论')]");
		//赞
		webtest.click("xpath=//a[@class='like']");
		
	}
	
}
