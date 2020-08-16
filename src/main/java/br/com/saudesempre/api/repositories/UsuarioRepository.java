package br.com.saudesempre.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saudesempre.api.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
