/* Recurso correspondente à entidade "InformacaoMedica" 
 * Fornece dois recursos para recuperar todos os usuário cadastrados ou por Id 
 */

package br.com.saudesempre.api.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import br.com.saudesempre.api.entities.InfomacoesMedicas;
import br.com.saudesempre.api.repositories.InfoMedicaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/saude-sempre")
@Api(value = "API REST Informações Medicas")
@CrossOrigin(origins = "*") // Qualquer domínio pode acessar a API
public class InfomacoesMedicasResource {

	@Autowired
	private InfoMedicaRepository infoMedicaRepository;

	@GetMapping("/informacoesMedicas")
	@ApiOperation(value = "Lista todas as  informações medicas")
	public List<InfomacoesMedicas> listarInformacaoMedicas() {
		return infoMedicaRepository.findAll();
	}

	

// -------------- método de buscar por id------------------------
	@GetMapping("/informacoesMedicas/{id}")
	@ApiOperation(value = "Busca uma informação por ID")
	public ResponseEntity<InfomacoesMedicas> buscar(@Valid @PathVariable Long id) {
		Optional<InfomacoesMedicas> informacoesMedicas = infoMedicaRepository.findById(id);

		if (informacoesMedicas.isPresent()) {// se tem algo dentro do infoMedica
			return ResponseEntity.ok(informacoesMedicas.get()); // retorna a resposta 200 e o corpo retorna o infoMedica.get
		}

		return ResponseEntity.notFound().build(); // se der errado, retorna 404

	}

// --------------CADASTRO DE CLIENTE- POST -------------------------

	@PostMapping("/informacoesMedicas")
	@ApiOperation(value = "Adiciona uma informação")
	@ResponseStatus(HttpStatus.CREATED)
	public InfomacoesMedicas adicionarInformacaoMedica(@Valid @RequestBody InfomacoesMedicas informacoesMedicas) {
		return infoMedicaRepository.save(informacoesMedicas);
	}

	
	
	@PutMapping("/informacoesMedicas/{id}")
	@ApiOperation(value = "Atualiza uma informação por ID")
	public ResponseEntity<InfomacoesMedicas> atualizar(@Valid @PathVariable Long id, @RequestBody InfomacoesMedicas informacoesMedicas) {
		if (!infoMedicaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();

		}

		informacoesMedicas.setId(id);
		informacoesMedicas = infoMedicaRepository.save(informacoesMedicas);

		return ResponseEntity.ok(informacoesMedicas);

	}

	@DeleteMapping("/informacoesMedicas/{id}")
	@ApiOperation(value = "Deleta uma informação por ID")
// como não vai retornar nenhum corpo, retornará void.
	public ResponseEntity<Void> remover( @PathVariable Long id) {
		if (!infoMedicaRepository.existsById(id)) { // se não existe, retorne 404
			return ResponseEntity.notFound().build();
		}

		infoMedicaRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
