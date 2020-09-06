package br.com.saudesempre.api.service;

import org.springframework.mail.SimpleMailMessage;

//import br.com.saudesempre.api.entities.Medicamento;
import br.com.saudesempre.api.entities.Usuario;

public interface EmailService {

void enviarDadosDoUsuario(Usuario obj);
	
	void sendEmail(SimpleMailMessage msg);
}
