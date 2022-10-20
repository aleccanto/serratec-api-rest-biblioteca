package br.com.serratec.helloworld.mapeador;

import org.springframework.stereotype.Component;

import br.com.serratec.helloworld.dtos.LivroDTO;
import br.com.serratec.helloworld.entidades.Livro;

@Component
public class LivroMapeamento implements IMapeador<Livro, LivroDTO> {

	public Livro paraEntidade(LivroDTO livroDTO) {
		Livro livro = new Livro();
		livro.setId(livroDTO.getId());
		livro.setNome(livroDTO.getNome());

		return livro;
	}

	public LivroDTO paraDTO(Livro livro) {
		LivroDTO livroDTO = new LivroDTO();
		livroDTO.setId(livro.getId());
		livroDTO.setNome(livro.getNome());
		if (livro.getAutor() != null && livro.getAutor().getId() != null) {
			livroDTO.setAutorId(livro.getAutor().getId());
		}

		return livroDTO;
	}

}
