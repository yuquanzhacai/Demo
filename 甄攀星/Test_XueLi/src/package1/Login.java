package package1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.action.Login_Action;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

import com.webtest.core.WebTestListener;

//@Listeners({ WebTestListener.class })
public class Login extends BaseTest{
	private static final boolean fasle = false;
	public Login_Action action=null;
	
	@BeforeClass//是说每个测试方法之前要 初始化一次action
	public void setup()
	{
		action=new Login_Action(webtest);
//		System.out.println("实例化action");
	}
	
//	@Test(description="测试登录成功界面",dataProvider="txt",dataProviderClass=NSDataProvider.class,priority=0)
//	public void loginSuccess(String a,String b) {
////		action=new Login_Action(webtest);
//		action.login(a,b);
//		webtest.isTextPresent("首页");
////		"913884616@qq.com""654321xiangshang"
//	}
	@BeforeClass
	public void before_Login() throws InterruptedException {
		//打开页面
		webtest.open("http://10.7.10.7/login");
		//文本框输入
		webtest.type("name=username","2784038315@qq.com");
		webtest.type("name=password","Zhen0820");
		webtest.click("xpath://button[@type='submit']");
	}
//	(description="测试登录成功界面",dataProvider="excel",dataProviderClass=NSDataProvider.class,priority=0)
//	String a,String b
	@Test
	public void loginSuccess1()
	{
//		action.login(a,b);
		WebDriver driver=new FirefoxDriver();
		driver.get("http://10.7.10.7/u/teams/");
		driver.findElement(By.className("notification-box")).click();
		driver.findElement(By.className("icon icon-bookmark")).click();
		driver.findElement(By.className("check-all check-btn")).click();
		driver.findElement(By.id("btn-accepted-all")).click();		
	}
	@Test(dependsOnMethods="loginSuccess1",enabled=fasle)
	public void through() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://10.7.10.7/u/teams/");
//		driver.findElement(By.xpath("//span[@class='notification-box']"));
//		driver.findElement(By.xpath("//a[@href='/u/teams/applications/']"));
//		driver.findElement(By.className("notification-box")).click();
//		icon icon-bookmark
//		driver.findElement(By.xpath("//span[@id='application-count']"));
//		driver.findElement(By.xpath("//i[@class='icon-check-empty']"));
//		driver.findElement(By.xpath("//button[contains(.,'批量通过')]"));
	}
}
//	@Test(description="测试创建同步课成功界面",dataProvider="cctxt",dataProviderClass=NSDataProvider.class,priority=0)
//	public void create_class(String a,String b,String c)
//	{
//		action.login("2784038315","Zhen0820");
////		webtest.type("name=username","2784038315@qq.com");
////		webtest.type("name=password","Zhen0820");
//		action.CreateClass(a, b, c);
//		webtest.ifContains("发布任务");
//	}
//	
//	@Test
//	public void loginFail() {
//		action=new Login_Action(webtest);
//		action.login("913884616@qq.com", "654321xiangshang*");
//		webtest.isChecked("");
//		webtest.isDisplayed("");
//		webtest.isElementPresent("");
//		webtest.selectByVisibleText("", "");
//	}
	
	
	
//	@Test
//	public void test_login()
//	{
//		webtest.open("http://www.edu2act.net/login/");
////		System.out.println(action);
////		action.login("913884616@qq.com","654321xiangshang");
//
//		webtest.type("name=username","913884616@qq.com");
//		webtest.type("name=password","654321xiangshang");
//		webtest.click("id=submit");
//	}

