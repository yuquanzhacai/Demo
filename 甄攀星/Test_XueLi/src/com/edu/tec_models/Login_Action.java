package com.edu.tec_models;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.webtest.core.WebDriverEngine;
/*
 * author:张玉
 * */
public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }

	  
	  public void login(String email,String password) 
	  {		
//		  	http://10.7.10.7/login/
			webtest.open("http://10.7.10.7/login/");
			webtest.type("name=username",email);
			webtest.type("name=password",password);
			webtest.click("id=submit");

		
	  }

}


