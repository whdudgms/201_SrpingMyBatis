package com.feb.jdbc.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.feb.jdbc.dto.EmailDto;

public class EmailUtil {
	
	
	@Autowired
	private JavaMailSender mailSender;
	
	public EmailUtil(JavaMailSender mailSender)
	{
		this.mailSender = mailSender;
	}	
	
	public String sendMail(EmailDto email) {
		try {
			System.out.println("mailSender :" + mailSender);
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"UTF-8");
			messageHelper.setTo(email.getReceiver());
			messageHelper.setText(email.getText());
			messageHelper.setFrom(email.getFrom());
			messageHelper.setSubject(email.getSubject());
			
			mailSender.send(message);
			
		
	}catch(Exception e) {
		System.out.println(e);
		return "Error";
	}
	return "Success";
	
	}	
}