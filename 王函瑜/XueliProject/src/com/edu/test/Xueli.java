package com.edu.test;



import java.io.IOException;



import org.testng.annotations.Test;



import com.edu.core.BaseTest;



//@Listeners({ WebTestListener.class })

public class Xueli extends BaseTest{



	@Test

	public void course()throws InterruptedException, IOException{

		//打开雪梨

		

		webtest.open("http://10.7.10.7/");

		Thread.sleep(1000);

		//登录账号

		webtest.click("xpath=//a[contains(.,'登录')]");

		webtest.type("xpath=//input[@name='username']","hua8@qq.com");

		webtest.type("xpath=//input[@name='password']","LAla852");

		webtest.click("xpath=//button[contains(.,'登录')]");

		

		//点击同步课

		webtest.click("xpath=//a[@href='/team/']");

		

		//申请加入同步课

		

		webtest.click("xpath=//button[@data-team='a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-a-']");

		webtest.type("xpath=//input[@maxlength='20']","测试");

		webtest.click("xpath=//button[contains(.,'申请加入')]");

		

		//进入具体同步课申请加入

		webtest.click("xpath=//h1[contains(.,'大学俄语')]");

		webtest.click("xpath=//button[contains(.,'申请加入')]");

		webtest.type("xpath=//input[@maxlength='20']","测试");

		webtest.click("xpath=//button[@class='btn btn-primary apply-now']");

		

		//关注同步课成员

		webtest.click("xpath=//span[contains(.,' 成员')]");

		webtest.click("xpath=//h5[@title='老师']");

		webtest.click("xpath=//button[@id='id_fans']");

		

		//搜索同步课

		webtest.type("xpath=//input[@name='q']","wegr");

		webtest.click("xpath=//button[@class='btn btn-default']");

		

		//查看已加入的同步课【新注册的号里没有已加入的同步课，换一个号才能看见】

		webtest.click("xpath=//a[contains(.,'首页')]");

		webtest.click("xpath=//a[@href='/u/teams/']");

		webtest.click("xpath=//h1[contains(.,'wegr')]");

		webtest.click("xpath=//span[contains(.,' 互动')]");

		

		//插入话题

		webtest.click("xpath=//a[@title='插入#话题#']");

		webtest.click("xpath=//button[contains(.,'发布')]");

		

//		driver.close();	

	}

//	

//	//检测来访次数正确性【定义一个全局变量，保存数据，再操作一次，比较是否相同】

//	@Test

//	public void num() {

//		WebDriver driver=new FirefoxDriver();

//		driver.findElement(By.xpath("//a[@href='/team/']")).click();

//		driver.findElement(By.xpath("//h1[contains(.,'wegr')]")).click();

//		driver.findElement(By.xpath("//span[contains(.,' 成员')]")).click();

//		driver.findElement(By.xpath("//h5[@title='老师']")).click();

//		

//	}

	

	//社区的功能测试

//	@Test

//	public void talk() throws InterruptedException {

//		//打开雪梨

//		System.setProperty("webdriver.gecko.driver", "F:\\qudong\\geckodriver.exe");

//		System.setProperty("webdriver.firefox.bin", "F:\\firefox\\firefox.exe");

//		WebDriver driver=new FirefoxDriver();

//		driver.manage().window().maximize();

//		driver.get("http://10.7.10.7/");

//		Thread.sleep(1000);

//		//登录账号

//		driver.findElement(By.xpath("//a[contains(.,'登录')]")).click();

//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("5@126.com");

//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("LAla852");

//		driver.findElement(By.xpath("//button[contains(.,'登录')]")).click();

//		//点击社区

//		driver.findElement(By.xpath("//a[contains(.,'社区')]")).click();

//		//点击文章

//		driver.findElement(By.className("article-title")).click();

//		//收藏

//		driver.findElement(By.className("favorite")).click();

//		//取消收藏

//		driver.findElement(By.className("favorite")).click();

//		//转发

//		driver.findElement(By.className("forward")).click();

//		driver.findElement(By.xpath("//form[@class='forward-form']")).sendKeys("测试");

//		driver.findElement(By.xpath("//button[contains(.,'转发')]"));

//		//评论

//		driver.findElement(By.xpath("//div[@class='article-gossip']")).sendKeys("测试");

//		driver.findElement(By.xpath("//button[contains(.,'评论')]")).click();

//		//点赞

//		driver.findElement(By.xpath("//a[@class='like']")).click();

//	}

	

}

//package com.edu.test;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import com.edu.core.BaseTest;
//import com.edu.models.Login_Action;
// 
///*
// * author:wangjuan
// * 同步课申请
// * 关注他人
// */
//
//
//
//public class Xueli extends BaseTest{
//
//	Login_Action action;
//	static int a;
//	
//	@BeforeMethod
//	public void setup()
//	{
//		action=new Login_Action(webtest);
//		
//	}
//
//	@Test
//	public void course()throws InterruptedException{
//		//打开雪梨
//		System.setProperty("webdriver.gecko.driver", "E:\\Java\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.bin", "F:\\Firefox\\firefox.exe");
//		WebDriver driver=new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.get("http://10.7.10.7/");
//		Thread.sleep(1000);
//		//登录账号
//		driver.findElement(By.xpath("//a[contains(.,'登录')]")).click();
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("du@qq.com");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Zhen0820");
//		driver.findElement(By.xpath("//button[contains(.,'登录')]")).click();
//		
//		//点击同步课
//		driver.findElement(By.xpath("//a[@href='/team/']")).click();
//		Thread.sleep(2000);
//		//申请加入同步课
//		driver.findElement(By.xpath("//button[@data-team='20']")).click();
//		driver.findElement(By.xpath("//input[@maxlength='20']")).sendKeys("测试");
//		driver.findElement(By.xpath("//button[contains(.,'申请加入')]")).click();
//		
//		Thread.sleep(2000);
//		//进入具体同步课申请加入
//		driver.findElement(By.xpath("//h1[contains(.,'大学俄语')]")).click();
//		driver.findElement(By.xpath("//button[contains(.,'申请加入')]")).click();
//		driver.findElement(By.xpath("//input[@maxlength='20']")).sendKeys("测试");
//		driver.findElement(By.xpath("//button[@class='btn btn-primary apply-now']")).click();
//		Thread.sleep(2000);
//		//关注同步课成员
//		driver.findElement(By.xpath("//span[contains(.,' 成员')]")).click();
//		driver.findElement(By.xpath("//h5[@title='老师']")).click();
//		driver.findElement(By.xpath("//button[@id='id_fans']")).click();
//		Thread.sleep(2000);
//		//搜索同步课
//		driver.findElement(By.xpath("//input[@id='q']")).sendKeys("wegr");
//		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
//		Thread.sleep(3000);
//		//查看已加入的同步课【新注册的号里没有已加入的同步课，换一个号才能看见】
//		driver.findElement(By.xpath("//a[contains(.,'首页')]")).click();
//		driver.findElement(By.xpath("//a[@href='/u/teams/']")).click();
//		driver.findElement(By.xpath("//h1[contains(.,'wegr')]")).click();
//		driver.findElement(By.xpath("//span[contains(.,' 互动')]")).click();
//		Thread.sleep(2000);
//		//插入话题
//		driver.findElement(By.xpath("//a[@title='插入#话题#']")).click();
//		driver.findElement(By.xpath("//button[contains(.,'发布')]")).click();
//		Thread.sleep(2000);
//		driver.close();
//		
//	}
////	
////	//检测来访次数正确性【设一个全局变量，保存数据，再操作一次，比较是否相同】
////	@Test
////	public void num() {
////		WebDriver driver=new FirefoxDriver();
////		driver.findElement(By.xpath("//a[@href='/team/']")).click();
////		driver.findElement(By.xpath("//h1[contains(.,'wegr')]")).click();
////		driver.findElement(By.xpath("//span[contains(.,' 成员')]")).click();
////		driver.findElement(By.xpath("//h5[@title='老师']")).click();
////		
////	}
//	
//	//社区的功能测试
////	@Test
////	public void talk() throws InterruptedException {
////		//打开雪梨
////		System.setProperty("webdriver.gecko.driver", "F:\\qudong\\geckodriver.exe");
////		System.setProperty("webdriver.firefox.bin", "F:\\firefox\\firefox.exe");
////		WebDriver driver=new FirefoxDriver();
////		driver.manage().window().maximize();
////		driver.get("http://10.7.10.7/");
////		Thread.sleep(1000);
////		//登录账号
////		driver.findElement(By.xpath("//a[contains(.,'登录')]")).click();
////		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("5@126.com");
////		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("LAla852");
////		driver.findElement(By.xpath("//button[contains(.,'登录')]")).click();
////		//点击社区
////		driver.findElement(By.xpath("//a[contains(.,'社区')]")).click();
////		//点击文章
////		driver.findElement(By.className("article-title")).click();
////		//收藏
////		driver.findElement(By.className("favorite")).click();
////		//取消收藏
////		driver.findElement(By.className("favorite")).click();
////		//转发
////		driver.findElement(By.className("forward")).click();
////		driver.findElement(By.xpath("//form[@class='forward-form']")).sendKeys("测试");
////		driver.findElement(By.xpath("//button[contains(.,'转发')]"));
////		//评论
////		driver.findElement(By.xpath("//div[@class='article-gossip']")).sendKeys("测试");
////		driver.findElement(By.xpath("//button[contains(.,'评论')]")).click();
////		//点赞
////		driver.findElement(By.xpath("//a[@class='like']")).click();
////	}
//	
//}
