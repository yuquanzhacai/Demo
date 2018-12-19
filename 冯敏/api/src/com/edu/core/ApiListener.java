package com.edu.core;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

public class ApiListener extends TestListenerAdapter{
	
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
		
		//把测试结果美化
		//把测试结果发送邮件
	}

}
