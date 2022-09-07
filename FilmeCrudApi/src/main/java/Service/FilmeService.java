package Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Model.Filme;
import Repository.FilmeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FilmeService {
	
	private final FilmeRepository filmeRepository;
		
		public void addFilme(Filme filme) {
			filmeRepository.insert(filme);
		}
		
		public void updateFilme(Filme filme) {
			Filme savedFilme = filmeRepository.findById(filme.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Filme by ID %s", filme.getId())));
			savedFilme.setNomeFilme(filme.getNomeFilme());
	        savedFilme.setCategoriaFilme(filme.getCategoriaFilme());
	        savedFilme.setDuracaoFilme(filme.getDuracaoFilme());
	        
	        filmeRepository.save(filme);
		}
		
		public Filme getFilme(String nome) {
			return filmeRepository.findByName(nome)
	                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Filme by Nome - %s", nome)));
		}
		
		public List<Filme> getAllFilmes(){
			return filmeRepository.findAll();	
		}
		
		public void deleteExpense(String id) {
			filmeRepository.deleteById(id);
		}
}
