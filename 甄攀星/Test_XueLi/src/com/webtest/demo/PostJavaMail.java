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
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;

public class PostJavaMail {
//	
//	public static MimeMessage createSimpleMail(Session session) throws AddressException, MessagingException
//	{
////		//附件1
////		MimeBodyPart bodypart1=new MimeBodyPart();
////		//附件2
////		MimeBodyPart bodypart2=new MimeBodyPart();
////		//正文内容
////		MimeBodyPart content=new MimeBodyPart();
////		MimeMultipart msgMultipart=new  MimeMultipart("mixed");
////		msgMultipart.addBodyPart(bodypart1);
////		msgMultipart.addBodyPart(content);
//		String subject="html test";
//		MimeMessage msg=new MimeMessage(session);
//		//设置发件人
//		msg.setFrom(new InternetAddress("913884616@qq.com"));
//		//设置收件人
//		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("913884616@qq.com"));		//设置发送日期
//		msg.setSentDate(new Date());
//		//设置邮件主题
//		msg.setSubject(subject);
//		//创建一个MimeBodyPart的对象，以便添加内容
//		BodyPart mimeBodyPart=new MimeBodyPart();
//		//添加HTML格式邮件正文
////		mimeBodyPart.setContent(body,"text/html;charset=gb2312");
//		//纯文本正文
//		String body2="dewfeqr";
//		mimeBodyPart.setText(body2);
//		//MimeBodyPart对象2,存放附件
//		BodyPart mimeBodyPart2=new MimeBodyPart();
//		// 设置邮件中附件文件的路径
//		String filename = "D:\\demo\\loginuser.txt";
////		创建一个datasource对象，并传递文件
//		DataSource source = new FileDataSource(filename);
////		设置handler
//		mimeBodyPart2.setDataHandler(new DataHandler(source));
////		 加载文件
//		mimeBodyPart2.setFileName(filename);
////		 创建一个MimeMultipart类的实例对象
//		MimeMultipart mimeMultipart=new MimeMultipart();
//		MimeMultipart msgMultipart=new  MimeMultipart("mixed");
//		// 添加正文内容
//		msgMultipart.addBodyPart(mimeBodyPart);
//		msgMultipart.addBodyPart(mimeBodyPart2);
//		Transport.send(msg);
//		return msg;
//		
//	}
	public static void main(String[] args) throws GeneralSecurityException, MessagingException
	{
		 Properties props = new Properties();
		 	props.setProperty("mail.debug", "true");
	        //设置邮件服务器主机名
		 	props.setProperty("mail.host", "smtp.qq.com");
	        //发送邮件服务器主机名
		 	props.setProperty("mail.transport.protocol", "smtp");
	        //发送邮件需要身份验证
	        props.setProperty("mail.smtp.auth", "true");
	        //开启ＳＳＬ加密，否则会失败
	        MailSSLSocketFactory sf=new MailSSLSocketFactory();
	       sf.setTrustAllHosts(true);
	       props.put("mail.smtp.ssl.enable","true");
	       props.put("mall.smtp.ssl.socketFactory", sf);
	       //创建session
	        Session session = Session.getInstance(props);
	        //通过session得到transport对象
	        Transport ts=session.getTransport();
	        //连接邮件服务器：邮箱类型，帐号，授权码代替密码
	        ts.connect("smtp.qq.com","913884616@qq.com","zkckelpxnxhdbaja");
	        //创建邮件
	        Message message=createSimpleMail(session);
	        //发送邮件
	        ts.sendMessage(message, message.getAllRecipients());
	        ts.close();
//	       Session session=Session.getInstance(props,new Authenticator() {
//		    	protected PasswordAuthentication getPasswordAuthentication() {
//		    		return new PasswordAuthentication("913884616@qq.com","zkckelpxnxhdbaja");
//		    	}
//		    });
//	       Message message=createSimpleMail(session);
	       
	       
	       
	    
	}
	public static MimeMessage createSimpleMail(Session session) throws AddressException, MessagingException
	{
//		创建邮件对象
		MimeMessage message=new MimeMessage(session);
//		指明邮件的发件人
		message.setFrom(new InternetAddress("913884616@qq.com"));
		//指明邮件的收件人，现在发件人和收件人是一样的
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("913884616@qq.com"));
		//邮件的标题
		message.setSubject("JavaMail测试");
		//邮件的文本内容
		message.setContent("JavaMail发送邮件成功！","text/html;charset=UTF-8");
		//返回创建号的邮件对象
		return message;
		
	}

}
