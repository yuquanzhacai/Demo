package com.edu.models;

import com.edu.core.WebDriverEngine;

public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String email,String password) 
	  {
			//打开网页
			webtest.open("http://10.7.10.7/login");
			webtest.type("name=username", email);
			webtest.type("name=password", password);
			webtest.click("xpath=//button[@type='submit']");
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("id=logoutLink");
	  }
	  

}
