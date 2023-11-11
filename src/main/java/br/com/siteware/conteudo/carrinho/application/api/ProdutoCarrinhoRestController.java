package br.com.siteware.conteudo.carrinho.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.carrinho.application.service.ProdutoCarrinhoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@RestController
@Log4j2
public class ProdutoCarrinhoRestController implements ProdutoCarrinhoAPI {
	private final ProdutoCarrinhoService produtoCarrinhoService;
	
	@Override
	public ProdutoCarrinhoIdResponse adicionaProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idProduto,
			ProdutoCarrinhoRequest produtoRequest) {
		log.info("[inicia] ProdutoCarrinhoRestController - adicionaProdutoCarrinho");
		log.info("[idPedido] {}, [idPedido] {}, [idProduto] {}", idCliente, idPedido, idProduto);
		ProdutoCarrinhoIdResponse ProdutoCarrinhoIdResponse = produtoCarrinhoService.adicionaProdutoCarrinho(idCliente, idPedido, idProduto, produtoRequest);
		log.info("[finaliza] ProdutoCarrinhoRestController - adicionaProdutoCarrinho");
		return ProdutoCarrinhoIdResponse;
	}

	@Override
	public List<ProdutoCarrinhoListResponse> buscaTodosProdutosCarrinho(UUID idCliente, UUID idPedido, UUID idProduto) {
		log.info("[inicia] ProdutoCarrinhoRestController - buscaTodosProdutosCarrinho");
		log.info("[idPedido] {}, [idPedido] {}, [idProduto] {}", idCliente, idPedido, idProduto);
		List<ProdutoCarrinhoListResponse> produtoCarrinhoListResponse = produtoCarrinhoService.buscaTodosProdutosCarrinho(idCliente, idPedido, idProduto);
		log.info("[finaliza] ProdutoCarrinhoRestController - buscaTodosProdutosCarrinho");
		return produtoCarrinhoListResponse;
	}

}
