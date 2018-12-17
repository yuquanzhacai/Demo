package com.edu.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;

/*
 * author:wangpenghe
 *通知
 */
    
	public class Notice_Test extends BaseTest{
		
		Login_Action action;
		
		@BeforeClass
		public void before_Login() throws InterruptedException {
			action=new Login_Action(webtest);
			action.login("1336448191@qq.com", "ZHANGyu123");

		}
		
		@BeforeMethod
		public void each_Notice() {
			webtest.click("xpath=//a[@href='/notifications/']");
		}
		
		@Test(description="@我的")
		public void notice() {          
            Assert.assertTrue(webtest.isTextPresent("@我的"));				
		}
		
		@Test(description="收到的赞")
		public void praise() throws InterruptedException {
			webtest.runJs("arguments[0].click();","link=收到的赞");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("赞了"));
		}
		
		@Test(description="查看评论")
		public void comment() throws InterruptedException {
			webtest.click("xpath=//a[@data-toggle='dropdown']");
			webtest.click("xpath=//a[contains(.,'收到的评论')]");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("收到的评论"));
			webtest.click("xpath=//a[@data-toggle='dropdown']");
			webtest.click("xpath=//a[contains(.,'发出的评论')]");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("发出的评论"));
		}
		

	}
