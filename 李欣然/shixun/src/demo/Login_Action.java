package demo;

import org.openqa.selenium.By;

import core.WebDriverEngine;

public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String email,String password) 
	  {
			webtest.type("name=username", email);
			webtest.type("name=password", password);
			webtest.click("xpath=//button[@id='submit']");
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("id=logoutLink");
	  }
	  public void tijiaozuoye(String txt) throws InterruptedException {
		    webtest.click("xpath=//i[@class='icon icon-edit']");
	    	webtest.click("xpath=//html[contains(@lang,'zh-cn')]");
	    	webtest.click("class=cke_toolbar");
	    	webtest.click("class=cke_wysiwyg_frame");
	    	webtest.type("tag=body", txt);
	    	Thread.sleep(3000);
	    	webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
	    	//webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	    }
	  public void shangchuanfujian(String add) {
		  webtest.click("xpath=//i[@class='icon icon-edit']");
	    //webtest.click("xpath=//html[contains(@lang,'zh-cn')]");
	      webtest.type("class=taskdetailAttachmentInput",add);
	  }
	  public void tijiaodaima(String code) {
		  webtest.click("xpath=//i[@class='icon icon-edit']");
		  webtest.click("xpath=//html[contains(@lang,'zh-cn')]");
	    	webtest.click("class=cke_toolbar");
	    	webtest.click("class=cke_wysiwyg_frame");
	    	webtest.click("class=cke_button__codesnippet");
	    	webtest.click("xpath=//option[@value='java']");
	    	
	  }
	  
}
