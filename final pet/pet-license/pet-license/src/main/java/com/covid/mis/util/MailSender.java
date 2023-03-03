package com.covid.mis.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class MailSender {

	public Boolean sendMail(String to, String subject,String body)
	{
	
	  String result;
	  String from="egovdolg@gmail.com";
	  String host = "smtp.gmail.com";
	  Properties properties = System.getProperties();
	  properties.setProperty("mail.transport.protocol", "smtp");     
	  properties.setProperty("mail.smtp.host", host);
	  properties.put("mail.smtp.auth", "true");  
	  properties.put("mail.smtp.port", "465");  
	  properties.put("mail.debug", "true");  
	  properties.put("mail.smtp.socketFactory.port", "465");  
	  properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	  properties.put("mail.smtp.socketFactory.fallback", "false");
	  properties.put("mail.smtp.ssl.enable", "true");
	  Session mailSession = Session.getDefaultInstance(properties,  
	   new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {  
	      return new PasswordAuthentication("egovdolg@gmail.com","egov2017"); 
	  }});  
	  try {

	  Transport transport = mailSession.getTransport();  
	  InternetAddress addressFrom = new InternetAddress(from);  
	  MimeMessage message = new MimeMessage(mailSession);  
	  message.setSender(addressFrom);  
	  message.setSubject(subject);  
	  message.setContent(body, "text/plain");  
	  message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

	  transport.connect();  
	  Transport.send(message);  
	  transport.close();
	  return true;	
	  } 
	  catch (MessagingException mex) {
	     mex.printStackTrace();
	     result = "Error: unable to send message....";
	     System.out.print(result + mex);
	   return false;
	  }
	}

	
}
