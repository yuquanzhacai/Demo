package javamail;

public class sendmail {
	public static void main(String[] args){   
        //�������Ҫ�������ʼ�   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.qq.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);    
     mailInfo.setUserName("952184149@qq.com");    
     mailInfo.setPassword("cciadxsvqeiubfcb");//������������   
     mailInfo.setFromAddress("952184149@qq.com");    
     mailInfo.setToAddress("952184149@qq.com");    
     mailInfo.setSubject("ʵѵ���Ա���");    
     mailInfo.setContent("���ͳɹ�");    
        //�������Ҫ�������ʼ�   
     SimpleMailSender sms = new SimpleMailSender();   
         sms.sendTextMail(mailInfo);//���������ʽ   
         sms.sendHtmlMail(mailInfo);//����html��ʽ 
     
   }  
}
