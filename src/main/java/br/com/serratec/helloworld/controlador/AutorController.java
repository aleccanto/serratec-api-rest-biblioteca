package br.com.serratec.helloworld.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.helloworld.dtos.AutorDTO;
import br.com.serratec.helloworld.servico.AutorServico;

@RestController
@RequestMapping("/autor")
public class AutorController {

	public AutorController() {
		System.out.println("[AutorController]: iniciado!");
	}

	@Autowired
	private AutorServico autorServico;

	@GetMapping
	public ResponseEntity<List<AutorDTO>> encontrarTodos() {
		return ResponseEntity.ok(autorServico.encontrarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AutorDTO> encontrarPorId(@PathVariable("id") Long id) {
		return ResponseEntity.ok(autorServico.encontrarPorId(id));
	}

	@PostMapping
	public ResponseEntity<AutorDTO> criar(@RequestBody AutorDTO autor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(autorServico.criar(autor));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AutorDTO> atualizar(@PathVariable("id") Long id, @RequestBody AutorDTO autorDTO) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(autorServico.atualizar(id, autorDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPorId(@PathVariable("id") Long id) {
		if (autorServico.deletarPorId(id)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
