package br.com.siteware.conteudo.categoria.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	@Column(columnDefinition = "uuid", name = "idProduto", nullable = false)
	private UUID idProduto;
	@NotBlank
	@Size(message = "Campo nome da categoria não pode estar vazio", max = 50, min = 3)
	private String nome;
	
	
}
