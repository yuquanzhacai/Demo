package com.webtest.demo;

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
	
	@Test
	public void search_success() {
		webtest.open("http://10.7.10.7/");
		action.login("1336448191@qq.com", "ZHANGyu123");
		
		webtest.type("xpath=.//*[@id='q']", "¥Û—ß”¢”Ô");
		webtest.click("xpath=.//*[@id='search-button']");
	}
	
	@Test
	public void search_fail() {
		webtest.open("http://10.7.10.7/");
		action.login("1336448191@qq.com", "ZHANGyu123");
		
		webtest.type("xpath=.//*[@id='q']", "dagareharbhav");
		webtest.click("xpath=.//*[@id='search-button']");
	}
	
	@Test
	public void search_null() {
		webtest.open("http://10.7.10.7/");
		action.login("1336448191@qq.com", "ZHANGyu123");
		
		webtest.click("xpath=.//*[@id='search-button']");
	}
	
}
