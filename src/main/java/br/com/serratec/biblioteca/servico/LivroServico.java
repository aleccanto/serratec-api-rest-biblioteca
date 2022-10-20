package br.com.serratec.biblioteca.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.biblioteca.dtos.LivroDTO;
import br.com.serratec.biblioteca.entidades.Livro;
import br.com.serratec.biblioteca.mapeador.IMapeador;
import br.com.serratec.biblioteca.repositorio.AutorRepositorio;
import br.com.serratec.biblioteca.repositorio.LivroRepositorio;

@Service
public class LivroServico {

	@Autowired
	private LivroRepositorio livroRepositorio;

	@Autowired
	private AutorRepositorio autorRepositorio;

	@Autowired
	private IMapeador<Livro, LivroDTO> livroMapeamento;

	public List<LivroDTO> encontrarTodos() {
		List<LivroDTO> livroDTOs = new ArrayList<>();
		for (Livro livro : livroRepositorio.findAll()) {
			livroDTOs.add(livroMapeamento.paraDTO(livro));
		}
		return livroDTOs;
	}

	public LivroDTO encontrarPorId(Long id) {
		Optional<Livro> optional = livroRepositorio.findById(id);
		if (optional.isPresent()) {
			return livroMapeamento.paraDTO(optional.get());
		} else {
//			Exception
		}
		return null;
	}

	public LivroDTO criar(LivroDTO livroDTO) {

		Livro livro = livroMapeamento.paraEntidade(livroDTO);
		if(livroDTO.getAutorId() != null) {
			livro.setAutor(autorRepositorio.findById(livroDTO.getAutorId()).orElse(null));
		}
		livro = livroRepositorio.save(livro);
		return livroMapeamento.paraDTO(livro);
	}

	public boolean deletar(Long id) {
		LivroDTO dto = this.encontrarPorId(id);
		if (dto != null) {
			livroRepositorio.deleteById(id);
			return true;
		}
//		} else {
//			Exception
//		}
		return false;
	}

}
