/* Recurso correspondente à entidade "Usuario" 
 * Fornece dois recursos para recuperar todos os usuário cadastrados ou por Id 
 */



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

import br.com.saudesempre.api.entities.Usuario;
import br.com.saudesempre.api.service.EmailService;
import br.com.saudesempre.api.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/saude-sempre")
@Api(value = "API REST Usuarios")
@CrossOrigin(origins = "*") // Qualquer domínio pode acessar a API
public class UsuarioResource {

	//@Autowired
	//private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired 
	private UsuarioService usuarioService;
	

	//@ApiOperation(value = "Retorna TODOS os usuarios")
	@GetMapping(value = "/usuarios")
	@ApiOperation(value = "Lista todos os Usuarios")
	public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
		List<Usuario> lista = usuarioService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	

	//@ApiOperation(value = "Busca usuario por ID")
	@GetMapping("/usuarios/{id}")
	@ApiOperation(value = "Busca Usuario por ID")
	public ResponseEntity<Usuario> buscarPorId(@Valid @PathVariable Long id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		return ResponseEntity.ok().body(usuario);
		
	}
		
	
	@ApiOperation(value = "Salva um usuario")
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> inserirUsuario(@Valid @RequestBody Usuario usuario) {	
		//emailService.enviarDadosDoUsuario(usuario);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/usuarios/{id}");
		usuario = usuarioService.inserirUsuario(usuario);
		return ResponseEntity.ok().body(usuario);
	}

	
	@ApiOperation(value = "Deleta um usuario")
	@DeleteMapping("/usuarios/{id}")
// como não vai retornar nenhum corpo, retornará void.
	public ResponseEntity<Void> removerUsuario(@PathVariable Long id) {
	
		usuarioService.removerUsuario(id);
		return ResponseEntity.noContent().build(); 
	
}
}