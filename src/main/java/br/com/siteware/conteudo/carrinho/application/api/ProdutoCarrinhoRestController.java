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
	public ProdutoCarrinhoIdResponse adicionaProdutoCarrinho(UUID idPedido, UUID idProduto,
			ProdutoCarrinhoRequest produtoRequest) {
		log.info("[inicia] ProdutoCarrinhoRestController - adicionaProdutoCarrinho");
		log.info("[idPedido] {}, [idProduto] {}", idPedido, idProduto);
		ProdutoCarrinhoIdResponse ProdutoCarrinhoIdResponse = produtoCarrinhoService.adicionaProdutoCarrinho(idPedido, idProduto, produtoRequest);
		log.info("[finaliza] ProdutoCarrinhoRestController - adicionaProdutoCarrinho");
		return ProdutoCarrinhoIdResponse;
	}

}
