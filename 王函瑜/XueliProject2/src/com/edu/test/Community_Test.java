package com.edu.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;

/*
 * author:wangjuan
 * “社区”部分
 * 
 */

public class Community_Test extends BaseTest{
	

	private Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
		action.login("why2798011643@126.com","Whymm13145");
	}
	
	//社区的功能测试
	@Test(description="社区部分")
	public void community() throws InterruptedException {
		//点击社区
		webtest.click("xpath=//a[contains(.,'社区')]");
		//点击文章
		webtest.click("xpath=//div[@class='article-title']");
		//切换窗口
		webtest.getAllWindowTitles();
	    webtest.switchWidow(1);
		//收藏
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='favorite']");
		//取消收藏
		webtest.click("xpath=//a[@class='favorite']");
		//转发
		webtest.click("xpath=//a[@class='forward']");
		webtest.type("xpath=//form[@class='forward-form']","测试");
		webtest.click("xpath=//button[contains(.,'转发')]");
		//评论
		webtest.click("class=ke-edit-iframe");
		webtest.type("tag=body","测试");
		webtest.click("xpath=//button[contains(.,'评论')]");
		Thread.sleep(2000);
		//点赞
		webtest.click("xpath=//a[@class='like']");
	}
	
}
