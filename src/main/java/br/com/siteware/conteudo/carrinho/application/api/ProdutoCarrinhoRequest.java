package br.com.siteware.conteudo.carrinho.application.api;

import jakarta.validation.constraints.NotNull;

public class ProdutoCarrinhoRequest {
	@NotNull
	private Integer quantidade;
}
