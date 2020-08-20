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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.saudesempre.api.entities.Usuario;
import br.com.saudesempre.api.repositories.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/saude-sempre")
@Api(value = "API REST Usuarios")
@CrossOrigin(origins = "*") // Qualquer domínio pode acessar a API
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@ApiOperation(value = "Retorna TODOS os usuarios")
	@GetMapping("/usuarios")
	public List<Usuario> listarTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	@ApiOperation(value = "Busca usuario por ID")
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> buscar(@Valid @PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (usuario.isPresent()) {// se tem algo dentro do usuario
			return ResponseEntity.ok(usuario.get()); // retorna a resposta 200 e o corpo retorna o usuario.get
		}

		return ResponseEntity.notFound().build(); // se der errado, retorna 404
	}

	@ApiOperation(value = "Salva um usuario")
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionarUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@ApiOperation(value = "Deleta um usuario")
	@DeleteMapping("/{id}")
// como não vai retornar nenhum corpo, retornará void.
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!usuarioRepository.existsById(id)) { // se não existe, retorne 404
			return ResponseEntity.notFound().build();
		}

		usuarioRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
