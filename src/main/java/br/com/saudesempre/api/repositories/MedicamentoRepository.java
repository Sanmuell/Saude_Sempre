package br.com.saudesempre.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saudesempre.api.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
