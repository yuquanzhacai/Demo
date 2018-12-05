package com.webtest.demo;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import com.sun.mail.util.MailSSLSocketFactory;

public class PostMailHtml {
	@Test
	public void  send_file() throws GeneralSecurityException, MessagingException
	{
		String from="913884616@qq.com";
		String to="913884616@qq.com";
		String body="<!DOCTYPE html><html><head><h>附件测试</h></head></html>";
		String subject="html test";
		String port="25";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host","smtp.qq.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", port);
		MailSSLSocketFactory sf=new MailSSLSocketFactory();
	    sf.setTrustAllHosts(true);
	    props.put("mail.smtp.ssl.enable","true");
	    props.put("mall.smtp.ssl.socketFactory", sf);
		//创建Session实例对象
	    Session session=Session.getInstance(props,new Authenticator() {
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication(from,"zkckelpxnxhdbaja");
	    	}
	    });
//		Session session = Session.getInstance(props, new Authenticator() {
//
//				protected PasswordAuthentication getPasswordAuthentication() {
//					Session session = Session.getInstance(props, new Authenticator() {
//
//						protected PasswordAuthentication getPasswordAuthentication() {
//
//		})
//		Session session = Session.getInstance(props);
//		Transport ts=session.getTransport();
//		ts.connect("smtp.qq.com","913884616@qq.com","zkckelpxnxhdbaja");
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
		String body2="dewfeqr";
		mimeBodyPart.setText(body2);
		//MimeBodyPart对象2,存放附件
		BodyPart mimeBodyPart2=new MimeBodyPart();
		// 设置邮件中附件文件的路径
		String filename = "D:\\Program Files\\Demo-eclipse\\Test_XueLi\\test-output\\emailable-report.html";
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
	
}
