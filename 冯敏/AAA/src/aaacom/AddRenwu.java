package aaacom;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;



public class AddRenwu extends BaseTest{
	@Test(description="发布任务")
	public void addRenwu(String username,String password) {
//		webtest.open("http://10.7.10.7/login/");
//        webtest.type("id=id_username","2784038315@qq.com");
//        webtest.type("id=id_password","Zhen0820");
//        webtest.click("xpath=//button[@id='submit']");
//        webtest.click("xpath=//a[contains(.,'嗯嗯')]");
       
		
		Login act = new Login(webtest);	
		webtest.open("http://10.7.10.7/login/");
		act.login("2784038315@qq.com","Zhen0820");
		webtest.click("xpath=//a[contains(.,'嗯嗯')]");
		
	}
	@Test
	 public void nihao(){  
	        ZipCompressor zc = new  ZipCompressor("D:\\eclipse-workspace\\AAA\\test-output.zip");  
	        zc.compressExe("D:\\eclipse-workspace\\AAA\\test-output");
	    }
}
