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

import br.com.saudesempre.api.entities.Medicamento;

import br.com.saudesempre.api.repositories.MedicamentoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/saude-sempre")
@Api(value = "API REST Medicamentos")
@CrossOrigin(origins = "*") // Qualquer domínio pode acessar a API
public class MedicamentoResource {

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@GetMapping(value = "/medicamentos")
	@ApiOperation(value = "Lista todos os Medicamentos")
	//@ApiOperation(value = "Retorna TODOS os Medicamentos")
	public List<Medicamento> listarTodosMedicamentos() {
		return medicamentoRepository.findAll();
	}

	

// -------------- método de buscar por id------------------------
	@GetMapping("/medicamentos/{id}")
	@ApiOperation(value = "Busca medicamento por ID")
	public ResponseEntity<Medicamento> buscarMedicamentosPorId(@Valid @PathVariable Long id) {
		Optional<Medicamento> medicamento = medicamentoRepository.findById(id);

		if (medicamento.isPresent()) {// se tem algo dentro do usuario
			return ResponseEntity.ok(medicamento.get()); // retorna a resposta 200 e o corpo retorna o usuario.get
		}

		return ResponseEntity.notFound().build(); // se der errado, retorna 404

	}

// --------------CADASTRO DE CLIENTE- POST -------------------------

	@PostMapping(value = "/medicamentos/")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Salva um medicamento")
	public Medicamento adicionarMedicamento(@Valid @RequestBody Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}

	
	
	@PutMapping("/medicamentos/{id}")
	@ApiOperation(value = "Atualiza um medicamento por ID")
	public ResponseEntity<Medicamento> atualizarMedicamento (@Valid @PathVariable Long id, @RequestBody Medicamento medicamento) {
		if (!medicamentoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();

		}

		medicamento.setId(id);
		medicamento = medicamentoRepository.save(medicamento);

		return ResponseEntity.ok(medicamento);

	}

	@DeleteMapping("/medicamentos/{id}")
	@ApiOperation(value = "Deleta um medicamento por ID")
// como não vai retornar nenhum corpo, retornará void.
	public ResponseEntity<Void> removerMedicamento ( @PathVariable Long id) {
		if (!medicamentoRepository.existsById(id)) { // se não existe, retorne 404
			return ResponseEntity.notFound().build();
		}

		medicamentoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
