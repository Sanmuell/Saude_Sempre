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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import br.com.saudesempre.api.entities.InfoMedica;
import br.com.saudesempre.api.repositories.InfoMedicaRepository;

@RestController
@RequestMapping(value = "/infoMedicas")
public class InfoMedicaResource {

	@Autowired
	private InfoMedicaRepository infoMedicaRepository;

	@GetMapping
	public List<InfoMedica> listarInformacaoMedicas() {
		return infoMedicaRepository.findAll();
	}

	

// -------------- método de buscar por id------------------------
	@GetMapping("/{infoMedicaId}")

	public ResponseEntity<InfoMedica> buscar(@Valid @PathVariable Long infoMedicaId) {
		Optional<InfoMedica> infoMedica = infoMedicaRepository.findById(infoMedicaId);

		if (infoMedica.isPresent()) {// se tem algo dentro do infoMedica
			return ResponseEntity.ok(infoMedica.get()); // retorna a resposta 200 e o corpo retorna o infoMedica.get
		}

		return ResponseEntity.notFound().build(); // se der errado, retorna 404

	}

// --------------CADASTRO DE CLIENTE- POST -------------------------

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public InfoMedica adicionarInformacaoMedica(@Valid @RequestBody InfoMedica infoMedica) {
		return infoMedicaRepository.save(infoMedica);
	}

	
	
	@PutMapping("/{infoMedicaId}")
	public ResponseEntity<InfoMedica> atualizar(@Valid @PathVariable Long infoMedicaId, @RequestBody InfoMedica infoMedica) {
		if (!infoMedicaRepository.existsById(infoMedicaId)) {
			return ResponseEntity.notFound().build();

		}

		infoMedica.setId(infoMedicaId);
		infoMedica = infoMedicaRepository.save(infoMedica);

		return ResponseEntity.ok(infoMedica);

	}

	@DeleteMapping("/{infoMedicaId}")

// como não vai retornar nenhum corpo, retornará void.
	public ResponseEntity<Void> remover( @PathVariable Long infoMedicaId) {
		if (!infoMedicaRepository.existsById(infoMedicaId)) { // se não existe, retorne 404
			return ResponseEntity.notFound().build();
		}

		infoMedicaRepository.deleteById(infoMedicaId);

		return ResponseEntity.noContent().build();
	}
}
