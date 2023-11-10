package br.com.siteware.conteudo.carrinho.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.carrinho.application.service.ProdutoCarrinhoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@RestController
@Log4j2
public class ProdutoCarrinhoRestController implements ProdutoCarrinhoAPI {
	private final ProdutoCarrinhoService produtoCarrinhoService;
	
	@Override
	public ProdutoCarrinhoIdResponse adicionaProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idCategoria, UUID idProduto,
			ProdutoCarrinhoRequest produtoRequest) {
		log.info("[inicia] ProdutoCarrinhoRestController - adicionaProdutoCarrinho");
		log.info("[idPedido] {}, [idPedido] {}, [idCategoria] {}, [idProduto] {}", idCliente, idPedido, idCategoria, idProduto);
		ProdutoCarrinhoIdResponse ProdutoCarrinhoIdResponse = produtoCarrinhoService.adicionaProdutoCarrinho(idCliente, idPedido, idCategoria, idProduto, produtoRequest);
		log.info("[finaliza] ProdutoCarrinhoRestController - adicionaProdutoCarrinho");
		return ProdutoCarrinhoIdResponse;
	}

}
