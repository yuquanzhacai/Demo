package com.edu.models;

import org.openqa.selenium.Keys;

import com.edu.core.WebDriverEngine;

public class Work_Submit_Action {
	private WebDriverEngine webtest;
	public Work_Submit_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	}
	public void workSubmit(String txt) throws InterruptedException {
	    webtest.click("xpath=//i[@class='icon icon-edit']");
    	webtest.click("xpath=//html[contains(@lang,'zh-cn')]");
    	webtest.click("class=cke_toolbar");
    	webtest.click("class=cke_wysiwyg_frame");
    	webtest.type("tag=body", txt);
    	Thread.sleep(3000);
    	webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
    }
  public void flieSubmit(String add) {
	  webtest.click("xpath=//i[@class='icon icon-edit']");
      webtest.type("class=taskdetailAttachmentInput",add);
  }
  public void codeSubmit(String code) {
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
  public void workCheck() {
	  webtest.click("xpath=//a[@href='/task/list/checked/']");
	  webtest.click("xpath=//i[@class='icon icon-eye-open']");
  }
  //在原有基础上进行修改
  public void workEdit(String txt) throws InterruptedException {
	  webtest.click("xpath=//a[@href='/task/list/finished/']");
	  webtest.click("xpath=//i[@class='icon icon-file-text']");
	  webtest.click("class=cke_toolbar");
	  webtest.click("class=cke_wysiwyg_frame");
	  webtest.type("tag=body", txt);
	  Thread.sleep(3000);
	  webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
	  webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
  }
  //将原文本内容删除，进行修改
  public void workChange(String txt) throws InterruptedException {
	  webtest.click("xpath=//a[@href='/task/list/finished/']");
	  webtest.click("xpath=//i[@class='icon icon-file-text']");
	  webtest.click("class=cke_toolbar");
	  webtest.click("class=cke_wysiwyg_frame");
	  webtest.type("tag=body",Keys.chord(Keys.CONTROL+"a"));
	 Thread.sleep(1000);
	  webtest.type("tag=body",Keys.DELETE);
	  webtest.type("tag=body", txt);
	  Thread.sleep(3000);
	  webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
	  webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
  }
  public void fileEdit(String add) throws InterruptedException {
	  webtest.click("xpath=//a[@href='/task/list/finished/']");
	  webtest.click("xpath=//i[@class='icon icon-file-text']");
	  Thread.sleep(3000);
	  webtest.type("class=taskdetailAttachmentInput",add);
	  Thread.sleep(3000);
	  webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
	  webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
	  
  }
  public void codeEdit(String code) throws InterruptedException {
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
  
  public void codeAdd(String code) throws InterruptedException{  
	  webtest.click("xpath=//i[@class='icon icon-edit']");
	  webtest.click("xpath=//html[contains(@lang,'zh-cn')]");
      webtest.click("class=cke_toolbar");
      webtest.click("class=cke_wysiwyg_frame");
      webtest.click( "id=cke_71");
      webtest.click("xpath=//option[@value='java']");
      webtest.click("xpath=//textarea[@class='cke_dialog_ui_input_textarea cke_source']");
      webtest.type("class=cke_dialog_ui_input_textarea", code);
      webtest.click("xpath=//span[contains(.,'确定')]");
  }

}
