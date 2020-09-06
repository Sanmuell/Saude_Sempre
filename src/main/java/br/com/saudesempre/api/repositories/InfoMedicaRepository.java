package br.com.saudesempre.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saudesempre.api.entities.InfomacoesMedicas;


 //(Entidade "Contato". tipo do ID "LONG")
public interface InfoMedicaRepository extends JpaRepository<InfomacoesMedicas, Long> {

}
