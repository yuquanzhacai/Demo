package com.webtest.demo;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

    
	public class xuelishixun_Action extends BaseTest{
		@Test
		public void  testSearch() throws Exception{
			webtest.open("http://10.7.10.7");
			webtest.click("xpath=//a[contains(.,'登录')]");
			webtest.type("name=username", "2240024073@qq.com");
			webtest.type("name=password","980603");
			webtest.click("xpath=//button[@id='submit']");
			webtest.click("xpath=//a[@href='/notifications/']");
//			webtest.open("http://10.7.10.7/notifications/likes/");
			
			webtest.runJs("arguments[0].click();","link=收到的赞");
			webtest.click("xpath=//a[@data-toggle='dropdown']");
			webtest.click("xpath=//a[@data-toggle='dropdown']");
			webtest.click("xpath=//a[contains(.,'收到的评论')]");
			webtest.click("xpath=//a[@data-toggle='dropdown']");
			webtest.click("xpath=//a[contains(.,'发出的评论')]");
			webtest.click("xpath=//a[contains(@href,'/course/')]");
			webtest.click("xpath=//h5[contains(.,'Github 开源之旅视频课程第一季：启程')]");
			webtest.click("xpath=//a[contains(.,'首页')]");
			webtest.click("xpath=//a[@class='cursor-pointer']");
			webtest.click("xpath=//a[@href='/u/courses/']");
			webtest.click("xpath=//a[@href='/u/courses/attention/']");
			webtest.click("xpath=//a[@href='/u/courses/interest/']");
			webtest.click("xpath=//a[contains(@href,'/course/')]");
			webtest.runJs("arguments[0].click();","link=课程分类");
			webtest.click("xpath=//a[@href='/course/category/5']");
			webtest.runJs("arguments[0].click();","link=课程分类:软件测试");
			
			
			
		}
	}
