package br.com.serratec.helloworld.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.helloworld.entidades.Livro;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {

}
