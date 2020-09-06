package br.com.saudesempre.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

//import br.com.saudesempre.api.entities.Medicamento;
import br.com.saudesempre.api.entities.Usuario;

public abstract class AbstractEmailService implements EmailService {

	@Value("${spring.mail.username}")
	private String sender;
	
	@Override
	public void enviarDadosDoUsuario(Usuario obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromUsuario(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromUsuario(Usuario obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Email com descrição dos medicamentos");
		//sm.setSentDate(new);
		sm.setText(obj.getMedicamento().getDescricao());
		return null;
	}
}
