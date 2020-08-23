package br.com.saudesempre.api.config;


import java.util.Arrays;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.saudesempre.api.entities.Contato;
import br.com.saudesempre.api.entities.InfomacoesMedicas;
import br.com.saudesempre.api.entities.Medicamento;
import br.com.saudesempre.api.entities.Usuario;
import br.com.saudesempre.api.repositories.ContatoRepository;
import br.com.saudesempre.api.repositories.InfoMedicaRepository;
import br.com.saudesempre.api.repositories.MedicamentoRepository;
import br.com.saudesempre.api.repositories.UsuarioRepository;

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

	@Override
	public void run (String... args) throws Exception {
		
		
		
		Usuario usu1 = new Usuario(null, "Usuario Numero 1", "usuario1.gmail.com", 
				"https://www.workana.com/i/wp-content/uploads/2019/02/ab-testing-split-min.jpg");
		Usuario usu2 = new Usuario(null, "Usuario Numero 2 ", "usuario2.i@gmail.com",
				"https://www.workana.com/i/wp-content/uploads/2019/02/ab-testing-split-min.jpg");
		
		Medicamento med1 = new Medicamento(null, "Ibuprofeno", 234234, "Antiflamatorio");
		Medicamento med2 = new Medicamento(null, "Medicamento2", 32423, "teste");
		
		InfomacoesMedicas info1 = new InfomacoesMedicas(null, "Informações MEdicas 1", "info medica 1 ", "01-08-2020");
		InfomacoesMedicas info2 = new InfomacoesMedicas(null, "Informação Medica numero 2", "info num 2", "20-05-2021");
		
		Contato cont1 = new Contato(null, "Contato numero 1 ", "576567");
		Contato cont2 = new Contato(null, "Contato numero 2", "34234");
		
	
		
		usuarioRepository.saveAll(Arrays.asList(usu1,usu2));
		medicamentoRepository.saveAll(Arrays.asList(med1,med2));
		infoMedicaRepository.saveAll(Arrays.asList(info1, info2));
		contatoRepository.saveAll(Arrays.asList(cont1,cont2));
		
		
	}
	}
