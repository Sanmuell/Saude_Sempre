package br.com.saudesempre.api.config;

import java.io.IOException;
import java.util.Arrays;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import br.com.saudesempre.api.entities.Contato;
import br.com.saudesempre.api.entities.InfomacoesMedicas;
import br.com.saudesempre.api.entities.Medicamento;
import br.com.saudesempre.api.entities.Usuario;
import br.com.saudesempre.api.repositories.ContatoRepository;
import br.com.saudesempre.api.repositories.InfoMedicaRepository;
import br.com.saudesempre.api.repositories.MedicamentoRepository;
import br.com.saudesempre.api.repositories.UsuarioRepository;
import br.com.saudesempre.api.service.EmailService;
import br.com.saudesempre.api.service.SmtpEmailService;

@Configuration // anotation indicando que é uma classe de Configuração
@Profile("dev")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@Autowired
	private InfoMedicaRepository infoMedicaRepository;

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void run(String... args) throws IOException {

		Usuario usu1 = new Usuario(null, "Usuario Numero 1", "usuario1.gmail.com",
				"https://www.workana.com/i/wp-content/uploads/2019/02/ab-testing-split-min.jpg");
		Usuario usu2 = new Usuario(null, "Usuario Numero 2 ", "usuario2.i@gmail.com",
				"https://www.workana.com/i/wp-content/uploads/2019/02/ab-testing-split-min.jpg");

		Medicamento med1 = new Medicamento(null, "Ibuprofeno", 234234, "Antiflamatorio");
		Medicamento med2 = new Medicamento(null, "Medicamento2", 32423, "teste");

		InfomacoesMedicas info1 = new InfomacoesMedicas(null, "Informações MEdicas 1", "info medica 1 ", "01-08-2020");
		InfomacoesMedicas info2 = new InfomacoesMedicas(null, "Informação Medica numero 2", "info num 2", "20-05-2021");

		Contato cont1 = new Contato(null, "PESSOA IMPORTANTE", "234234", "sanmuell.i@gmail.com");
		Contato cont2 = new Contato(null, "Contato numero 2","465456", "rosinha.myjesus@gmail.com");



		/*
		 * Email from = new Email("sanmuell.i@gmail.com"); String subject =
		 * "Sending with SendGrid is Fun"; Email to = new Email("sanmuell.i@gmail.com");
		 * Content content = new Content("text/plain", cont1.getNome()); Mail mail = new
		 * Mail(from, subject, to, content);
		 * 
		 * SendGrid sg = new SendGrid(
		 * "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");
		 * Request request = new Request(); try { request.setMethod(Method.POST);
		 * request.setEndpoint("mail/send"); request.setBody(mail.build()); Response
		 * response = sg.api(request); System.out.println(response.getStatusCode());
		 * System.out.println(response.getBody());
		 * System.out.println(response.getHeaders());
		 * 
		 */

		usuarioRepository.saveAll(Arrays.asList(usu1, usu2));
		medicamentoRepository.saveAll(Arrays.asList(med1, med2));
		infoMedicaRepository.saveAll(Arrays.asList(info1, info2));
		contatoRepository.saveAll(Arrays.asList(cont1, cont2));

		// } catch (IOException ex) {
		// throw ex;

//	}

	//	System.out.println("Sending Email...");

		//System.out.println("Done");
		
	}

		@Bean
		public EmailService emailService() {
			return new SmtpEmailService();
	}

}
