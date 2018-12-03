package demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.BaseTest;
import core.WebTestListener;
import demo.Login_Action;
@Listeners({WebTestListener.class})
public class test extends BaseTest{

	Login_Action action;
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}
	@Test
	public void test1() throws Exception  {
		webtest.open("http://10.7.10.7/task/list/");
		action.login("952184149@qq.com", "323841");
		action.tijiaozuoye("提交作业");
	}
	@Test
	public void test2() throws Exception  {
		webtest.open("http://10.7.10.7/task/list/");
		action.login("952184149@qq.com", "323841");
		action.shangchuanfujian("C:\\Users\\dell\\Desktop\\tijiaozuoye.txt");
		action.tijiaozuoye("提交作业");
	}
	@Test
	public void test3() throws Exception  {
		webtest.open("http://10.7.10.7/task/list/");
		action.login("952184149@qq.com", "323841");
		action.tijiaodaima("java");
		action.tijiaozuoye("提交作业");
	}	
	@Test
	public void test4() {		
		webtest.open("http://10.7.10.7/task/list/");
		action.login("952184149@qq.com", "323841");
	    action.chakanzuoye();
	}
	@Test
	public void test5() throws InterruptedException {
		webtest.open("http://10.7.10.7/task/list/");
		action.login("952184149@qq.com", "323841");
	    action.xiugaizuoye("修改作业");
	}
	@Test
	public void test6() throws InterruptedException {
		webtest.open("http://10.7.10.7/task/list/");
		action.login("952184149@qq.com", "323841");
	    action.xiugaifujian("C:\\Users\\dell\\Desktop\\tijiaozuoye.txt");
	}
	@Test
	public void test7() throws InterruptedException {
		webtest.open("http://10.7.10.7/task/list/");
 		action.login("952184149@qq.com", "323841");
		action.xiugaidaima("javaxiugai");
	}
}
