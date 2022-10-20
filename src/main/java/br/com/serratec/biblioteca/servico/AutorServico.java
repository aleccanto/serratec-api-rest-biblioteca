package br.com.serratec.biblioteca.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.biblioteca.dtos.AutorDTO;
import br.com.serratec.biblioteca.entidades.Autor;
import br.com.serratec.biblioteca.entidades.Livro;
import br.com.serratec.biblioteca.mapeador.IMapeador;
import br.com.serratec.biblioteca.repositorio.AutorRepositorio;
import br.com.serratec.biblioteca.repositorio.LivroRepositorio;

@Service
public class AutorServico {

	@Autowired
	private AutorRepositorio autorRepositorio;

	@Autowired
	private LivroRepositorio livroRepositorio;

	@Autowired
	private IMapeador<Autor, AutorDTO> autorMapeamento;

	public AutorServico() {
		System.out.println("[AutorServico]: iniciando!");
	}

	public List<AutorDTO> encontrarTodos() {
		List<AutorDTO> autorDTOs = new ArrayList<>();
		List<Autor> autores = autorRepositorio.findAll();
		for (Autor autor : autores) {
			AutorDTO autorDTO = autorMapeamento.paraDTO(autor);
			autorDTOs.add(autorDTO);
		}
		return autorDTOs;
	}

	public AutorDTO encontrarPorId(Long id) {
		Optional<Autor> autor = autorRepositorio.findById(id);
		if (autor.isPresent()) {
			return autorMapeamento.paraDTO(autor.get());
		}
		return null;
	}

	public AutorDTO criar(AutorDTO autorDTO) {

//		Data Transfer Object – DTO
		Autor autor = autorMapeamento.paraEntidade(autorDTO);
		autor.setId(null);
		autor = autorRepositorio.save(autor);

		return autorMapeamento.paraDTO(autor);
	}

	public AutorDTO atualizar(Long id, AutorDTO autor) {
		if (this.autorRepositorio.findById(id).isPresent()) {
			autor.setId(id);
			Autor autorAtualizado = autorMapeamento.paraEntidade(autor);
			if (!autor.getLivrosId().isEmpty()) {
				for (Long livroId : autor.getLivrosId()) {
					Livro livro = this.livroRepositorio.findById(livroId).orElse(null);
					if (livro != null) {
						autorAtualizado.getLivros().add(livro);
						livro.setAutor(autorAtualizado);
					} else {
						System.out.println("Livro não encontrado");
					}
				}
			}
			return autorMapeamento.paraDTO(autorRepositorio.save(autorAtualizado));
		}
		return null;
	}

	public Boolean deletarPorId(Long id) {
		if (this.encontrarPorId(id) != null) {
			autorRepositorio.deleteById(id);
			return true;
		}
		return false;
	}

}
