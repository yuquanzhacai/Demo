package aaacom;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.edu.dataprovider.NsDataProvider;
import com.webtest.core.BaseTest;
public class AddRenwu1 extends BaseTest{
	@BeforeClass
	  public void denglu() {
		Login act = new Login(webtest);	
		webtest.open("http://10.7.10.7/login/");
		act.login("2784038315@qq.com","Zhen0820");
	}
	@BeforeMethod
	  public void ke() {
		webtest.type("xpath=//input[@id='id_name']","嗯嗯");
		webtest.click("xpath=//button[@class='search-button']");
		webtest.click("xpath=//h1[contains(.,'嗯嗯')]");
	}
	@Test(description="发布任务",dataProvider="txt",dataProviderClass=NsDataProvider.class)
	  public void addRenwu(String title,String body,String body2,String point,String time) {				
		webtest.click("xpath=//button[contains(.,'发布任务')]");
		webtest.type("name=title",title);
//		Actions action=new Actions(driver);
		webtest.tapClick();
//		action.sendKeys(Keys.TAB).perform();	
		webtest.enterFrame(webtest.getValue("xpath=//iframe[@class='cke_wysiwyg_frame cke_reset']"));
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		webtest.type("tagName=body",body);
//		driver.findElement(By.tagName("body")).sendKeys("任务描述");
//		driver.switchTo().defaultContent();	
		webtest.leaveFrame();
//		action.sendKeys(Keys.TAB).perform();
		webtest.tapClick();
		webtest.type("tagName=body",body2);
//		driver.findElement(By.tagName("body")).sendKeys("答案解析");
		webtest.type("id=id_grade_point",point);
		webtest.type("id=id_end_at",time);
		webtest.click("xpath=//input[@id='id_submit']");
		assertTrue(webtest.ifContains("作业2"));
	}

	@Test(description="批阅作业")
	
	  public void piyue() throws InterruptedException {
		webtest.click("xpath=//h2[contains(.,'任务标题2')]");
		webtest.click("xpath=//a[contains(.,'验收作业')]");
		Thread.sleep(3000);
		webtest.getWindow(1);
//		System.out.println(webtest.getTitle());
		webtest.click();
//		System.out.println("是否存在"+webtest.isElementPresent("id=check_detail_pane"));
//		webtest.isDisplayed("id=check_detail_pane");
//		webtest.runJs("arguments[0].click()", "id=check_detail_pane");
//		webtest.runJs("arguments[0].click()", "title='验收");    
//	    webtest.click("xpath=//input[@data-result='0']");
//	    webtest.type("data-result='0'", "10");
		webtest.tapClick();
		webtest.tapClick();
		webtest.enterClick();
		assertEquals(webtest.getValue("id=finished_task_count"),0,"待验收错误");
//	    Actions action=new Actions(driver);
//	    action.sendKeys(Keys.TAB).perform();
//	    action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.ENTER).perform();
//		assertEquals(driver.findElement(By.xpath("//span[@id='finished_task_count']")).getText(), 0,"待验收错误");
}	
}

