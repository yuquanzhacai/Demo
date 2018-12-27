package com.edu.models;

import com.edu.core.WebDriverEngine;

/*
 * author:lixinran
 * 查看作业
 * 
 */

public class Work_Check_Action {

	private WebDriverEngine webtest;
	public Work_Check_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	}

	//查看，已完结
	  public void workCheck() {
		  webtest.click("xpath=//a[@href='/task/list/checked/']");
		  webtest.click("xpath=//i[@class='icon icon-eye-open']");
	  }
	  
}
