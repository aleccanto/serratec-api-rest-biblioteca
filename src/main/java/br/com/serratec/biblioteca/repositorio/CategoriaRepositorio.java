package br.com.serratec.biblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.biblioteca.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
