package demo;

import core.WebDriverEngine;

public class tijiao {
	private WebDriverEngine webtest;
	public tijiao(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
    public void tijiaozuoye(String txt) {
    	webtest.click("cke_wysiwyg_frame");
    	webtest.type("tag=body", txt);
    	webtest.click("xpath=//button[@class='btn btn-primary btn-sm td-preview']");
    	webtest.click("xpath=//button[@class='btn btn-primary td-submit']");
    }
}
