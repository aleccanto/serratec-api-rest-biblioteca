package br.com.serratec.helloworld.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.helloworld.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
