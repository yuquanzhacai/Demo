package com.edu.models;

import com.edu.core.WebDriverEngine;

public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String email,String password) 
	  {
	
			//webtest.click("link=µÇÂ¼");
			webtest.type("name=username", email);
			webtest.type("name=password", password);
			//webtest.click("xpath=//input[@value='ÂíÉÏµÇÂ¼']");
			webtest.click("xpath=//button[@type='submit']");
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("id=logoutLink");
	  }
	  

}
