package br.com.siteware.conteudo.produto.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProdutoAlteracaoRequest {
	@NotNull
	private String nome;
	@NotBlank
	@Size(message = "Campo descrição produto não pode estar vazio", max = 255, min = 3)
	private String descricao;
	@NotNull
	private Double preco;
	@NotNull
	private Integer quantidade;
}
