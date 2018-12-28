package com.webtest.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;

@Listeners({ WebTestListener.class })
public class Search extends BaseTest {
	
	Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}
	
	@Test(description="完全吻合的搜索")
	public void search_success() throws InterruptedException {
		webtest.open("http://10.7.10.7/");
		action.login("1336448191@qq.com", "ZHANGyu123");
		
		webtest.type("xpath=.//*[@id='q']", "大学英语");
		webtest.click("xpath=.//*[@id='search-button']");
		Thread.sleep(3000);
		
		String str=webtest.panduan2("xpath=.//*[@id='id_search_tab']/div[3]/section/div[1]/div/div/div[1]/h4/a[2]");
		Assert.assertEquals(str, "大学英语","搜索结果不对");
	}
	
	@Test(description="拼音全称搜索")
	public void search_fail() throws InterruptedException {
		webtest.open("http://10.7.10.7/");
		action.login("1336448191@qq.com", "ZHANGyu123");
		
		webtest.type("xpath=.//*[@id='q']", "daxueyingyu");
		webtest.click("xpath=.//*[@id='search-button']");
		
		Thread.sleep(3000);
		
		String str=webtest.panduan2("xpath=.//*[@id='id_search_tab']/div[3]/section/div[1]/div/div/div[1]/h4/a[2]");
		Assert.assertEquals(str, "大学英语","搜索结果不对");		
	}
	
	@Test(description="空搜索")
	public void search_null() {
		webtest.open("http://10.7.10.7/");
		action.login("1336448191@qq.com", "ZHANGyu123");
		
		webtest.click("xpath=.//*[@id='search-button']");
	}
	
	@Test(description="关键字搜索")
	public void search_incomplete() throws InterruptedException {
		webtest.open("http://10.7.10.7/");
		action.login("1336448191@qq.com", "ZHANGyu123");
		
		webtest.type("xpath=.//*[@id='q']", "大学");
		webtest.click("xpath=.//*[@id='search-button']");
		Thread.sleep(3000);
		
		boolean str=webtest.panduan3("xpath=.//*[@id='id_search_tab']/div[3]/section/div[1]/div/div/div[1]/h4/a[2]","大学");
		Assert.assertEquals(str, true,"搜索结果不对");
	}
	
}
