package br.com.saudesempre.api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "tb_infoMedica")
public class InfomacoesMedicas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private String data;

	
	/*
	@ManyToOne
	@JoinColumn(name = "usuario")// nome da chave ESTRANGEIRA que terá no banco de dados
	Usuario usuario = new Usuario();
	*/
	
  
	public InfomacoesMedicas() {

	}

	public InfomacoesMedicas(Long id, String titulo, String descricao /* Usuario usuario */, String data) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		//this.usuario = usuario;
		this.data = data;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		InfomacoesMedicas other = (InfomacoesMedicas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	*/

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
