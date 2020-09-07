package br.com.saudesempre.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import br.com.saudesempre.api.entities.Medicamento;
import br.com.saudesempre.api.repositories.MedicamentoRepository;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	public List<Medicamento> buscarTodosMedicamentos() {
		return medicamentoRepository.findAll();
	}

	public Medicamento buscarPorId(Long id) {
		Optional<Medicamento> obj = medicamentoRepository.findById(id);
		return obj.orElseThrow(() -> new EntityNotFoundException("ID " + id + " não existe : "));
	}

	public Medicamento inserirMedicamento(Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}

	public void removerUsuario(Long id) {
		try {
			medicamentoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("ID " + id + " não existe : ");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}
}
