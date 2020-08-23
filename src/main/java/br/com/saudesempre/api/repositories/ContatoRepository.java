package br.com.saudesempre.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saudesempre.api.entities.Contato;


 //(Entidade "Contato". tipo do ID "LONG")
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
