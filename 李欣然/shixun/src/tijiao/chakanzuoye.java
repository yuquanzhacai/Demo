package tijiao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class chakanzuoye {
  @Test
  public void chakan() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\\\geckodriver.exe");
	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
      WebDriver driver = new FirefoxDriver(); 
      driver.manage().window().maximize();
      driver.get("http://10.7.10.7/task/list/");
      driver.findElement(By.name("username")).sendKeys("952184149@qq.com");
      driver.findElement(By.name("password")).sendKeys("323841");
      driver.findElement(By.xpath("//button[@id='submit']")).click();
      driver.findElement(By.xpath("//a[@href='/task/list/checked/']")).click();
      driver.findElement(By.xpath("//i[@class='icon icon-eye-open']")).click();
      Thread.sleep(3000);
      driver.quit();
  }
}
