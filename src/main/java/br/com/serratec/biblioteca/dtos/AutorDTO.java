package br.com.serratec.biblioteca.dtos;

import java.util.ArrayList;
import java.util.List;

public class AutorDTO {

	private Long id;

	private String nome;

	private List<Long> livrosId = new ArrayList<>();

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

	public List<Long> getLivrosId() {
		return livrosId;
	}

	public void setLivrosId(List<Long> livrosId) {
		this.livrosId = livrosId;
	}

}
