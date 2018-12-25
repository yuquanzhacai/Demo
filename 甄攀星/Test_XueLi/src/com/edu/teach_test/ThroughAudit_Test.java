package com.edu.teach_test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.edu.tec_models.Class_Action;
import com.edu.tec_models.Login_Action;

public class ThroughAudit_Test extends BaseTest{
	 	public Class_Action action=null;
		public Login_Action laction=null;
		@BeforeClass
		public void login()
		{
//			action=new Class_Action(webtest);
			laction=new Login_Action(webtest);
			laction.login("2784038315@qq.com","Zhen0820");
		}
		
		@Test(description="申请同步课的同学通过审核",priority=0)
		public void through_audit() throws InterruptedException
		{
			webtest.open("http://10.7.10.7/u/teams/");
			webtest.through();
			Thread.sleep(3000);
			Assert.assertFalse(webtest.ifContains("批量通过"));
		}
		
		@Test(description="申请同步课的同学通过审核",priority=1,enabled=false)
		public void through_audit2() throws InterruptedException
		{
			webtest.open("http://10.7.10.7/u/teams/");
			webtest.throughSelectAudit("1215");
			webtest.open("http://10.7.10.7/u/teams/");
			webtest.look();
			Assert.assertFalse(webtest.ifContains("1215"));
		}
}
