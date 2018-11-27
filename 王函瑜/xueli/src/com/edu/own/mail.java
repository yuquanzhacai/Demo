package com.edu.own;



import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import com.webtest.dataprovider.NSDataProvider;



public class mail {

//纯文本格式邮件正文(+html)
	@Test(enabled=false)
	public void send_Text() throws Exception {
		String from="2798011643@qq.com";
		String to="2798011643@qq.com";
		String subject="你是傻孩子嘛";
		String body="放弃吧";
		String body2="<!DOCTYPE html><html><head><title></title><meta charset=\"utf-8\"><style type=\"text/css\">\r\n" + 
				"		#123{font-weight: 100;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"		.456{font-weight: 900;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"	</style></head><body>\r\n" + 
				"<div id=\"123\">\r\n" + 
				"	<div class=\"456\">\r\n" + 
				"		<p>王函瑜黄媛媛冯嘉星冯敏</p>\r\n" + 
				"	</div></div></body></html>";
		String smtpHost = "smtp.qq.com";
		String port="25";
		// 创建一个Property文件对象
		Properties props = new Properties();
		// 使用的协议（JavaMail规范要求）
		props.put("mail.transport.protocol", "smtp");
		// 设置邮件服务器的信息，这里设置smtp主机名称
		props.put("mail.smtp.host", smtpHost);
		// 设置socket factory 的端口
		props.put("mail.smtp.socketFactory.port", "465");
		// 设置socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		// 设置需要身份验证
		props.put("mail.smtp.auth", "true");
		// 设置SMTP的端口，QQ的smtp端口是25
		props.put("mail.smtp.port", port);
		
		//创建Session实例对象
		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
                       // 第二个参数，就是我QQ开启smtp的授权码
			   return new PasswordAuthentication(from, "asysdorgmwguddej");

			}

		});
		
		//Session session = Session.getDefaultInstance(props);
		
		//创建MimeMessage实例对象
		MimeMessage msg=new MimeMessage(session);
		//设置发件人
		msg.setFrom(new InternetAddress(from));
		//设置收件人
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		//设置发送日期
		msg.setSentDate(new Date());
		//设置邮件主题
		msg.setSubject(subject);
		//设置纯文本内容的邮件正文
		msg.setContent(body2, "text/html;charset=UTF-8");
		//msg.setText(body);
		//设置为debug模式，可以查看详细的发送1og
		session.setDebug(true);
		Transport.send(msg);
		  
//		 // 获取Transport对象
//		  Transport transport = session.getTransport("smtp");
//		  // 第2个参数需要填写的是QQ邮箱的SMTP的授权码
//		  transport.connect(from,"asysdorgmwguddej");
//		  // 发送，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
//		  transport.sendMessage(msg, msg.getAllRecipients());
//		  transport.close();
		
		
	
			


	}

//发送HTML格式的邮件正文（+纯文本正文）
	@Test(enabled=false)
	public void send_Html() throws Exception {
		String from="2798011643@qq.com";
		String to="2798011643@qq.com";
		String subject="html test";
		String body="<!DOCTYPE html><html><head><title></title><meta charset=\"utf-8\"><style type=\"text/css\">\r\n" + 
				"		#123{font-weight: 100;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"		.456{font-weight: 900;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"	</style></head><body>\r\n" + 
				"<div id=\"123\">\r\n" + 
				"	<div class=\"456\">\r\n" + 
				"		<p>王函瑜黄媛媛冯嘉星冯敏</p>\r\n" + 
				"	</div></div></body></html>";
		String body2="dewfeqr";
		String smtpHost = "smtp.qq.com";
		String port="25";
		// 创建一个Property文件对象
		Properties props = new Properties();
		// 使用的协议（JavaMail规范要求）
		props.put("mail.transport.protocol", "smtp");
		// 设置邮件服务器的信息，这里设置smtp主机名称
		props.put("mail.smtp.host", smtpHost);
		// 设置socket factory 的端口
		props.put("mail.smtp.socketFactory.port", "465");
		// 设置socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		// 设置需要身份验证
		props.put("mail.smtp.auth", "true");
		// 设置SMTP的端口，QQ的smtp端口是25
		props.put("mail.smtp.port", port);
		
		//创建Session实例对象
		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
                       // 第二个参数，就是我QQ开启smtp的授权码
			   return new PasswordAuthentication(from, "asysdorgmwguddej");

			}

		});
		
		//创建MimeMessage实例对象
		MimeMessage msg=new MimeMessage(session);
		//设置发件人
		msg.setFrom(new InternetAddress(from));
		//设置收件人
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		//设置发送日期
		msg.setSentDate(new Date());
		//设置邮件主题
		msg.setSubject(subject);
		//创建一个MimeBodyPart的对象，以便添加内容
		BodyPart mimeBodyPart=new MimeBodyPart();
		//添加HTML格式邮件正文
		mimeBodyPart.setContent(body,"text/html;charset=gb2312");
		//BodyPart mimeBodyPart2=new MimeBodyPart();
		//纯文本正文
		mimeBodyPart.setText(body2);
		// 创建一个MimeMultipart类的实例对象
		MimeMultipart mimeMultipart=new MimeMultipart();
		// 添加正文内容
		mimeMultipart.addBodyPart(mimeBodyPart);
		//mimeMultipart.addBodyPart(mimeBodyPart2);
		// 设置内容
	    msg.setContent(mimeMultipart);
		// 最终发送邮件
		Transport.send(msg);

	}
	
//发送带附件的邮件	
	@Test(enabled=false)
	public void send_File() throws Exception {
		String from="2798011643@qq.com";
		String to="2798011643@qq.com";
		String subject="html test";
		String body="<!DOCTYPE html><html><head><title></title><meta charset=\"utf-8\"><style type=\"text/css\">\r\n" + 
				"		#123{font-weight: 100;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"		.456{font-weight: 900;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"	</style></head><body>\r\n" + 
				"<div id=\"123\">\r\n" + 
				"	<div class=\"456\">\r\n" + 
				"		<p>王函瑜黄媛媛冯嘉星冯敏</p>\r\n" + 
				"	</div></div></body></html>";
		String body2="dewfeqr";
		String smtpHost = "smtp.qq.com";
		String port="25";
		// 创建一个Property文件对象
		Properties props = new Properties();
		// 使用的协议（JavaMail规范要求）
		props.put("mail.transport.protocol", "smtp");
		// 设置邮件服务器的信息，这里设置smtp主机名称
		props.put("mail.smtp.host", smtpHost);
		// 设置socket factory 的端口
		props.put("mail.smtp.socketFactory.port", "465");
		// 设置socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		// 设置需要身份验证
		props.put("mail.smtp.auth", "true");
		// 设置SMTP的端口，QQ的smtp端口是25
		props.put("mail.smtp.port", port);
		
		//创建Session实例对象
		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
                       // 第二个参数，就是我QQ开启smtp的授权码
			   return new PasswordAuthentication(from, "asysdorgmwguddej");

			}

		});
		
		//创建MimeMessage实例对象
		MimeMessage msg=new MimeMessage(session);
		//设置发件人
		msg.setFrom(new InternetAddress(from));
		//设置收件人
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		//设置发送日期
		msg.setSentDate(new Date());
		//设置邮件主题
		msg.setSubject(subject);
		//创建一个MimeBodyPart的对象，以便添加内容
		BodyPart mimeBodyPart=new MimeBodyPart();
		//添加HTML格式邮件正文
		//mimeBodyPart.setContent(body,"text/html;charset=gb2312");
		//纯文本正文
		mimeBodyPart.setText(body2);
		
		//MimeBodyPart对象2,存放附件
		BodyPart mimeBodyPart2=new MimeBodyPart();
		// 设置邮件中附件文件的路径
		String filename = "G:\\web\\work\\6-2.html";
		// 创建一个datasource对象，并传递文件
		DataSource source = new FileDataSource(filename);
		//设置handler
		mimeBodyPart2.setDataHandler(new DataHandler(source));
		// 加载文件
		mimeBodyPart2.setFileName(filename);

		// 创建一个MimeMultipart类的实例对象
		MimeMultipart mimeMultipart=new MimeMultipart();
		// 添加正文内容
		mimeMultipart.addBodyPart(mimeBodyPart);
		mimeMultipart.addBodyPart(mimeBodyPart2);
		// 设置内容
	    msg.setContent(mimeMultipart);
		// 最终发送邮件
		Transport.send(msg);

	}

	MailClass mc=new MailClass();
	
    @Test(dataProvider="address",dataProviderClass=NSDataProvider.class)
    public void test(String address) throws AddressException, MessagingException {
    	String subjects="123";
    	String file = "G:\\web\\work\\6-2.html";
    	mc.send_File(address, subjects, file);
    }
}
