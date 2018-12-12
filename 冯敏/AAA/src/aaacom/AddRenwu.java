package aaacom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.edu.dataprovider.NsDataProvider;
import com.webtest.core.BaseTest;
//import com.edu.dataprovider.NSDataProvider;


public class AddRenwu extends BaseTest{
	@Test(description="发布任务")
		
	  public void addRenwu() {
		Login act = new Login(webtest);	
		webtest.open("http://10.7.10.7/login/");
		act.login("2784038315@qq.com","Zhen0820");
		webtest.type("id=id_name","嗯嗯");
		webtest.click("xpath=//button[@class='search-button']");
		webtest.click("xpath=//h1[contains(.,'嗯嗯')]");
		webtest.click("xpath=//button[contains(.,'发布任务')]");
		webtest.type("name=title","任务标题3");
		Actions action=new Actions(driver);
		action.sendKeys(Keys.TAB).perform();		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
	    driver.findElement(By.tagName("body")).sendKeys("任务描述");
		driver.switchTo().defaultContent();		
		action.sendKeys(Keys.TAB).perform();
		driver.findElement(By.tagName("body")).sendKeys("答案解析");
		webtest.type("id=id_grade_point","20");
		webtest.type("id=id_end_at","2018-12-12 13:00");
		webtest.click("xpath=//input[@id='id_submit']");
		assertTrue(webtest.ifContains("任务标题"));
	}

	@Test(description="批阅作业")
	
	  public void piyue() throws InterruptedException {
		webtest.click("xpath=//h2[contains(.,'任务标题2')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(.,'验收作业')]");
		Thread.sleep(3000);
	    webtest.click("xpath=//span[@title='验收']");
//	    webtest.click("xpath=//input[@data-result='0']");
	    webtest.type("data-result='0'", "10");
	    Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();;	
		assertEquals(0, 0,"待验收错误");
	}	
//	@Test
//	 public void nihao(){  
//	        ZipCompressor zc = new  ZipCompressor("D:\\eclipse-workspace\\AAA\\test-output.zip");  
//	        zc.compressExe("D:\\eclipse-workspace\\AAA\\test-output");
//	    }
}
