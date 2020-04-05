package com.iofhtenight.cursomc;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iofhtenight.cursomc.domain.Categoria;

public class CategoriaDTO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

}
