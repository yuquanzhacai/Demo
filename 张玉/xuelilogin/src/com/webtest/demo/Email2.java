package com.webtest.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//��ʱ��(��ʱѭ������)
    public class Email2 implements ServletContextListener{
        private Timer timer = null;
        public void contextDestroyed(ServletContextEvent event) {
             timer.cancel();
             event.getServletContext().log("��ʱ������");
        }  
       
        @Override
        public void contextInitialized(ServletContextEvent event) {
             //�������ʼ������������tomcat������ʱ�����������������������ʵ�ֶ�ʱ������
             timer = new Timer(true);
             event.getServletContext().log("��ʱ��������");//�����־������tomcat��־�в鿴��
             //����exportHistoryBean��0��ʾ�������ӳ٣�1*1000��ʾÿ��1��ִ������60*1000��ʾһ���ӣ�
             timer.schedule(new SendMail(event.getServletContext()),0,60*1000*60);
        }
    }


class SendMail extends java.util.TimerTask  {
        
        private ServletContext context = null;
        public SendMail(ServletContext context)
        {
         this.context = context;
        }

        public void run() {
        Properties prop = new Properties();  
        prop.put("mail.host","smtp.qq.com");//������ʹ�÷��ʼ��ĵ��������������ʹ�õ���163�ķ�����
        prop.put("mail.transport.protocol", "smtp");//�����ʼ�Э������
        prop.put("mail.smtp.auth","true"); //��������ͨ����֤
          
        try {
            //ʹ��JavaMail�����ʼ���5������  
            //1������session  
            Session session = Session.getInstance(prop);  
            //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬  
            session.setDebug(true);  
            //2��ͨ��session�õ�transport����  
            Transport ts = session.getTransport();  
            //3��ʹ��������û���������(����step��������Ȩ��)�����ʼ���������  
            ts.connect("smtp.qq.com", "1336448191@qq.com", "dtxyecxyvqodhdef");
            //4�������ʼ�����������  
            Message message = createAttachMail(session);  
            //5�������ʼ�  
            ts.sendMessage(message, message.getAllRecipients());  
            ts.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        
        
        }    
    
    //����һ������������ʼ�  
    public static MimeMessage createAttachMail(Session session) throws Exception {  
        //�����ʼ�����  
        MimeMessage message = new MimeMessage(session);  
        //ָ���ʼ��ķ�����  
        message.setFrom(new InternetAddress("1336448191@qq.com"));
        //ָ���ʼ����ռ���
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1336448191@qq.com"));  
        //�ʼ��ı���  
        message.setSubject("���Ա���");  
          
        //�����ʼ����ģ�Ϊ�˱����ʼ����������������⣬��Ҫʹ��charset=UTF-8ָ���ַ�����  
        MimeBodyPart text = new MimeBodyPart();  
        String mailText = "�����ġ�";  
        text.setContent(mailText, "text/html;charset=UTF-8");  
        //�����ʼ�����  
        MimeBodyPart attach = new MimeBodyPart();  
        DataHandler dh = new DataHandler(new FileDataSource(".\\test-output\\index1.html"));  
        attach.setDataHandler(dh);  
        attach.setFileName(dh.getName());  
          
          
        //���������������ݹ�ϵ
        MimeMultipart mp = new MimeMultipart();  
        mp.addBodyPart(text);  
        mp.addBodyPart(attach);  
        mp.setSubType("mixed");
        message.setContent(mp);
        message.saveChanges();  
          
        //���ش����õ��ʼ�����  
        System.out.println(message);  
        return message;  
   
    }  
}

