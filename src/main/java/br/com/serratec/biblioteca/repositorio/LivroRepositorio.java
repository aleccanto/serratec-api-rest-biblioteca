package br.com.serratec.biblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.biblioteca.entidades.Livro;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {

}
