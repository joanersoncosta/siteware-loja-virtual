package br.com.siteware.conteudo.produto.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@RestController
@Log4j2
public class ProdutoRestController implements ProdutoAPI {
	private final ProdutoService produtoService;
	
	@Override
	public ProdutoIdResponse postProduto(UUID idCliente, UUID idPedido, ProdutoRequest produtoRequest) {
		log.info("[inicia] ProdutoRestController - postProduto");
		log.info("[idCliente] {}, [idPedido] {}", idCliente, idPedido);
		ProdutoIdResponse produtoIdResponse = produtoService.salvaProduto(idCliente, idPedido, produtoRequest);
		log.info("[finaliza] ProdutoRestController - postProduto");
		return produtoIdResponse;
	}

	@Override
	public ProdutoDetalhadoResponse buscaProdutoPorId(UUID idCliente, UUID idPedido, UUID idProduto) {
		log.info("[inicia] ProdutoRestController - buscaProdutoPorId");
		log.info("[idCliente] {}, [idPedido] {}, [idProduto] {}", idCliente, idPedido, idProduto);
		ProdutoDetalhadoResponse produtoDetalhadoResponse = produtoService.buscaProdutoPorId(idCliente, idPedido, idProduto);
		log.info("[finaliza] ProdutoRestController - buscaProdutoPorId");
		return produtoDetalhadoResponse;
	}

	@Override
	public List<ProdutoPedidoListResponse> buscaTodosProdutos(UUID idCliente, UUID idPedido) {
		log.info("[inicia] ProdutoRestController - buscaTodosProdutos");
		log.info("[idCliente] {}, [idPedido] {}", idCliente, idPedido);
		List<ProdutoPedidoListResponse> produtoPedidoListResponse = produtoService.buscaTodosProdutos(idCliente, idPedido);
		log.info("[finaliza] ProdutoRestController - buscaTodosProdutos");
		return produtoPedidoListResponse;
	}

}
