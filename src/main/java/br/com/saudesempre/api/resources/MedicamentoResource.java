/* Recurso correspondente à entidade "Usuario" 
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

import br.com.saudesempre.api.entities.Medicamento;

import br.com.saudesempre.api.repositories.MedicamentoRepository;


@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentoResource {

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@GetMapping
	public List<Medicamento> listarTodosMedicamentos() {
		return medicamentoRepository.findAll();
	}

	

// -------------- método de buscar por id------------------------
	@GetMapping("/{medicamentoId}")

	public ResponseEntity<Medicamento> buscarMedicamentosPorId(@Valid @PathVariable Long medicamentoId) {
		Optional<Medicamento> medicamento = medicamentoRepository.findById(medicamentoId);

		if (medicamento.isPresent()) {// se tem algo dentro do usuario
			return ResponseEntity.ok(medicamento.get()); // retorna a resposta 200 e o corpo retorna o usuario.get
		}

		return ResponseEntity.notFound().build(); // se der errado, retorna 404

	}

// --------------CADASTRO DE CLIENTE- POST -------------------------

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Medicamento adicionarMedicamento(@Valid @RequestBody Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}

	
	
	@PutMapping("/{medicamentoId}")
	public ResponseEntity<Medicamento> atualizarMedicamento (@Valid @PathVariable Long medicamentoId, @RequestBody Medicamento medicamento) {
		if (!medicamentoRepository.existsById(medicamentoId)) {
			return ResponseEntity.notFound().build();

		}

		medicamento.setId(medicamentoId);
		medicamento = medicamentoRepository.save(medicamento);

		return ResponseEntity.ok(medicamento);

	}

	@DeleteMapping("/{medicamentoId}")

// como não vai retornar nenhum corpo, retornará void.
	public ResponseEntity<Void> removerMedicamento ( @PathVariable Long medicamentoId) {
		if (!medicamentoRepository.existsById(medicamentoId)) { // se não existe, retorne 404
			return ResponseEntity.notFound().build();
		}

		medicamentoRepository.deleteById(medicamentoId);

		return ResponseEntity.noContent().build();
	}
}
