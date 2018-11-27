package tijiao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class tijiaozuoye  {
  @Test
  public void tijiao() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\\\geckodriver.exe");
	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
      WebDriver driver = new FirefoxDriver(); 
      driver.manage().window().maximize();
      driver.get("http://10.7.10.7/task/list/");
      driver.findElement(By.name("username")).sendKeys("952184149@qq.com");
      driver.findElement(By.name("password")).sendKeys("323841");
      driver.findElement(By.xpath("//button[@id='submit']")).click();
      driver.findElement(By.xpath("//i[@class='icon icon-edit']")).click();
      Thread.sleep(3000);
      driver.findElement(By.className("cke_wysiwyg_frame")).click();
      driver.findElement(By.tagName("body")).sendKeys("提交作业");
      driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm td-preview']")).click();
      driver.findElement(By.xpath("//button[@class='btn btn-primary td-submit']")).click();
      Thread.sleep(30000);
      driver.quit();
  }
    @Test
    public void tijiao1() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\\\geckodriver.exe");
	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
      WebDriver driver = new FirefoxDriver(); 
      driver.manage().window().maximize();
      driver.get("http://10.7.10.7/task/list/");
      driver.findElement(By.name("username")).sendKeys("952184149@qq.com");
      driver.findElement(By.name("password")).sendKeys("323841");
      driver.findElement(By.xpath("//button[@id='submit']")).click();
      driver.findElement(By.xpath("//a[@href='#id-description-form-1688']")).click();
      driver.findElement(By.className("taskdetailAttachmentInput")).sendKeys("C:\\Users\\dell\\Desktop\\tijiaozuoye.txt");
      Thread.sleep(3000);
      driver.findElement(By.className("cke_wysiwyg_frame")).click();
      driver.findElement(By.tagName("body")).sendKeys("提交作业");
      driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm td-preview']")).click();
      driver.findElement(By.xpath("//button[@class='btn btn-primary td-submit']")).click();
      Thread.sleep(30000);
      driver.quit();
  }
    @Test
    public void tijiao2() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\\\geckodriver.exe");
	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
      WebDriver driver = new FirefoxDriver(); 
      driver.manage().window().maximize();
      driver.get("http://10.7.10.7/task/list/");
      driver.findElement(By.name("username")).sendKeys("952184149@qq.com");
      driver.findElement(By.name("password")).sendKeys("323841");
      driver.findElement(By.xpath("//button[@id='submit']")).click();
      driver.findElement(By.xpath("//a[@href='#id-description-form-1688']")).click();
      Thread.sleep(3000);
      driver.findElement(By.className("cke_wysiwyg_frame")).click();
      driver.findElement(By.className("cke_button__codesnippet")).click();
      driver.findElement(By.xpath("//option[@value='java']")).click();
      driver.findElement(By.xpath("//textarea[@class='cke_dialog_ui_input_textarea cke_source']")).click();
      driver.findElement(By.className("cke_dialog_ui_input_textarea")).sendKeys("java");
      driver.findElement(By.xpath("//span[contains(.,'确定')]")).click();
      driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm td-preview']")).click();
      driver.findElement(By.xpath("//button[@class='btn btn-primary td-submit']")).click();
      Thread.sleep(30000);
      driver.quit();
      
  }

}
