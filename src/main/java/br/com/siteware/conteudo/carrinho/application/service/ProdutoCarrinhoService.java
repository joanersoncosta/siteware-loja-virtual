package br.com.siteware.conteudo.carrinho.application.service;

import java.util.UUID;

import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoIdResponse;
import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoRequest;

public interface ProdutoCarrinhoService {
	ProdutoCarrinhoIdResponse adicionaProdutoCarrinho(UUID idPedido, UUID idProduto,
			ProdutoCarrinhoRequest produtoRequest);

}
