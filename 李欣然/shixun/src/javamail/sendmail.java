package javamail;

public class sendmail {
	public static void main(String[] args){   
        //这个类主要是设置邮件   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.qq.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);    
     mailInfo.setUserName("952184149@qq.com");    
     mailInfo.setPassword("cciadxsvqeiubfcb");//您的邮箱密码   
     mailInfo.setFromAddress("952184149@qq.com");    
     mailInfo.setToAddress("952184149@qq.com");    
     mailInfo.setSubject("实训测试报告");    
     mailInfo.setContent("发送成功");    
        //这个类主要来发送邮件   
     SimpleMailSender sms = new SimpleMailSender();   
         sms.sendTextMail(mailInfo);//发送文体格式   
         sms.sendHtmlMail(mailInfo);//发送html格式 
     
   }  
}
