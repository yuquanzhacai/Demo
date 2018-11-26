package com.webtest.demo;

import com.webtest.core.WebDriverEngine;

public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String username,String password) 
	  {
	
			webtest.click("link=µÇÂ¼");
			webtest.type("name=username", username);
			webtest.type("name=password", password);
			webtest.click("id=submit");
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("id=logoutLink");
	  }
	  

}
