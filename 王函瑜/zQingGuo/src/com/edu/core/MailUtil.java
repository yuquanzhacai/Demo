package com.edu.core;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class MailUtil {
	static int port = 25;

    static String server = "smtp.qq.com";
    static String file=PicSend.Zip();
    static String from = "王函瑜";
    static String user = "2798011643@qq.com";
    static String password = "asysdorgmwguddej";

    



    public static void sendEmail(String email, String subject, String body,String file) throws UnsupportedEncodingException {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", server);
            props.put("mail.smtp.port", String.valueOf(port));
            props.put("mail.smtp.auth", "true");
            Transport transport = null;
            Session session = Session.getDefaultInstance(props,null);
            transport = session.getTransport("smtp");
            transport.connect(user, password);
            MimeMessage msg = new MimeMessage(session);
            msg.setSentDate(new Date());
            
            InternetAddress fromAddress = new InternetAddress(user,from,"UTF-8");
            msg.setFrom(fromAddress);
            String emailList[]=email.split(",");
            InternetAddress[] toAddress = new InternetAddress[emailList.length];
            
            for(int i=0;i<emailList.length;i++)
            {
            	toAddress[i]=new InternetAddress(emailList[i]);
            }
            //msg.setRecipients(Message.RecipientType.TO, toAddress);
            msg.addRecipients(Message.RecipientType.TO, toAddress);
            msg.setSubject(subject, "UTF-8");              
          //创建一个MimeBodyPart的对象，以便添加内容    		
    		//MimeBodyPart对象,存放附件
    		BodyPart mimeBodyPart=new MimeBodyPart();
    		// 设置邮件中附件文件的路径
    		String filename = Zip();
    		//创建一个DataSource对象，并传递文件
    		DataSource source = new FileDataSource(filename);
    		//设置handler
    		mimeBodyPart.setDataHandler(new DataHandler(source));
    		//加载文件
    		mimeBodyPart.setFileName(filename);        
    		//创建一个MimeBodyPart的对象，以便添加内容
    		BodyPart mimeBodyPart2=new MimeBodyPart();
    		//添加HTML格式邮件正文
    		mimeBodyPart2.setContent(body,"text/html;charset=utf-8");
    		
    		// 创建一个MimeMultipart类的实例对象
    		MimeMultipart mimeMultipart=new MimeMultipart();
    		// 添加正文内容
    		mimeMultipart.addBodyPart(mimeBodyPart);
    		mimeMultipart.addBodyPart(mimeBodyPart2);
    		// 设置内容
    		msg.setContent(mimeMultipart);
            msg.saveChanges();
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

//    public static String getTime()
//    {
//    	java.util.Calendar c=java.util.Calendar.getInstance();    
//        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyyMMdd");    
//       	return  f.format(c.getTime());    
//    }
    
    public static String Zip() {
        ZipCompressor zc = new  ZipCompressor("D:\\测试报告.zip");  
        zc.compressExe("E:\\Java\\work\\XueliProject2\\test-output\\html");
        String file = "D:\\测试报告.zip";
        return file;
     }

}
