package com.edu.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;
import com.edu.models.Work_Change_Action;

/*
 *玉儿的搜索框 
 */
public class Search extends BaseTest {
	
	Login_Action action;
	
	@BeforeClass
	public void before_Login() throws InterruptedException {
		action=new Login_Action(webtest);
		action.login("1336448191@qq.com", "ZHANGyu123");

	}
	
	@Test
	public void search_success() {
		
		webtest.type("xpath=.//*[@id='q']", "大学英语");
		webtest.click("xpath=.//*[@id='search-button']");
	}
	
	@Test
	public void search_fail() {
		
		webtest.type("xpath=.//*[@id='q']", "dagareharbhav");
		webtest.click("xpath=.//*[@id='search-button']");
	}
	
	@Test
	public void search_null() {
		
		webtest.click("xpath=.//*[@id='search-button']");
	}
	
}
