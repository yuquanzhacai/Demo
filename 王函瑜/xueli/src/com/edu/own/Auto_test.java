package com.edu.own;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.core.BaseTest;



public class Auto_test extends BaseTest{
	@BeforeClass
	public void before_Login() throws InterruptedException {
		//打开页面
		webtest.open("http://10.7.10.7/login");
		//文本框输入
		webtest.type("name=username","2798011643@qq.com");
		webtest.type("name=password","Whymm1314");
		webtest.click("xpath://button[@type='submit']");

	}
	
	@BeforeMethod
	public void own_Beg() throws InterruptedException {
		webtest.mouseFloat("xpath://img[@src='/static/img/m.png']");
		Thread.sleep(2000);
	}
	
	@Test
	public void own_Massage() throws InterruptedException{	
		webtest.click("xpath://a[contains(.,'个人主页')]");	
		
	}
}
