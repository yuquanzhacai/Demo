package com.edu.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;
import com.edu.models.Work_Check_Action;
import com.edu.models.Work_Submit_Action;
<<<<<<< HEAD:王函瑜/XueliProject/src/com/edu/test/OverWork_Check_Test.java
/*
 *欣然的 查看已完成
 */
=======

/*
 * author:lixinran
 * 查看作业
 * 
 */

>>>>>>> 1191a5a979de8933a40535de839db9e33a7af004:王函瑜/XueliProject2/src/com/edu/test/OverWork_Check_Test.java
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
