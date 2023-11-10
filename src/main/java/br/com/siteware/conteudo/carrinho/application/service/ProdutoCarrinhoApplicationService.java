package br.com.siteware.conteudo.carrinho.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoIdResponse;
import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoRequest;
import br.com.siteware.conteudo.pedido.application.service.PedidoService;
import br.com.siteware.conteudo.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class ProdutoCarrinhoApplicationService implements ProdutoCarrinhoService {
	private final PedidoService pedidoService; 
	private final ProdutoService produtoService;

	@Override
	public ProdutoCarrinhoIdResponse adicionaProdutoCarrinho(UUID idPedido, UUID idProduto,
			ProdutoCarrinhoRequest produtoRequest) {
		log.info("[inicia] ProdutoCarrinhoApplicationService - adicionaProdutoCarrinho");
		
		log.info("[finaliza] ProdutoCarrinhoApplicationService - adicionaProdutoCarrinho");
		return null;
	}

}
