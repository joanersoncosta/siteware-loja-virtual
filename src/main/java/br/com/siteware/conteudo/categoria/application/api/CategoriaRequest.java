package br.com.siteware.conteudo.categoria.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoriaRequest {
	@NotBlank
	@Size(message = "Campo nome da categoria não pode estar vazio", max = 50, min = 3)
	private String nome;
}
