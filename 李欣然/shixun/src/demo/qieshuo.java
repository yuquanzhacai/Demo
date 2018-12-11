package demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.BaseTest;
import core.WebTestListener;
import demo.Login_Action;
@Listeners({WebTestListener.class})
public class qieshuo extends BaseTest{
		Login_Action action;
		@BeforeMethod
		public void setup()
		{
			action=new Login_Action(webtest);
		}
  @Test
  public void test1() throws InterruptedException {
	  webtest.open("http://10.7.10.7/task/list/");
	  action.login("952184149@qq.com", "323841Lxr");
	  action.pinglun("#我的话题#发表评论");
  }
  @Test
  public void test2() throws InterruptedException {
	  webtest.open("http://10.7.10.7/task/list/");
	  action.login("952184149@qq.com", "323841Lxr");
	  action.pinglundaima("java");
  }
	 @Test
	  public void test3() throws InterruptedException {
		 webtest.open("http://10.7.10.7/task/list/");
		  action.login("952184149@qq.com", "323841Lxr");
		  action.pingluntupian("G:\\东西1\\成图\\新建图4.jpg");
		  }
		 @Test
		  public void test4() throws InterruptedException {
			 webtest.open("http://10.7.10.7/task/list/");
			  action.login("952184149@qq.com", "323841Lxr");
			  action.fachengwen("G:\\东西1\\成图\\新建图4.jpg","标题","正文");
			  }
  
}

