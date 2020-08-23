package br.com.saudesempre.api.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.saudesempre.api.entities.Contato;
import br.com.saudesempre.api.repositories.ContatoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/saude-sempre")
@Api(value = "API REST Contato")
@CrossOrigin(origins = "*")
public class ContatoResource {
 
	@Autowired
	private ContatoRepository contatoRepository;
	
	@GetMapping(value = "/contatos")
	@ApiOperation(value = "Lista todos os contatos")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Contato> listarTodosContatos(){
		return contatoRepository.findAll();
	}
	
	@PostMapping(value = "/contatos")
	@ApiOperation(value = "Adiciona um contato")
	@ResponseStatus(HttpStatus.CREATED)
	public Contato adicionarContato(@Valid @RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	@DeleteMapping(value = "/contatos/{id}")
	@ApiOperation(value = "Deleta um contato por ID")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> removerContato (@PathVariable Long id){
		if(!contatoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		contatoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	

}
