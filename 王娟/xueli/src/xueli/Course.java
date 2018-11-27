package xueli;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

public class Course {
		@Test
		public void course()throws InterruptedException{
			//打开雪梨
			System.setProperty("webdriver.gecko.driver", "F:\\qudong\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "F:\\firefox\\firefox.exe");
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://10.7.10.7/");
			Thread.sleep(1000);
			//登录账号
			driver.findElement(By.xpath("//a[contains(.,'登录')]")).click();
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("741852@qq.com");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("LAla852");
			driver.findElement(By.xpath("//button[contains(.,'登录')]")).click();
			
			//点击同步课
			driver.findElement(By.xpath("//a[@href='/team/']")).click();
			//申请加入同步课
			driver.findElement(By.xpath("//button[@data-team='da-xue-ying-yu']")).click();
			driver.findElement(By.xpath("//input[@maxlength='20']")).sendKeys("测试");
			driver.findElement(By.xpath("//button[contains(.,'申请加入')]")).click();
			Thread.sleep(1000);
			//进入具体同步课
			driver.findElement(By.xpath("//h1[contains(.,'2016雪梨实训项目')]")).click();
			driver.findElement(By.xpath("//span[contains(.,' 成员')]")).click();
			driver.findElement(By.xpath("//h5[@title='8-甄攀星']")).click();
			driver.findElement(By.xpath("//button[@id='id_fans']")).click();
			Thread.sleep(1000);
			//搜索同步课
			driver.findElement(By.xpath("//input[@id='q']")).sendKeys("大学英语");
			driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
			Thread.sleep(1000);
//			//查看已加入的同步课
//			driver.findElement(By.xpath("//a[contains(.,'首页')]")).click();
//			driver.findElement(By.xpath("//a[@href='/u/teams/']")).click();
//			driver.findElement(By.xpath("//p[contains(.,'中国近代史')]")).click();
//			driver.findElement(By.xpath("//span[contains(.,' 互动')]")).click();
//			//插入话题
//			driver.findElement(By.xpath("//a[@title='插入#话题#']")).click();
//			driver.findElement(By.xpath("//button[contains(.,'发布')]")).click();
			
		}
		
		@Test
		public void mail() {
			
			// 创建一个Property文件对象
			Properties props = new Properties();
	 
			// 设置邮件服务器的信息，这里设置smtp主机名称
			props.put("mail.smtp.host", "smtp.qq.com");
	 
			// 设置socket factory 的端口
			props.put("mail.smtp.socketFactory.port", "465");
	 
			// 设置socket factory
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	 
			// 设置需要身份验证
			props.put("mail.smtp.auth", "true");
	 
			// 设置SMTP的端口，QQ的smtp端口是25
			props.put("mail.smtp.port", "25");
	 
			// 身份验证实现
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	 
				protected PasswordAuthentication getPasswordAuthentication() {
	                        // 第二个参数，就是我QQ开启smtp的授权码
				return new PasswordAuthentication("2402370100@qq.com", "dphmoghxcmvvdjge");
	 
				}
	 
			});
	 
			try {
	 
				// 创建一个MimeMessage类的实例对象
				Message message = new MimeMessage(session);
	 
				// 设置发件人邮箱地址
				message.setFrom(new InternetAddress("2402370100@qq.com"));
	 
				// 设置收件人邮箱地址
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("2402370100@qq.com"));
	            
	            // 设置邮件主题
				message.setSubject("测试报告");
	 
				// 创建一个MimeBodyPart的对象，以便添加内容
				BodyPart messageBodyPart1 = new MimeBodyPart();
	 
				// 设置邮件正文内容
				messageBodyPart1.setText("正文部分");
	 
				// 创建另外一个MimeBodyPart对象，以便添加其他内容
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
	 
				// 设置邮件中附件文件的路径
				String filename = ".\\test-output\\index.html";
	 
				// 创建一个datasource对象，并传递文件
				DataSource source = new FileDataSource(filename);
	 
				// 设置handler
				messageBodyPart2.setDataHandler(new DataHandler(source));
	 
				// 加载文件
				messageBodyPart2.setFileName(filename);
	 
				// 创建一个MimeMultipart类的实例对象
				Multipart multipart = new MimeMultipart();
	 
				// 添加正文1内容
				multipart.addBodyPart(messageBodyPart1);
	 
				// 添加正文2内容
				multipart.addBodyPart(messageBodyPart2);
	 
				// 设置内容
				message.setContent(multipart);
	 
				// 最终发送邮件
				Transport.send(message);
	 
				System.out.println("=====邮件已经发送=====");
	 
			} catch (MessagingException e) {
	 
				   throw new RuntimeException(e);
	 
			}
	 
		}
		
}
