package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Auto_test_action;
import com.edu.models.Login_Action;
import com.edu.core.WebTestListener;
import com.edu.core.WebTestListener2;


@Listeners({WebTestListener2.class,WebTestListener.class})
public class TestListener extends BaseTest{
	
//	@Test
//	public void t1() {
//		Assert.assertEquals(1, 2);
//	}
//	
//	@Test
//	public void t2() {
//		Assert.assertEquals(1, 1);
//	}
	
	Auto_test_action Auaction=null;
	Login_Action la=null;
	@Test
	public void before_Login() {
		Auaction=new Auto_test_action(webtest);
		la=new Login_Action(webtest);
		//´ò¿ªÒ³Ãæ
		webtest.open("http://10.7.10.7/login");
		la.login("2798011643@qq.com","Whymm131");
		Assert.assertTrue(webtest.isTextPresent("·ÛË¿"));

	}

}
