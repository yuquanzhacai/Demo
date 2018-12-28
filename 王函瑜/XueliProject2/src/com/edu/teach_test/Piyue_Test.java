package com.edu.teach_test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.tec_models.AddRenwu_Action;
import com.edu.tec_models.Login_Action;

public class Piyue_Test extends BaseTest{
	public AddRenwu_Action action=null;
	public Login_Action laction=null;
	@BeforeClass
	public void login()
	{
		laction=new Login_Action(webtest);
		laction.login("2784038315@qq.com","Zhen0820");
	}
	//需要一门同步课的一个作业有多个人提交
	//可以在大学英语中多让人提交一个任务
	@BeforeMethod
	  public void ke() {
		webtest.type("xpath=//input[@id='id_name']","嗯嗯");
		webtest.click("xpath=//button[@class='search-button']");
		webtest.click("xpath=//h1[contains(.,'嗯嗯')]");
	}

	@Test(description="批阅作业")
	  public void piyue() throws InterruptedException {
		webtest.click("xpath=//h2[contains(.,'任务四')]");
		webtest.click("xpath=//a[contains(.,'验收作业')]");
		Thread.sleep(3000);
		webtest.getWindow(1);
		webtest.click();
		webtest.tapClick();
		webtest.tapClick();
		webtest.ENTERClick();
		assertEquals(webtest.getValue("id=finished_task_count"),0,"待验收错误");
}	
}


