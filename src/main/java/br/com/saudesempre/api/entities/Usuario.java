package br.com.saudesempre.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuarioDeMedicamento")
	//@JoinTable(name = "tb_usuario_medicamento", joinColumns =  ) //dito qual é o nome da tabela e as respectivas chaves estrangeiras que associa com essa
	private List<Medicamento> listaDeMedicamentos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "infoMedica")
	private List<InfoMedica> listaDeInfoMedicas = new ArrayList<>();
	

	public Usuario() {

	}

	public Usuario(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Medicamento> getListaDeMedicamentos() {
		return listaDeMedicamentos;
	}

	public List<InfoMedica> getListaDeInfoMedicas() {
		return listaDeInfoMedicas;
	}

	public void setListaDeInfoMedicas(List<InfoMedica> listaDeInfoMedicas) {
		this.listaDeInfoMedicas = listaDeInfoMedicas;
	}
	
	

}
