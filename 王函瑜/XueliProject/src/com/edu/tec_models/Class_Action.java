package com.edu.tec_models;

import com.edu.core.WebDriverEngine;

public class Class_Action {
	private WebDriverEngine webtest;
	public Class_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	}
	


	public void CreateClass(String pic,String a,String b,String c)
	{
		
	    webtest.open("http://10.7.10.7/u/teams/");
		webtest.click("class=create-button");
		webtest.type("id=id_name",a);
		webtest.tapClick();
		webtest.type("name=icon",pic);
		webtest.click("id=id_check_type_1");
		webtest.type("class=ke-edit-iframe",b);
		webtest.click("//input[contains(@id,'1')]");
		webtest.typeAndClear("id=id_grade_average_percent",c);
		webtest.click("id=submit");
		while(webtest.ifContains("当前同步课已经存在，请更换名称")) {
		if (webtest.ifContains("当前同步课已经存在，请更换名称")) {
				a=a+"*";
				webtest.typeAndClear("id=id_name",a);
				webtest.click("id=submit");
		}
		else {
				webtest.open("http://10.7.10.7/u/teams/");
			}
		}
	}
	public void throughAllAudit() throws InterruptedException
	{
			webtest.open("http://10.7.10.7/u/teams/");
			Thread.sleep(3000);
			webtest.mouseLong();
			webtest.mouseFloat("//i[@class='icon icon-bell']");
			//driver.findElement(By.xpath("//span[@class='notification-box']"));
			webtest.click("//a[@href='/u/teams/applications/']");
			webtest.click("//th[@class='check-all check-btn']");
			webtest.click("//button[contains(.,'批量通过')]");
	}
	public void throughSelectAudit(String name) throws InterruptedException {
		webtest.open("http://10.7.10.7/u/teams/");
		Thread.sleep(5000);
		webtest.runJs("arguments[0].click();","link=ͬ同步课申请");

	}
}
