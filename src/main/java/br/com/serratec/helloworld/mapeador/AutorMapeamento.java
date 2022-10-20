package br.com.serratec.helloworld.mapeador;

import org.springframework.stereotype.Component;

import br.com.serratec.helloworld.dtos.AutorDTO;
import br.com.serratec.helloworld.entidades.Autor;
import br.com.serratec.helloworld.entidades.Livro;

@Component
public class AutorMapeamento implements IMapeador<Autor, AutorDTO> {

	public AutorDTO paraDTO(Autor autor) {
		AutorDTO autorDTO = new AutorDTO();
		autorDTO.setId(autor.getId());
		autorDTO.setNome(autor.getNome());
		for (Livro livro : autor.getLivros()) {
			autorDTO.getLivrosId().add(livro.getId());
		}
		return autorDTO;
	}

	public Autor paraEntidade(AutorDTO autorDTO) {
		Autor autor = new Autor();
		autor.setId(autorDTO.getId());
		autor.setNome(autorDTO.getNome());
		return autor;
	}
}
