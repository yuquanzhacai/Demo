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
	    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	    }
	  public void shangchuanfujian(String add) {
		  webtest.click("xpath=//i[@class='icon icon-edit']");
	      webtest.type("class=taskdetailAttachmentInput",add);
	  }
	  public void tijiaodaima(String code) {
		  webtest.click("xpath=//i[@class='icon icon-edit']");
		  webtest.click("xpath=//html[contains(@lang,'zh-cn')]");
	      webtest.click("class=cke_toolbar");
	      webtest.click("class=cke_wysiwyg_frame");
	      webtest.click("class=cke_button__codesnippet");
	      webtest.click("xpath=//option[@value='java']");
	      webtest.click("xpath=//textarea[@class='cke_dialog_ui_input_textarea cke_source']");
	      webtest.type("class=cke_dialog_ui_input_textarea", code);
	      webtest.click("xpath=//span[contains(.,'确定')]");
	  }
	  public void chakanzuoye() {
		  webtest.click("xpath=//a[@href='/task/list/checked/']");
		  webtest.click("xpath=//i[@class='icon icon-eye-open']");
	  }
	  public void xiugaizuoye(String txt) throws InterruptedException {
		  webtest.click("xpath=//a[@href='/task/list/finished/']");
		  webtest.click("xpath=//i[@class='icon icon-file-text']");
		  webtest.click("class=cke_toolbar");
		  webtest.click("class=cke_wysiwyg_frame");
		  webtest.type("tag=body", txt);
		  Thread.sleep(3000);
		  webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
		  webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	  }
	  public void xiugaifujian(String add) throws InterruptedException {
		  webtest.click("xpath=//a[@href='/task/list/finished/']");
		  webtest.click("xpath=//i[@class='icon icon-file-text']");
		  Thread.sleep(3000);
		  webtest.type("class=taskdetailAttachmentInput",add);
		  Thread.sleep(3000);
		  webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
		  webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
		  
	  }
	  public void xiugaidaima(String code) throws InterruptedException {
		  webtest.click("xpath=//a[@href='/task/list/finished/']");
		  webtest.click("xpath=//i[@class='icon icon-file-text']");
		  Thread.sleep(3000);
		  webtest.click("class=cke_toolbar");
		  webtest.click("class=cke_wysiwyg_frame");
		  webtest.ENTERClick();
		  Thread.sleep(3000);
		  webtest.click("xpath=//label[contains(.,'代码内容')]");
		  webtest.type("class=cke_dialog_ui_input_textarea", code);
		  webtest.click("xpath=//a[@title='确定']");
		  webtest.click("xpath=//button[contains(@class,'btn btn-primary btn-sm td-preview')]");
		  webtest.click("xpath=//button[contains(.,'确认提交')]");
	  }
}
