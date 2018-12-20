package com.edu.models;

import com.edu.core.WebDriverEngine;

/*
 * author:lixinran
 * modifier:wanghanyu
 * “且说”发表评论
 * 
 */

public class QieShuo_Action {
	
	private WebDriverEngine webtest;
	public QieShuo_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	}

	public void pinglun(String pl) throws InterruptedException {
		  webtest.click("xpath=//a[contains(@href,'/u/gossip/')]");
		  Thread.sleep(3000);
		  webtest.click("class=ke-edit-iframe");
		  webtest.type("tag=body", pl);
		  Thread.sleep(3000);
		  webtest.click("xpath=//button[@class='btn btn-sm btn-primary pull-right']");
	}
	  
    public void pinglundaima(String code) throws InterruptedException {
		  webtest.click("xpath=//a[contains(@href,'/u/gossip/')]");
		  Thread.sleep(3000);
		  webtest.click("class=ke-icon-code");
		  webtest.click("xpath=//option[@value='java']");
		  webtest.click("xpath=//textarea[@class='ke-textarea']");
		  webtest.type("class=ke-textarea", code);
		  webtest.click("xpath=//input[@value='确定']");
		  Thread.sleep(3000);
		  webtest.click("xpath=//button[@class='btn btn-sm btn-primary pull-right']");
	}
    public void pingluntupian(String add) throws InterruptedException {
		  webtest.click("xpath=//a[contains(@href,'/u/gossip/')]");
		  Thread.sleep(3000);
		  webtest.click("class=ke-icon-image");
		  webtest.click("xpath=//*[@class='ke-tabs']/ul/li[2]");
		  webtest.type("xpath=//input[@name='imgFile']", add);
		  webtest.click("xpath=//input[@value='确定']");
		  webtest.click("xpath=//button[contains(.,'发布')]");
     }
     public void fachengwen(String add,String title,String body) throws InterruptedException {
		  webtest.click("xpath=//a[contains(@href,'/u/gossip/')]");
		  Thread.sleep(3000);
		  webtest.click("xpath=//a[@class='gossip-create-article']");
		  webtest.getAllWindowTitles();
		  webtest.switchWidow(1);
		  webtest.type("xpath=//input[@accept='image/*']", "style", "display:block", add);
		  webtest.type("xpath=//input[@maxlength='32']", title);
		  webtest.click("class=cke_wysiwyg_frame");
		  webtest.type("tag=body",body);
		  webtest.click("xpath=//button[contains(.,'预览')]");
		  webtest.switchWidow(2);
		  webtest.close();
		  webtest.switchWidow(1);
		  Thread.sleep(2000);
		  webtest.click("xpath=//input[@type='submit']");
		  Thread.sleep(2000);
		  webtest.close();
		  Thread.sleep(2000);
	}
     
     public void fachengwen2(String add,String title,String body) throws InterruptedException {
    	  webtest.getAllWindowTitles();
    	  webtest.switchWidow(0);
 		  webtest.click("xpath=//a[contains(@href,'/u/gossip/')]");
 		  Thread.sleep(3000);
 		  webtest.click("xpath=//a[@class='gossip-create-article']");
 		  //webtest.getAllWindowTitles();
 		  boolean t = webtest.ifContains("发布长文");
 		  webtest.switchWidow(1);
 		  webtest.type("xpath=//input[@accept='image/*']", "style", "display:block", add);
 		  webtest.type("xpath=//input[@maxlength='32']", title);
 		  //webtest.click("id=cke_6_text");
 		  webtest.click("class=cke_wysiwyg_frame");
 		  webtest.type("tag=body",body);
 		  webtest.click("xpath=//button[contains(.,'预览')]");
 		
 		  Thread.sleep(2000);
 	}
     
     public void fachengwen3(String title,String body) throws InterruptedException {
		  webtest.click("xpath=//a[contains(@href,'/u/gossip/')]");
		  Thread.sleep(3000);
		  webtest.click("xpath=//a[@class='gossip-create-article']");
		  webtest.getAllWindowTitles();
		  boolean t = webtest.ifContains("发布长文");
		  webtest.switchWidow(1);
		  webtest.type("xpath=//input[@maxlength='32']", title);
		  //webtest.click("id=cke_6_text");
		  webtest.click("class=cke_wysiwyg_frame");
		  webtest.type("tag=body",body);
		  webtest.click("xpath=//button[contains(.,'预览')]");
//		  webtest.close();
		  Thread.sleep(2000);
	}
}
