package demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.BaseTest;
import demo.Login_Action;
public class test extends BaseTest{

	Login_Action action;
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}

//	@Test
//	public void test1() throws Exception  {
//		webtest.open("http://10.7.10.7/task/list/");
//		action.login("952184149@qq.com", "323841");
//		System.out.print("登陆成功");
//		action.tijiaozuoye("提交作业");
//	}
//	@Test
//	public void test2() throws Exception  {
//		webtest.open("http://10.7.10.7/task/list/");
//		action.login("952184149@qq.com", "323841");
//		System.out.print("登陆成功");
//		action.shangchuanfujian("C:\\Users\\dell\\Desktop\\tijiaozuoye.txt");
//		System.out.print("上传附件");
//		action.tijiaozuoye("提交作业");
//	}
	@Test
	public void test3() throws Exception  {
		webtest.open("http://10.7.10.7/task/list/");
		action.login("952184149@qq.com", "323841");
		System.out.print("登陆成功");
		action.tijiaodaima("java");
		//action.tijiaozuoye("提交作业");
	}	
}
