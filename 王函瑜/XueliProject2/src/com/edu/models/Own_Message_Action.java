package com.edu.models;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.edu.core.BaseTest;
import com.edu.core.WebDriverEngine;

/*
 * author:wanghanyu
 * 个人信息及密码修改
 */

public class Own_Message_Action {
	private WebDriverEngine webtest;
	public Own_Message_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	
	}
	
	public void set_Massage(String pic,String num,String name,String message) throws InterruptedException {
		Thread.sleep(1000);
		webtest.type("id=uploadImageFile", "style","display:block",pic);
		Thread.sleep(3000);
		webtest.type("xpath=//input[@id='id_student_number']",num);
		Thread.sleep(2000);
		webtest.click("xpath=//input[@id='id_nickname']");			
		webtest.type("xpath=//input[@id='id_nickname']",Keys.chord(Keys.CONTROL+"a"));	
		Thread.sleep(1000);
		webtest.type("xpath=//input[@id='id_nickname']",Keys.DELETE);	
		Thread.sleep(1000);
		webtest.type("xpath=//input[@id='id_nickname']",name);	
		Thread.sleep(2000);
		webtest.click("xpath=//textarea[@class='form-control']");
		webtest.type("xpath=//textarea[@class='form-control']",Keys.chord(Keys.CONTROL+"a"));
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@class='form-control']",Keys.DELETE);
		Thread.sleep(1000);
		webtest.type("xpath=//textarea[@class='form-control']",message);
		Thread.sleep(2000);
		webtest.click("xpath=//input[@class='btn btn-success']");	
	}
	
	public void set_Password(String oldpawd,String newpawd,String newpawd2) throws InterruptedException {
		webtest.type("xpath=//input[@id='id_old_password']",oldpawd);
		Thread.sleep(2000);
		webtest.type("xpath=//input[@id='id_new_password1']",newpawd);
		Thread.sleep(2000);
		webtest.type("xpath=//input[@id='id_new_password2']",newpawd2);
		Thread.sleep(2000);
		webtest.click("xpath=//input[@class='btn']");
	}
	
}
