package com.edu.models;

import org.openqa.selenium.Keys;

import com.edu.core.WebDriverEngine;

/*
 * author:lixinran
 * 提交作业
 * 
 */

public class Work_Submit_Action {
	private WebDriverEngine webtest;
	public Work_Submit_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	}
	
	//提交文本
	public void workSubmit(String txt) throws InterruptedException {
		
    	webtest.click("xpath=//html[contains(@lang,'zh-cn')]");
    	//webtest.click("class=cke_toolbar");
    	webtest.click("class=cke_wysiwyg_frame");
    	webtest.type("tag=body", txt);
    	
    }
	
	//提交附件
   public void flieSubmit(String add) {
      webtest.type("class=taskdetailAttachmentInput",add);
   }
  
   //提交代码
   public void codeSubmit(String code) {	  
	  webtest.click("xpath=//html[contains(@lang,'zh-cn')]");
     // webtest.click("class=cke_toolbar");
      webtest.click("class=cke_wysiwyg_frame");
      webtest.click("class=cke_button__codesnippet");
      webtest.click("xpath=//option[@value='java']");
      webtest.click("xpath=//textarea[@class='cke_dialog_ui_input_textarea cke_source']");
      webtest.type("class=cke_dialog_ui_input_textarea", code);
      webtest.click("xpath=//span[contains(.,'确定')]");
  }
  
}
