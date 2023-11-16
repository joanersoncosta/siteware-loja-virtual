package br.com.siteware.conteudo.carrinho.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProdutoCarrinhoIdResponse {
	private UUID idCarrinhoProduto;
}
