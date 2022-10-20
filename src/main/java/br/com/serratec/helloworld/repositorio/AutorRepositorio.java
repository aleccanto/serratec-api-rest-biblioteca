package br.com.serratec.helloworld.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.serratec.helloworld.entidades.Autor;
import br.com.serratec.helloworld.entidades.Livro;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {

	Autor findByLivros(Livro livro);

//	Query nativa
	@Query(nativeQuery = true, value = "SELECT * FROM public.autor WHERE nome = :nome ")
	List<Autor> findByNome(@Param("nome") String nome);

//	Jpql
	@Query(value = "SELECT autor FROM Autor autor WHERE autor.nome LIKE %:nome%")
	List<Autor> findByNome2(@Param("nome") String nome);

}
