package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;
import com.edu.models.Work_Change_Action;

<<<<<<< HEAD:王函瑜/XueliProject/src/com/edu/test/Search.java
/*
 *玉儿的搜索框 
 */
public class Search extends BaseTest {
=======

/*
 * author:zhangyu
 * 搜索框
 * 
 */

public class Search_Test extends BaseTest {
>>>>>>> 1191a5a979de8933a40535de839db9e33a7af004:王函瑜/XueliProject2/src/com/edu/test/Search_Test.java
	
	Login_Action action;
	
	@BeforeClass
	public void before_Login() throws InterruptedException {
		action=new Login_Action(webtest);
		action.login("1336448191@qq.com", "ZHANGyu123");

	}
	
	
	@Test(description="正常搜索")
	public void search_success() throws InterruptedException {	
		webtest.click("xpath=//a[contains(.,'首页')]");
		webtest.type("xpath=.//*[@id='q']", "大学英语");
		webtest.click("xpath=.//*[@id='search-button']");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.isTextPresent("全部"));
	}
	
	//输入不存在内容
	@Test(description="搜索不存在的内容")
	public void search_fail() {
		webtest.click("xpath=//a[contains(.,'首页')]");
		webtest.type("xpath=.//*[@id='q']", "dagareharbhav");
		webtest.click("xpath=.//*[@id='search-button']");
		Assert.assertTrue(webtest.isTextPresent("没有关于"));

	}
	
	//输入为空时的搜索
	@Test(description="搜索空内容")
	public void search_null() {	
		webtest.click("xpath=//a[contains(.,'首页')]");
		webtest.click("xpath=.//*[@id='search-button']");
		Assert.assertTrue(webtest.isTextPresent("请输入要搜索的信息"));
		 
	}
	
}
