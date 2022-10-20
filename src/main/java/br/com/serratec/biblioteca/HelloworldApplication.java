package br.com.serratec.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

	
//		CREATE TABLE public.categoria (
//		    id SERIAL NOT NULL PRIMARY KEY,
//		    nome VARCHAR(100),
//		    descricao VARCHAR(100)
//		);
//
//		CREATE TABLE public.livro (
//		    id SERIAL NOT NULL PRIMARY KEY,
//		    nome VARCHAR(100),
//		    categoria_id INT REFERENCES categoria(id)
//		);
//
//		CREATE TABLE public.endereco (
//		    id SERIAL NOT NULL PRIMARY KEY,
//		    rua VARCHAR(100),
//		    municipio VARCHAR(100)
//		);
//
//		CREATE TABLE public.autor(
//		    id SERIAL NOT NULL PRIMARY KEY,
//		    nome VARCHAR(100) 
//			endereco_id INT REFERENCES endereco(id)
//		);
//
//		CREATE TABLE public.livro_autor (
//		    livro_id INT REFERENCES livro(id),
//		    autor_id INT REFERENCES autor(id)
//		);
//
//		ALTER TABLE
//		    public.endereco
//		ADD
//		    autor_id INT REFERENCES autor(id)
	
}
