package aaacom;



import com.webtest.core.WebDriverEngine;


public class Login {
//    	System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
//    	System.setProperty("webdriver.firefox.bin","D:\\firefox\\firefox.exe");
//    	WebDriver driver=new FirefoxDriver();
//    	driver.get("http://10.7.10.7/login/");
//    	driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("2784038315@qq.com ");	
//    	driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Zhen0820");
//    	driver.findElement(By.xpath("//button[@id='submit']")).click();

	private WebDriverEngine webtest;
	public Login(WebDriverEngine webtest) {
		this.webtest=webtest;			
	}
	public void login(String username,String password) {
		webtest.type("id=id_usename", username);
		webtest.type("id=id_password", password);
		webtest.click("xpath=//button[@id='submit']");
	}
//	@Test(description="日志文件")
//	public void cc() {
//		Reporter.log("登录成功");
//		Assert.assertTrue(true);
//	}
}
