package br.com.saudesempre.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SmtpEmailService extends AbstractEmailService {
	
	@Autowired
	private MailSender mailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		// TODO Auto-generated method stub
		LOG.info("Enviando email...");
		mailSender.send(msg);
		LOG.info("Email enviado");
	}

}
