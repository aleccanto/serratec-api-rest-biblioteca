package br.com.serratec.helloworld.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.helloworld.entidades.Endereco;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {

}
