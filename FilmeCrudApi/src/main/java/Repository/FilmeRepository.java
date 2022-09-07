package Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import Model.Filme;


public interface FilmeRepository extends MongoRepository<Filme, String> {
	@Query("{'filme-tracker': ?0}")
	Optional<Filme> findByName(String nome);
	
}
