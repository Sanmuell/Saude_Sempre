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



import br.com.saudesempre.api.entities.Usuario;
import br.com.saudesempre.api.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	

// -------------- método de buscar por id------------------------
	@GetMapping("/{usuarioId}")

	public ResponseEntity<Usuario> buscar(@Valid @PathVariable Long usuarioId) {
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);

		if (usuario.isPresent()) {// se tem algo dentro do usuario
			return ResponseEntity.ok(usuario.get()); // retorna a resposta 200 e o corpo retorna o usuario.get
		}

		return ResponseEntity.notFound().build(); // se der errado, retorna 404

	}

// --------------CADASTRO DE CLIENTE- POST -------------------------

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionarUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	
	
	@PutMapping("/{usuarioId}")
	public ResponseEntity<Usuario> atualizar(@Valid @PathVariable Long usuarioId, @RequestBody Usuario usuario) {
		if (!usuarioRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();

		}

		usuario.setId(usuarioId);
		usuario = usuarioRepository.save(usuario);

		return ResponseEntity.ok(usuario);

	}

	@DeleteMapping("/{usuarioId}")

// como não vai retornar nenhum corpo, retornará void.
	public ResponseEntity<Void> remover( @PathVariable Long usuarioId) {
		if (!usuarioRepository.existsById(usuarioId)) { // se não existe, retorne 404
			return ResponseEntity.notFound().build();
		}

		usuarioRepository.deleteById(usuarioId);

		return ResponseEntity.noContent().build();
	}
}
