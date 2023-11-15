package br.com.siteware.conteudo.carrinho.application.api;

import java.util.List;
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
	public ProdutoCarrinhoIdResponse adicionaProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idProduto,
			ProdutoCarrinhoRequest produtoRequest) {
		log.info("[inicia] ProdutoCarrinhoRestController - adicionaProdutoCarrinho");
		log.info("[idPedido] {}, [idPedido] {}, [idProduto] {}", idCliente, idPedido, idProduto);
		ProdutoCarrinhoIdResponse ProdutoCarrinhoIdResponse = produtoCarrinhoService.adicionaProdutoCarrinho(idCliente, idPedido, idProduto, produtoRequest);
		log.info("[finaliza] ProdutoCarrinhoRestController - adicionaProdutoCarrinho");
		return ProdutoCarrinhoIdResponse;
	}

	@Override
	public List<ProdutoCarrinhoListResponse> buscaTodosProdutosCarrinho(UUID idCliente, UUID idPedido) {
		log.info("[inicia] ProdutoCarrinhoRestController - buscaTodosProdutosCarrinho");
		log.info("[idPedido] {}, [idPedido] {}", idCliente, idPedido);
		List<ProdutoCarrinhoListResponse> produtoCarrinhoListResponse = produtoCarrinhoService.buscaTodosProdutosCarrinho(idCliente, idPedido);
		log.info("[finaliza] ProdutoCarrinhoRestController - buscaTodosProdutosCarrinho");
		return produtoCarrinhoListResponse;
	}

	@Override
	public void atualizaQuantidadeProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idPedidoCarrinho, ProdutoCarrinhoRequest produtoCarrinhoRequest) {
		log.info("[inicia] ProdutoCarrinhoRestController - atualizaQuantidadeProdutoCarrinho");
		log.info("[idPedido] {}, [idPedido] {}, [idPedidoCarrinho] {}", idCliente, idPedido, idPedidoCarrinho);
		produtoCarrinhoService.atualizaQuantidadeProdutoCarrinho(idCliente, idPedido, idPedidoCarrinho, produtoCarrinhoRequest);
		log.info("[finaliza] ProdutoCarrinhoRestController - atualizaQuantidadeProdutoCarrinho");
	}

	@Override
	public void removeProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idPedidoCarrinho) {
		log.info("[inicia] ProdutoCarrinhoRestController - removeProdutoCarrinho");
		log.info("[idPedido] {}, [idPedido] {}, [idPedidoCarrinho] {}", idCliente, idPedido, idPedidoCarrinho);
		produtoCarrinhoService.removeProdutoCarrinho(idCliente, idPedido, idPedidoCarrinho);
		log.info("[finaliza] ProdutoCarrinhoRestController - removeProdutoCarrinho");
	}
}