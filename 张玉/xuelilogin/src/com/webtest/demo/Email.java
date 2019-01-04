package com.webtest.demo;


import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

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

public class Email{

	//���ͱ�������
	@Test
	public static void mail() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		// �����֤
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("1336448191@qq.com", "dtxyecxyvqodhdef");
			}
		});

		try {

			// �����շ�
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("1336448191@qq.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("1336448191@qq.com"));
			message.setSubject("���Ա���","GB2312");
			BodyPart messageBodyPart1 = new MimeBodyPart();
			//messageBodyPart1.setText("���Ĳ���");
			messageBodyPart1.setContent("���Ĳ���", "text/html;charset=GB2312");
			
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename = ".\\test-output\\index1.html";
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
			message.setContent(multipart);
			//����
			Transport.send(message);
			System.out.println("=====�ʼ��Ѿ�����=====");

		} catch (MessagingException e) {

			   throw new RuntimeException(e);

		}
	}
}