package br.com.saudesempre.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saudesempre.api.entities.InfoMedica;


public interface InfoMedicaRepository extends JpaRepository<InfoMedica, Long> {

}
