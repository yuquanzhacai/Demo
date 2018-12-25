package com.webtest.action;

import com.webtest.core.WebDriverEngine;

public class Audit_Action {
	private WebDriverEngine webtest;
	public Audit_Action(WebDriverEngine webtest)
	{
		this.webtest=webtest;
	}
	public void throughAllAudit() throws InterruptedException
	{
		webtest.open("http://10.7.10.7/u/teams/");
//		webtest.mouseoverElement("//a[@href='/u/teams/applications/']");
//		webtest.click("//th[@class='check-all check-btn']");
		webtest.through();
		webtest.click("//button[contains(.,'批量通过')]");
	}
	public void throughSelectAudit(String name) throws InterruptedException
	{
		webtest.mouseoverElement("//a[@href='/u/teams/applications/']");
		webtest.type("//input[@id='id_nickname']", "name");
		webtest.click("//button[@class='search-button']");
		webtest.click("//th[@class='check-all check-btn']");
		webtest.click("//button[contains(.,'批量通过')]");
	}
//	driver.findElement(By.xpath("//input[@id='id_nickname']"));
//	webtest.typeAndClear("//input[@id='id_nickname']", name);
//	driver.findElement(By.xpath("//button[@class='search-button']"));
}
