package com.webtest.core;

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

import org.testng.annotations.Test;
 
public class SendEmail {
 
	@Test
	public void sebd() {
		
		// 设置邮件
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
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("1336448191@qq.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("1336448191@qq.com"));
			message.setSubject("测试报告");
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("正文部分");
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename = ".\\test-output\\index.html";
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
 
		}
 
	}
 
}

