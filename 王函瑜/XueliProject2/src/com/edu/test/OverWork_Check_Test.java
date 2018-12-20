package com.edu.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;
import com.edu.models.Work_Check_Action;
import com.edu.models.Work_Submit_Action;

/*
 * author:lixinran
 * 查看作业
 * 
 */

public class OverWork_Check_Test extends BaseTest{
	
	Login_Action action;
	Work_Check_Action wsaction;
	
	@BeforeClass
	public void before_Login() throws InterruptedException {
		wsaction=new Work_Check_Action(webtest);
		action=new Login_Action(webtest);
		action.login("2798011643@qq.com","Whymm13145");

	}
	
	@Test(description="已完结课程查看")
	public void look_work() {
	    wsaction.workCheck();
	}
	
}
