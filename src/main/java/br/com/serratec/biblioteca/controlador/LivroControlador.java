package br.com.serratec.biblioteca.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.biblioteca.dtos.LivroDTO;
import br.com.serratec.biblioteca.servico.LivroServico;

@RestController
@RequestMapping("/livro")
public class LivroControlador {

	@Autowired
	private LivroServico livroServico;

	@GetMapping
	public ResponseEntity<List<LivroDTO>> encontrarTodos() {
		return ResponseEntity.ok(livroServico.encontrarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<LivroDTO> encontrarPorId(@PathVariable("id") Long id) {
		return ResponseEntity.ok(livroServico.encontrarPorId(id));
	}

	@PostMapping
	public ResponseEntity<LivroDTO> criar(@RequestBody LivroDTO livroDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(livroServico.criar(livroDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		if (livroServico.deletar(id)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
