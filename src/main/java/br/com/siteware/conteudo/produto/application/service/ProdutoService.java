package br.com.siteware.conteudo.produto.application.service;

import java.util.List;
import java.util.UUID;

import br.com.siteware.conteudo.produto.application.api.ProdutoAlteracaoRequest;
import br.com.siteware.conteudo.produto.application.api.ProdutoDetalhadoResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoIdResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoPedidoListResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoRequest;

public interface ProdutoService {
	ProdutoIdResponse salvaProduto(UUID idCategoria, ProdutoRequest produtoRequest);
	ProdutoDetalhadoResponse buscaProdutoPorId(UUID idCliente, UUID idPedido, UUID idProduto);
	List<ProdutoPedidoListResponse> buscaTodosProdutos(UUID idCliente, UUID idPedido);
	void deleteProdutoPorId(UUID idCliente, UUID idPedido, UUID idProduto);
	void alteraProduto(UUID idCliente, UUID idPedido, UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest);

}
