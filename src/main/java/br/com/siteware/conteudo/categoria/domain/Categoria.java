package br.com.siteware.conteudo.categoria.domain;

import java.util.UUID;

import br.com.siteware.conteudo.categoria.application.api.CategoriaRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idCategoria", updatable = false, unique = true, nullable = false)
	private UUID idCategoria;
	@NotBlank
	@Size(message = "Campo nome da categoria não pode estar vazio", max = 50, min = 3)
	@Column(unique = true)
	private String nome;
	
	public Categoria(CategoriaRequest categoriaRequest) {
		this.nome = categoriaRequest.getNome();
	}
	
}
