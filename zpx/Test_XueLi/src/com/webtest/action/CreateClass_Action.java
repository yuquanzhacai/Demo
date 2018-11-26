package com.webtest.action;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;

public class CreateClass_Action {
	private WebDriverEngine webtest;
	public CreateClass_Action(WebDriverEngine webtest)
	{
		this.webtest=webtest;
	}

	public void CreateClass(String a,String b,String c)
	{
		webtest.click("//a[@title='创建同步课']");
		webtest.type("id=id_name",a);
		webtest.type("//input[@type='file']", "C:\\Users\\zhen\\Desktop\\timg.jpg");	
		webtest.click("id=id_check_type_1");
		webtest.type("class=ke-edit-iframe","b");
		webtest.click("//input[contains(@id,'1')]");
		webtest.typeAndClear("id=id_grade_average_percent",c);
		webtest.click("id=submit");
		
	}
}

