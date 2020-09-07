package br.com.saudesempre.api.service;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.com.saudesempre.api.entities.Usuario;
import br.com.saudesempre.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired // Meu service que vai chamar o repository
	private UsuarioRepository usuarioRepository;

	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarPorId(long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new EntityNotFoundException("ID " + id + " não existe : "));
	}

	public Usuario inserirUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void removerUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("ID " + id + " não existe : ");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

}
