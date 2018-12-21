package com.edu.teach_test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.tec_models.AddRenwu_Action;
import com.edu.tec_models.Login_Action;
//import com.edu.dataprovider.NsDataProvider;
import com.webtest.core.BaseTest;
//import com.edu.dataprovider.NSDataProvider;


public class AddRenwu_Test extends BaseTest{
	public AddRenwu_Action action=null;
	public Login_Action laction=null;
	@BeforeClass
	public void login()
	{
		laction=new Login_Action(webtest);
		laction.login("2784038315@qq.com","Zhen0820");
	}
	
	@Test(description="发布任务")//,enabled=false
	  public void addRenwu() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd_HHmm");
		String nowDateTime=sdf.format(new Date());
		webtest.type("id=id_name","嗯嗯");
		webtest.click("xpath=//button[@class='search-button']");
		webtest.click("xpath=//h1[contains(.,'嗯嗯')]");
		webtest.click("xpath=//button[contains(.,'发布任务')]");
		webtest.type("name=title","任务"+nowDateTime);
		webtest.taskdescription();
		webtest.type("id=id_grade_point","20");
		webtest.type("id=id_end_at","2018-12-31 13:00");
		webtest.click("xpath=//input[@id='id_submit']");
		assertTrue(webtest.ifContains("任务标题"));
	}

}

