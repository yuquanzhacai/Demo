package com.edu.core;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.edu.utils.ReadPro;

public class ApiListener extends TestListenerAdapter{
	

	FreemarkerTemplateEngine ft=new FreemarkerTemplateEngine();

	public ApiListener() {
		super();
	}
	
	private String writeResultToMailTemplate()
	{
		ITestNGMethod method[]=this.getAllTestMethods();
		List failedList=this.getFailedTests();
		List passedList=this.getPassedTests();
		
		
		List failedList1=new ArrayList();
		List passedList1=new ArrayList();
		for(int j=0;j<failedList.size();j++)
		{
			ITestResult tr=(ITestResult) failedList.get(j);
			for(int i=0;i<method.length;i++)
			{
				if(tr.getMethod().getMethodName().equals(method[i].getMethodName()))
				{
					if(method[i].getDescription()!=null)
					{
						tr.setAttribute("name", method[i].getDescription());
					}
					else
					{
						tr.setAttribute("name", "");
					}
					break;
				}
			}
			failedList1.add(tr);
		}
		for(int j=0;j<passedList.size();j++)
		{
			ITestResult tr=(ITestResult) passedList.get(j);
			for(int i=0;i<method.length;i++)
			{
				if(tr.getMethod().getMethodName().equals(method[i].getMethodName()))
				{
					if(method[i].getDescription()!=null)
					{
						tr.setAttribute("name", method[i].getDescription());
					}
					else
					{
						tr.setAttribute("name", "");
					}
					break;
				}
			}
			passedList1.add(tr);
		}
		Map context=new HashMap();
    	context.put("date", new Date());
        context.put("failedList",failedList);   
        context.put("passedList",passedList); 
        context.put("casesize",passedList.size()+failedList.size()); 
        context.put("failcasesize",failedList.size());
        try {
			String content=ft.run(context);
			return content;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);


			if(ReadPro.getPropValue("enable_email").equals("true"))
			{
				String emailContent=this.writeResultToMailTemplate();
				String emailTitle="测试报告----"+this.getTime();
				String toMail=ReadPro.getPropValue("to_mail");
				String file=PicSend.Zip();
				
					if(this.getFailedTests()!=null&&this.getFailedTests().size()>0)
					{
						try {
							MailUtil.sendEmail(toMail,emailTitle, emailContent,file);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Log.info("email send to "+toMail+" success");
					}else
					{
						try {
							MailUtil.sendEmail(ReadPro.getPropValue("success_to_mail"),emailTitle, emailContent,file);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Log.info("email send to "+ReadPro.getPropValue("success_to_mail")+" success");
					}
				} 

		
	
	}
	


    public String getTime()
    {
    	java.util.Calendar c=java.util.Calendar.getInstance();    
        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");    
       	return  f.format(c.getTime());    
    }
}
