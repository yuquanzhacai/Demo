package com.webtest.action;

import com.webtest.core.WebDriverEngine;

public class CheckAndClass_Action {
	private WebDriverEngine webtest;
	  public CheckAndClass_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  public void checkandclassAction()
	  {
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
