package com.chars.muguildbusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.chars.muguildbusiness.dto.NotificationEmail;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(NotificationEmail notificationEmail) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			
			messageHelper.setFrom("myemail@etc.com");
			messageHelper.setSubject(notificationEmail.getSubject());
			messageHelper.setTo(notificationEmail.getRecipient());
			messageHelper.setText(notificationEmail.getBody());
		};
			try {
				mailSender.send(messagePreparator);
			} catch (MailException e) {
				throw new RuntimeException("Exception ocurred when sending mail to "
						+ notificationEmail.getRecipient(), e);
			}
		
	}
	
	
	
	
	
	
	
	
	
}
