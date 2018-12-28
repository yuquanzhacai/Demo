package com.edu.models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.edu.core.WebDriverEngine;

/*
 * author:lixinran
 * modifier:wanghanyu
 * 修改作业
 * 
 */

public class Work_Change_Action {
	
	private WebDriverEngine webtest;
	public Work_Change_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	}
	
	//在原有基础上进行修改
	  public void workEdit(String txt) throws InterruptedException {
		 //webtest.click("class=cke_toolbar");
		  webtest.click("class=cke_wysiwyg_frame");
		  webtest.type("tag=body", txt);

	  }
	  
	  //将原文本内容删除，进行修改
	  public void workChange(String txt) throws InterruptedException {

		  //webtest.click("class=cke_toolbar");
		  webtest.click("class=cke_wysiwyg_frame");
		  webtest.type("tag=body",Keys.chord(Keys.CONTROL+"a"));
		  Thread.sleep(1000);
		  webtest.type("tag=body",Keys.DELETE);
		  webtest.type("tag=body", txt);
	  }
	  
	  //修改附件
	  public void fileEdit(String add) throws InterruptedException {	  
		  webtest.type("class=taskdetailAttachmentInput",add);
	  }
	  
	  //增加附件
	  public void Addfile(String add) throws InterruptedException {		 
		  webtest.type("class=taskdetailAttachmentInput",add);
	  }

	  //修改代码
	  public void codeEdit(String code) throws InterruptedException {
 
		  Thread.sleep(3000);
		  webtest.click("class=cke_combo_button");
		  Thread.sleep(3000);
		  webtest.ENTERClick();
		  webtest.ENTERClick();
		  Thread.sleep(3000);
		  webtest.click("xpath=//label[contains(.,'代码内容')]");
		  webtest.type("class=cke_dialog_ui_input_textarea",Keys.chord(Keys.CONTROL+"a"));
		  Thread.sleep(1000);
		  webtest.type("class=cke_dialog_ui_input_textarea",Keys.DELETE);
		  webtest.type("class=cke_dialog_ui_input_textarea", code);
		  webtest.click("xpath=//a[@title='确定']");

	  }
	  
	  //增加代码
	  public void codeAdd(String code) throws InterruptedException{  

	     // webtest.click("class=cke_toolbar");
	      webtest.click("class=cke_wysiwyg_frame");
	      webtest.click("class=cke_button__codesnippet");
	      webtest.click("xpath=//option[@value='java']");
	      webtest.click("xpath=//textarea[@class='cke_dialog_ui_input_textarea cke_source']");
	      webtest.type("class=cke_dialog_ui_input_textarea", code);
	      webtest.click("xpath=//span[contains(.,'确定')]");
	  }

}
