package br.com.serratec.biblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.biblioteca.entidades.Endereco;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {

}
