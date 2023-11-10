package br.com.siteware.conteudo.produto.application.service;

import java.util.UUID;

import br.com.siteware.conteudo.produto.application.api.ProdutoDetalhadoResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoIdResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoRequest;

public interface ProdutoService {
	ProdutoIdResponse salvaProduto(UUID idCliente, UUID idPedido, ProdutoRequest produtoRequest);
	ProdutoDetalhadoResponse buscaProdutoPorId(UUID idCliente, UUID idPedido, UUID idProduto);

}
