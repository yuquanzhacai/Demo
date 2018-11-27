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

public class MailClass {
	
	public void send_Text(String address,String subjects,String message) throws AddressException, MessagingException {

		String from="2798011643@qq.com";
		String to=address;
		String subject=subjects;
		String body=message;
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
		msg.setText(message);
//		//创建一个MimeBodyPart的对象，以便添加内容
//		BodyPart mimeBodyPart=new MimeBodyPart();
//		//纯文本正文
//		mimeBodyPart.setText(body);
//		// 创建一个MimeMultipart类的实例对象
//		MimeMultipart mimeMultipart=new MimeMultipart();
//		// 添加正文内容
//		mimeMultipart.addBodyPart(mimeBodyPart);
//		// 设置内容
//	    msg.setContent(mimeMultipart);
		// 最终发送邮件
		Transport.send(msg);
	}

	public void send_Html(String address,String subjects,String message) throws AddressException, MessagingException {
		String from="2798011643@qq.com";
		String to="2798011643@qq.com";
		String subject=subjects;
		String body=message;
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
		// 创建一个MimeMultipart类的实例对象
		MimeMultipart mimeMultipart=new MimeMultipart();
		// 添加正文内容
		mimeMultipart.addBodyPart(mimeBodyPart);
		// 设置内容
	    msg.setContent(mimeMultipart);
		// 最终发送邮件
		Transport.send(msg);
	}

	public void send_File(String address,String subjects,String file) throws AddressException, MessagingException {
		String from="2798011643@qq.com";
		String to=address;
		String subject=subjects;
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
		//MimeBodyPart对象,存放附件
		BodyPart mimeBodyPart=new MimeBodyPart();
		// 设置邮件中附件文件的路径
		String filename = file;
		// 创建一个datasource对象，并传递文件
		DataSource source = new FileDataSource(filename);
		//设置handler
		mimeBodyPart.setDataHandler(new DataHandler(source));
		// 加载文件
		mimeBodyPart.setFileName(filename);
		// 创建一个MimeMultipart类的实例对象
		MimeMultipart mimeMultipart=new MimeMultipart();
		// 添加正文内容
		mimeMultipart.addBodyPart(mimeBodyPart);
		// 设置内容
		msg.setContent(mimeMultipart);
		// 最终发送邮件
		Transport.send(msg);
	}
	
    public void send_TextFile(String address,String subjects,String message,String file) throws AddressException, MessagingException {
		String from="2798011643@qq.com";
		String to=address;
		String subject=subjects;
		String body=message;
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
		//纯文本正文
		mimeBodyPart.setText(body);
		//MimeBodyPart对象2,存放附件
		BodyPart mimeBodyPart2=new MimeBodyPart();
		// 设置邮件中附件文件的路径
		String filename = file;
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
	
	public void send_HtmlFile(String address,String subjects,String message,String file) throws AddressException, MessagingException {
		String from="2798011643@qq.com";
		String to=address;
		String subject=subjects;
		String body=message;
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
		//MimeBodyPart对象2,存放附件
		BodyPart mimeBodyPart2=new MimeBodyPart();
		// 设置邮件中附件文件的路径
		String filename = file;
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
