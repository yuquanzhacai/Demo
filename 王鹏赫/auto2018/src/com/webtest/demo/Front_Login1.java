package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Front_Login1 extends BaseTest{


	@Test
	public void testSearch() throws Exception  {
		webtest.open("http://localhost:8033/mymovie/");
		webtest.click("link=锟斤拷录");
		webtest.type("name=username", "qingdao01");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='锟斤拷锟较碉拷录']");
		assertTrue(webtest.ifContains("锟剿筹拷"));
		

	}

}
