package com.webtest.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

/**
 * author:lihuanzhen
 * 初始化浏览器
 */


public class BaseTest {

	public  WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;

	
	

	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;
	 if (driverType.equalsIgnoreCase("firefox")) {
		    String firefox_driver =ReadProperties.getPropertyValue("gecko_driver");
			String firefox_path = ReadProperties.getPropertyValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();

			Log.info("Using Firefox");
		}  else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = ReadProperties.getPropertyValue("chrome_path");
			System.setProperty("webdriver.chrome.driver",chrome_path);
			driver = new ChromeDriver();
			Log.info("Using Chrome");
			
		}else{
			return null;
		}

		
		return driver;

	
	}


	


	@BeforeSuite
	public void doBeforeSuite(ITestContext context) throws Exception {
		TestRunner runner = (TestRunner) context;
	    runner.addListener(new WebTestListener());
		
		driverType=ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
	}



	@AfterSuite
	public void doAfterMethod() throws InterruptedException {
		//关闭网页
		if(this.driver != null){
			this.driver.quit();
			}
		Log.info("Quitted Browser");
		
		
		/*//发邮件
				//设置邮件
						Properties props = new Properties();
						props.put("mail.smtp.host", "smtp.qq.com");
						props.put("mail.smtp.socketFactory.port", "465");
						props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
				 
						// 身份验证
						props.put("mail.smtp.auth", "true");
						props.put("mail.smtp.port", "25");
						Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				 
							protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("1336448191@qq.com", "dtxyecxyvqodhdef");
							}
						});
				 
						try {
				 
							// 设置收发
							MimeMessage message = new MimeMessage(session);
							message.setFrom(new InternetAddress("1336448191@qq.com"));
							message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("1336448191@qq.com"));
							message.setSubject("测试报告","GB2312");
							BodyPart messageBodyPart1 = new MimeBodyPart();
							//messageBodyPart1.setText("正文部分");
							messageBodyPart1.setContent("正文部分", "text/html;charset=GB2312");
							
							MimeBodyPart messageBodyPart2 = new MimeBodyPart();
							String filename = ".\\test-output\\index1.html";
							DataSource source = new FileDataSource(filename);
							messageBodyPart2.setDataHandler(new DataHandler(source));
							messageBodyPart2.setFileName(filename);
							Multipart multipart = new MimeMultipart();
							multipart.addBodyPart(messageBodyPart1);
							multipart.addBodyPart(messageBodyPart2);
							message.setContent(multipart);
							//发送
							Transport.send(message);
							System.out.println("=====邮件已经发送=====");
				 
						} catch (MessagingException e) {
				 
							   throw new RuntimeException(e);
				 
						}*/
	}
	

	

	
	public WebDriver getDriver() {
        return driver;
    }


	

}
