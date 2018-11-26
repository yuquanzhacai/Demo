package com.webtest.action;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;


public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }

	  
	  public void login(String email,String password) 
	  {		
			webtest.open("http://10.7.10.7/login/");
			webtest.type("name=username",email);
			webtest.type("name=password",password);
			webtest.click("id=submit");

		
	  }
}


