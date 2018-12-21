package com.webtest.demo;


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
	public Login_Action action=null;
	
	@BeforeClass//是说每个测试方法之前要 初始化一次action
	public void setup()
	{
		action=new Login_Action(webtest);
//		System.out.println("实例化action");
	}
	@Test(description="测试登录成功界面",dataProvider="excel",dataProviderClass=NSDataProvider.class,priority=0)
	public void loginSuccess1(String a,String b)
	{
		action.login(a,b);
		webtest.ifContains("同步课");
		
	}

//	@Test(description="测试创建同步课成功界面",dataProvider="cctxt",dataProviderClass=NSDataProvider.class,priority=1)
//	public void create_class(String a,String b,String c)
//	{
//		for(int i=1;i<=3;i++) {
//			action.CreateClass(a, b, c);
//			webtest.ifContains("发布任务");
//		}
//	}
	
	@Test(description="申请同步课的同学通过审核",priority=2)
	public void through_audit() throws InterruptedException
	{
//		webtest.mouseLong();
//		action.throughSelectAudit("zpx");
//		action.throughAllAudit();
		action.throughAllAudit();
		System.out.println("qq");
	}
//	@Test(description="查看左侧菜单栏的通知和课程",priority=3)
//	public void checkandclass()
//	{
//		action.checkandclassAction();
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
//	
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
	
//	@Test(description="测试登录成功界面",dataProvider="txt",dataProviderClass=NSDataProvider.class,priority=0)
//	public void loginSuccess(String a,String b) {
////		action=new Login_Action(webtest);
//		action.login(a,b);
//		webtest.isTextPresent("首页");
////		"913884616@qq.com""654321xiangshang"
//	}
	
//	@Test(priority=1)
//	public void create_class()
//	{
//		webtest.open("http://10.7.10.7/u/teams/");
//		webtest.click("class=create-button");
//		webtest.type("id=id_name","课程11");
//		webtest.tapClick();
//		//上传同步课图标
//		webtest.type("name=icon","C:\\Users\\zhen\\Desktop\\timg.jpg");
//		webtest.click("id=id_check_type_1");
//		webtest.type("class=ke-edit-iframe","课程11的简介");
//		webtest.click("//input[contains(@id,'1')]");
//		webtest.typeAndClear("id=id_grade_average_percent","10");
//		webtest.click("id=submit");
//		if (webtest.ifContains("当前同步课已经存在，请更换名称"))
//			webtest.typeAndClear("id=id_name","新"+"课程11");
//			webtest.click("id=submit");
//	}
	
//	@Test(priority=1)
//	public void create_class()
//	{
//		action.CreateClass("课程2", "课程2", "10");
//		webtest.ifContains("发布任务");
//	}
}
