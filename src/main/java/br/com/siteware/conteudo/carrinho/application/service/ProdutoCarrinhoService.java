package br.com.siteware.conteudo.carrinho.application.service;

import java.util.List;
import java.util.UUID;

import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoDetalhadoResponse;
import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoIdResponse;
import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoListResponse;
import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoRequest;

public interface ProdutoCarrinhoService {
	ProdutoCarrinhoIdResponse adicionaProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idProduto,
			ProdutoCarrinhoRequest produtoRequest);
	List<ProdutoCarrinhoListResponse> buscaTodosProdutosCarrinho(UUID idCliente, UUID idPedido);
	ProdutoCarrinhoDetalhadoResponse buscaProdutoPorId(UUID idPedidoCarrinho);
	void atualizaQuantidadeProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idPedidoCarrinho, ProdutoCarrinhoRequest produtoCarrinhoRequest);
	void removeProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idPedidoCarrinho);
}
