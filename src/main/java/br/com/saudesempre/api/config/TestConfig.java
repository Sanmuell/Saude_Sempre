package br.com.saudesempre.api.config;


import java.util.Arrays;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



import br.com.saudesempre.api.entities.InfoMedica;
import br.com.saudesempre.api.entities.Medicamento;
import br.com.saudesempre.api.entities.Usuario;
import br.com.saudesempre.api.repositories.InfoMedicaRepository;
import br.com.saudesempre.api.repositories.MedicamentoRepository;
import br.com.saudesempre.api.repositories.UsuarioRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@Autowired
	private InfoMedicaRepository infoMedicaRepository;

	@Override
	public void run (String... args) throws Exception {
		
		
		
		Usuario usu1 = new Usuario(null, "Sanmuell", "sanmuell.i@gmail.com", null);
		Usuario usu2 = new Usuario(null, "Outro", "outro.i@gmail.com",
				"https://www.workana.com/i/wp-content/uploads/2019/02/ab-testing-split-min.jpg");
		
		Medicamento med1 = new Medicamento(null, "Ibuprofeno", 234234, "Antiflamatorio", usu1);
		Medicamento med2 = new Medicamento(null, "Dipirona", 4234, "Analgesico", usu2);
		
		InfoMedica info1 = new InfoMedica(null, "Titulo da Descrição do Remedio", "Descrição do Remedio", usu1);
		
	
		
		usuarioRepository.saveAll(Arrays.asList(usu1,usu2));
		medicamentoRepository.saveAll(Arrays.asList(med1,med2));
		infoMedicaRepository.saveAll(Arrays.asList(info1));
		
		
	}
	}
