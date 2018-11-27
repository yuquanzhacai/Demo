package com.edu.own;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class Auto_test_action extends BaseTest{
	
	public void set_Massage(String num,String name,String message) throws InterruptedException {
		Thread.sleep(1000);
		webtest.type("xpath://input[@id='uploadImageFile']", "style","display:block","E:\\\\8.jpg");
		Thread.sleep(3000);
		webtest.type("xpath://input[@id='id_student_number']",num);
		Thread.sleep(2000);
		webtest.click("xpath://input[@id='id_nickname']");			
		webtest.type("xpath://input[@id='id_nickname']",Keys.chord(Keys.CONTROL+"a"));			
		webtest.type("xpath://input[@id='id_nickname']",Keys.DELETE);	
		webtest.type("xpath://input[@id='id_nickname']",name);	
		Thread.sleep(2000);
		webtest.click("xpath://textarea[@class='form-control']");
		webtest.type("xpath://textarea[@class='form-control']",Keys.chord(Keys.CONTROL+"a"));	
		webtest.type("xpath://textarea[@class='form-control']",Keys.DELETE);
		webtest.type("xpath://textarea[@class='form-control']",message);
		Thread.sleep(2000);
		webtest.click("xpath://input[@class='btn btn-success']");	
	}
	
	public void set_Password(String oldpawd,String newpawd,String newpawd2) throws InterruptedException {
		webtest.type("xpath://input[@id='id_old_password']",oldpawd);
		Thread.sleep(2000);
		webtest.type("xpath://input[@id='id_new_password1']",newpawd);
		Thread.sleep(2000);
		webtest.type("xpath://input[@id='id_new_password2']",newpawd2);
		Thread.sleep(2000);
	}
	
}
