package tijiao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class xiugai {
//  @Test
//  public void xiugaizuoye() throws InterruptedException {
// 	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\\\geckodriver.exe");
//  	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//        WebDriver driver = new FirefoxDriver(); 
//        driver.manage().window().maximize();
//        driver.get("http://10.7.10.7/task/list/");
//        driver.findElement(By.name("username")).sendKeys("952184149@qq.com");
//        driver.findElement(By.name("password")).sendKeys("323841");
//        driver.findElement(By.xpath("//button[@id='submit']")).click();
//        driver.findElement(By.xpath("//a[@href='/task/list/finished/']")).click();
//        driver.findElement(By.xpath("//i[@class='icon icon-file-text']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.className("cke_wysiwyg_frame")).click();
//        driver.findElement(By.tagName("body")).sendKeys("�޸���ҵ");
//        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm td-preview']")).click();
//        driver.findElement(By.xpath("//button[@class='btn btn-primary td-submit']")).click();
//        Thread.sleep(3000);
//        driver.quit();
//  }
  @Test
  public void xiugaizuoye1() throws InterruptedException {
 	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\\\geckodriver.exe");
  	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver(); 
        driver.manage().window().maximize();
        driver.get("http://10.7.10.7/task/list/");
        driver.findElement(By.name("username")).sendKeys("952184149@qq.com");
        driver.findElement(By.name("password")).sendKeys("323841");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        driver.findElement(By.xpath("//a[@href='/task/list/finished/']")).click();
        driver.findElement(By.xpath("//i[@class='icon icon-file-text']")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("cke_combo_button")).click();
        //driver.findElement(By.className("cke_wysiwyg_frame")).click();
        /*�����޸�*/
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[contains(.,'��������')]")).click();
        driver.findElement(By.className("cke_dialog_ui_input_textarea")).sendKeys("javaxiugai");
        driver.findElement(By.xpath("//a[@title='ȷ��']")).click();
        driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary btn-sm td-preview')]")).click();
        driver.findElement(By.xpath("//button[contains(.,'ȷ���ύ')]")).click();
        Thread.sleep(3000);
        driver.quit();
 }
//  
//  @Test
//  public void xiugaizuoye3() throws InterruptedException {
// 	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\\\geckodriver.exe");
//  	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//        WebDriver driver = new FirefoxDriver(); 
//        driver.manage().window().maximize();
//        driver.get("http://10.7.10.7/task/list/");
//        driver.findElement(By.name("username")).sendKeys("952184149@qq.com");
//        driver.findElement(By.name("password")).sendKeys("323841");
//        driver.findElement(By.xpath("//button[@id='submit']")).click();
//        driver.findElement(By.xpath("//a[@href='/task/list/finished/']")).click();
//        driver.findElement(By.xpath("//i[@class='icon icon-file-text']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.className("taskdetailAttachmentInput")).sendKeys("C:\\Users\\dell\\Desktop\\tijiaozuoye.txt");
//        driver.findElement(By.className("cke_wysiwyg_frame")).click();
//        driver.findElement(By.tagName("body")).sendKeys("�޸���ҵ");
//        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm td-preview']")).click();
//        driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary td-submit')]")).click();
//        Thread.sleep(3000);
//        driver.quit();
//  }
//	@Test
//  public void dingwei() throws InterruptedException {
// 	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\\\geckodriver.exe");
//  	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//        WebDriver driver = new FirefoxDriver(); 
//        driver.manage().window().maximize();
//        driver.get("http://10.7.10.7/task/list/");
//        driver.findElement(By.name("username")).sendKeys("952184149@qq.com");
//        driver.findElement(By.name("password")).sendKeys("323841");
//        driver.findElement(By.xpath("//button[@id='submit']")).click();
//        driver.findElement(By.xpath("//i[@class='icon icon-bell']")).click();
//        driver.findElement(By.xpath("//a[@href='/notifications/at/']")).click();
//  }
}

	