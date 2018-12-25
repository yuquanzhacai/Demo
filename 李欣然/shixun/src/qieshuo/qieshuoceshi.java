package qieshuo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.util.Set;
import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

public class qieshuoceshi {
//  @Test
//  public void pinglun() throws InterruptedException {
//	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\\\geckodriver.exe");
//	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//      WebDriver driver = new FirefoxDriver(); 
//      driver.manage().window().maximize();
//      driver.get("http://10.7.10.7/task/list/");
//      driver.findElement(By.name("username")).sendKeys("952184149@qq.com");
//      driver.findElement(By.name("password")).sendKeys("323841");
//      driver.findElement(By.xpath("//button[@id='submit']")).click();
//      driver.findElement(By.xpath("//a[contains(@href,'/u/gossip/')]")).click();
//      Thread.sleep(3000);
//      driver.findElement(By.className("ke-edit-iframe")).click();
//      driver.findElement(By.tagName("body")).sendKeys("#我的话题#发送评论");
//      driver.findElement(By.className("ke-icon-code")).click();
//      driver.findElement(By.xpath("//option[@value='java']")).click();
//      driver.findElement(By.xpath("//textarea[@class='ke-textarea']")).click();
//      driver.findElement(By.className("ke-textarea")).sendKeys("java");
//      driver.findElement(By.xpath("//input[@value='确定']")).click();
//     driver.findElement(By.className("ke-icon-image")).click();
//     driver.findElement(By.xpath("//*[@class='ke-tabs']/ul/li[2]")).click();
//     driver.findElement(By.xpath("//input[@name='imgFile']")).sendKeys("G:\\东西1\\成图\\新建图4.jpg");
//     driver.findElement(By.xpath("//input[@value='确定']")).click();
//     driver.findElement(By.xpath("//button[contains(.,'发布')]")).click();
//     driver.quit();
//  }
  @Test
  public void fachangwen() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\\\geckodriver.exe");
	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
      WebDriver driver = new FirefoxDriver(); 
      driver.manage().window().maximize();
      driver.get("http://10.7.10.7/task/list/");
      driver.findElement(By.name("username")).sendKeys("952184149@qq.com");
      driver.findElement(By.name("password")).sendKeys("323841");
      driver.findElement(By.xpath("//button[@id='submit']")).click();
      driver.findElement(By.xpath("//a[contains(@href,'/u/gossip/')]")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//a[@class='gossip-create-article']")).click();
      Thread.sleep(3000);
      Set<String> awh=driver.getWindowHandles();
      if(!awh.isEmpty()) {
    	  for(String handle:awh) {
    		  if(driver.switchTo().window(handle).getPageSource().contains("发布长文")) {
    			  JavascriptExecutor js=(JavascriptExecutor)driver;
    				WebElement wb=driver.findElement(By.xpath("//input[@accept='image/*']"));
    				js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",wb,"style","display:block");	
    				wb.sendKeys("G:\\东西1\\成图\\新建图4.jpg");
    				driver.findElement(By.xpath("//input[@maxlength='32']")).sendKeys("标题");
    				Thread.sleep(3000);
    				 driver.findElement(By.id("cke_6_text")).click();
    				 driver.findElement(By.className("cke_wysiwyg_frame")).click();
    			      driver.findElement(By.tagName("body")).sendKeys("发长文");
    			     // driver.findElement(By.xpath("//button[@class='btn article-preview']")).click();
    			      driver.findElement(By.xpath("//input[@type='submit']")).click();
    			      driver.quit();
    		  }
    	  }
      }
    }


  
}
