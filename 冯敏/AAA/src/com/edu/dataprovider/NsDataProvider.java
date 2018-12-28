package com.edu.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NsDataProvider {

	
	@DataProvider(name="txt")
	public  Object[][] getTxtData() throws IOException{
		return new  TxtDataProvider().getTxtUser(".\\data\\user.txt");
	}
	@Test(description="发布任务",dataProvider="txt")
	 public void addRenwu(String title,String point,String time) {	
	System.out.println(title+" "+point+" "+time);
	}
	@DataProvider(name="teacher")
	public  Object[][] getTeacherData() throws IOException{
		return new  TxtDataProvider().getTxtUser(".\\data\\teacher.cvs");
	}
	
	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data/user.xlsx","Sheet1");
	}
	
	@DataProvider(name="mysql")
	public Object[][] getMysqlDada() throws IOException{
		return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + 
				"FROM `mm_movie` ");
	}
	
}
