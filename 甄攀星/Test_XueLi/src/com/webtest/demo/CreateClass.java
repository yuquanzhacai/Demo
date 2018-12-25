package com.webtest.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.action.CreateClass_Action;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class CreateClass extends BaseTest{
	public CreateClass_Action action=null;
	@BeforeMethod//是说每个测试方法之前要 初始化一次action
	public void setup()
	{
		action=new CreateClass_Action(webtest);
	}
	@Test(description="测试创建同步课成功界面",dataProvider="cctxt",dataProviderClass=NSDataProvider.class,priority=1)
	public void create_class(String a,String b,String c) throws InterruptedException
	{
//		for(int i=1;i<=3;i++) {
			action.CreateClass(a, b, c);
			webtest.ifContains("发布任务");
//		}
	}
}
