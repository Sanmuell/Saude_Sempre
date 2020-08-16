/*package br.com.saudesempre.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.saudesempre.api.entities.Usuario;
import br.com.saudesempre.api.repositories.UsuarioRepository;

public class UsuarioService {
	
	@Autowired
	public UsuarioRepository repository;

	public List<Usuario> buscarTodos (){
		return repository.findAll();
	}
	
	public Usuario buscarPorId (Long id ) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}
}

*/