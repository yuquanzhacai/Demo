package aaacom;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

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
    static String password = "tljzxmmobydrebhb";
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
            msg.saveChanges();
            transport.sendMessage(msg, msg.getAllRecipients());
            MimeMultipart message = new MimeMultipart();
    		MimeBodyPart message2=new MimeBodyPart();
    	    message2.attachFile(file);		  
    	    message.addBodyPart(message2);
    	    Transport.send(msg);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static String nihao(){  
        ZipCompressor zc = new  ZipCompressor("D:\\eclipse-workspace\\AAA\\test-output\\test.zip");  
        zc.compressExe("D:\\eclipse-workspace\\AAA\\test-output");
        String file="test.zip";
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
