package br.com.saudesempre.api.entities;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import org.hibernate.annotations.Cascade;
//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String urlFoto;

	// LISTA DE MEDICAMENTOS
	// Colocar somente o GET na coleção, pq ele nunca vai ter troca da valores da
	// lista
	/*
	@JsonIgnore
	//@OneToMany(mappedBy = "usuario", orphanRemoval = true) // orphan (se deletar uma pessoa deletará medicamento)
	@Cascade(value = { org.hibernate.annotations.CascadeType.ALL })
	private List<Medicamento> listaDeMedicamentos = new ArrayList<>();

	// Lista de Informações Medicas
	@JsonIgnore
	//leia se (contato é mapeado para USUARIO) // tenho que referenciar no MUITOS o objeto pai
	//@OneToMany(mappedBy = "usuario", orphanRemoval = true)
	@Cascade(value = { org.hibernate.annotations.CascadeType.ALL })
	private List<InfomacoesMedicas> listaDeInfoMedicas = new ArrayList<>();

	// Lista de Contatos
	@JsonIgnore
	//@OneToMany(mappedBy = "usuario", orphanRemoval = true) // lista de contato é mapeado para usuario
	// orphan removal true significa que se deletar uma pessoa deleta os telefones
	@Cascade(value = { org.hibernate.annotations.CascadeType.ALL }) // deleção em cascata
	private List<Contato> listaDeContatos = new ArrayList<>();
	
	*/

	public Usuario() {

	}

	public Usuario(Long id, String nome, String email, String urlFoto) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.urlFoto = urlFoto;
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

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	/*
	public List<Medicamento> getListaDeMedicamentos() {
		return listaDeMedicamentos;
	}

	public List<InfomacoesMedicas> getListaDeInfoMedicas() {
		return listaDeInfoMedicas;
	}

	public List<Contato> getListaDeContatos() {
		return listaDeContatos;
	}

*/
}
