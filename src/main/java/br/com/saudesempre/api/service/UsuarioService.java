package br.com.saudesempre.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.com.saudesempre.api.entities.Usuario;
import br.com.saudesempre.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired // Meu service que vai chamar o repository
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}

	public Usuario buscarPorId(long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.get();
	}
	
	public Usuario inserirUsuario (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	public void removerUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	/*
	public Usuario atualizarUsuario(Long id, Usuario usuario) {
		Usuario entity = usuarioRepository.getOne(id);
		updateData(entity, usuario);
		return usuarioRepository.save(entity);
		
	}

	
	private void updateData(Usuario entity, Usuario usuario) {
		entity.setNome(usuario.getNome());
		entity.setContato(usuario.getContato());
		entity.setUrlFoto(usuario.getUrlFoto());
	}
*/
}
