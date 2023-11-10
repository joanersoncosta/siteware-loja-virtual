package br.com.siteware.conteudo.categoria.application.api;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoriaRequest {
	@NotBlank
	@Size(message = "Campo nome da categoria não pode estar vazio", max = 50, min = 3)
	@Column(unique = true)
	private String nome;
}
