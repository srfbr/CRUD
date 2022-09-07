package Model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("filmes")
public class Filme {

	@Id
	private String id;
	@Field("nome")
	@Indexed(unique = true)
	private String nomeFilme;
	@Field("produtora")
	private CategoriaFilme categoriaFilme;
	@Field("duracao")
	private BigDecimal duracaoFilme;
}
