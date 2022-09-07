package Controller;


import Service.FilmeService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Filme;


@RestController
@RequestMapping("/api/filme")
@RequiredArgsConstructor
public class FilmeController {
	
	private final FilmeService filmeService;
	
	@PostMapping
	public ResponseEntity addFilme(@RequestBody Filme filme) {
		filmeService.addFilme(filme);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity updateFilme(@RequestBody Filme filme) {
		filmeService.updateFilme(filme);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Filme>> getAllFilmes(){
		return ResponseEntity.ok(filmeService.getAllFilmes());
	}

	@GetMapping("/{nome}")
	public ResponseEntity getFilmeByName(@PathVariable String nome) {
		return ResponseEntity.ok(filmeService.getFilme(nome));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteFilme(@PathVariable String id) {
		return ResponseEntity.noContent().build();
	}
}
