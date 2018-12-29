package com.webtest.core;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

public class WebTestListener2 implements IReporter{
	/*@Override
	public void onTestStart(ITestResult tr) {
		
	}*/
	@Override
	public void generateReport(List<XmlSuite> xmlSuites,List<ISuite> suites, String outputDirectory) {
		
	}
}
