/* Recurso correspondente à entidade "Medicamento" 
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
import br.com.saudesempre.api.entities.Medicamento;
import br.com.saudesempre.api.entities.Medicamento;
import br.com.saudesempre.api.entities.Medicamento;
import br.com.saudesempre.api.service.MedicamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/saude-sempre")
@Api(value = "API REST Medicamentos")
@CrossOrigin(origins = "*") // Qualquer domínio pode acessar a API
public class MedicamentoResource {

	@Autowired
	private MedicamentoService medicamentoService;

	// @ApiOperation(value = "Retorna TODOS os medicamentos")
		@GetMapping(value = "/medicamentos")
		@ApiOperation(value = "Lista todos os Medicamentos")
		public ResponseEntity<List<Medicamento>> listarTodosMedicamentos() {
			List<Medicamento> lista = medicamentoService.buscarTodosMedicamentos();
			return ResponseEntity.ok().body(lista);
	
		}

// // @ApiOperation(value = "Busca medicamento por ID")
		@GetMapping("/medicamentos/{id}")
		@ApiOperation(value = "Busca Medicamento por ID")
		public ResponseEntity<Medicamento> buscarPorId(@Valid @PathVariable Long id) {
			Medicamento medicamento = medicamentoService.buscarPorId(id);
			return ResponseEntity.ok().body(medicamento);
		
	}

		@ApiOperation(value = "Salva um medicamento")
		@PostMapping("/medicamentos")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<Medicamento> inserirMedicamento(@Valid @RequestBody Medicamento medicamento) {
			// emailService.enviarDadosDoMedicamento(medicamento);
			// URI uri =
			// ServletUriComponentsBuilder.fromCurrentRequest().path("/medicamentos/{id}");
			medicamento = medicamentoService.inserirMedicamento(medicamento);
			return ResponseEntity.ok().body(medicamento);
	}

	
	
	@PutMapping("/medicamentos/{id}")
	@ApiOperation(value = "Atualiza um medicamento por ID")
	public ResponseEntity<Medicamento> atualizarMedicamento (@Valid @PathVariable Long id, @RequestBody Medicamento medicamento) {
		medicamento = medicamentoService.atualizarMedicamento(id, medicamento);
		return ResponseEntity.ok().body(medicamento);

	}

	@ApiOperation(value = "Deleta um medicamento")
	@DeleteMapping("/medicamentos/{id}")
// como não vai retornar nenhum corpo, retornará void.
	public ResponseEntity<Void> removerMedicamento(@PathVariable Long id) {

		medicamentoService.removerMedicamento(id);
		return ResponseEntity.noContent().build();	}
}
