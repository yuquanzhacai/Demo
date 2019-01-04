package aaacom;

import java.io.IOException;
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

    static String from = "冯敏";

    static String user = "2680326511@qq.com";
<<<<<<< HEAD
    static String password = "tljzxmmobydrebhb";
=======
    static String password = "nsnwmwvqgyijeaii";
>>>>>>> 4c8c38473de561f95f2a2630e1721d377664a99e
    static String file=nihao();
    



    public static void sendEmail(String email, String subject, String body) throws IOException {
    	
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", server);
            props.put("mail.smtp.port", String.valueOf(port));
            props.put("mail.smtp.auth", "true");
            Transport transport = null;
            Session session = Session.getDefaultInstance(props,null);
            transport = session.getTransport("smtp");
            transport.connect(server, user, password);
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
            msg.setContent(body, "text/html;charset=utf-8");
            
//            MimeMultipart message = new MimeMultipart();
//    		MimeBodyPart message2=new MimeBodyPart();
//    	    message2.attachFile(file);		  
//    	    message.addBodyPart(message2);
//    	    Transport.send(msg);
            
   //创建一个MimeBodyPart的对象，以便添加内容
    		
    		//MimeBodyPart对象,存放附件
    		BodyPart mimeBodyPart=new MimeBodyPart();
    		// 设置邮件中附件文件的路径
//    		String filename = PicSend.Zip();
    		//创建一个datasource对象，并传递文件
    		DataSource source = new FileDataSource(file);
    		//设置handler
    		mimeBodyPart.setDataHandler(new DataHandler(source));
    		//加载文件
    		mimeBodyPart.setFileName(file);
            
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
<<<<<<< HEAD
            MimeMultipart message = new MimeMultipart();
    		MimeBodyPart message2=new MimeBodyPart();
    	    message2.attachFile(file);		  
    	    message.addBodyPart(message2);
    	    Transport.send(msg);
=======
     
            
>>>>>>> 4c8c38473de561f95f2a2630e1721d377664a99e
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static String nihao(){  
<<<<<<< HEAD
        ZipCompressor zc = new  ZipCompressor("D:\\eclipse-workspace\\AAA\\test-output\\test.zip");  
        zc.compressExe("D:\\eclipse-workspace\\AAA\\test-output");
        String file="test.zip";
=======
        ZipCompressor zc = new  ZipCompressor("D:\\eclipse-workspace\\AAA\\test.zip");  
        zc.compressExe("D:\\eclipse-workspace\\AAA\\test-output\\html");
        String file="D:\\eclipse-workspace\\AAA\\test.zip";
>>>>>>> 4c8c38473de561f95f2a2630e1721d377664a99e
        return file;
    }
	

	
	
    
//    public static void main(String args[]) throws UnsupportedEncodingException
//    {
//    	
//    	MailUtil.sendEmail("2680326511@qq.com", "ceshi", "ce");
//		if(System.getProperty("os.name").contains("w"))
//		{
//			System.out.println(System.getProperty("os.name"));
//			System.out.println("ok");
//		} 
//        
//    }
//
}
