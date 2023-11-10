package br.com.siteware.conteudo.produto.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.produto.application.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@RestController
@Log4j2
public class ProdutoRestController implements ProdutoAPI {
	private final ProdutoService produtoService;
	
	@Override
	public ProdutoIdResponse postProduto(UUID idCategoria, ProdutoRequest produtoRequest) {
		log.info("[inicia] ProdutoRestController - postProduto");
		log.info("[idCategoria] {}", idCategoria);
		ProdutoIdResponse produtoIdResponse = produtoService.salvaProduto(idCategoria, produtoRequest);
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
	public List<ProdutoCategoriaListResponse> buscaTodosProdutos(UUID idCategoria) {
		log.info("[inicia] ProdutoRestController - buscaTodosProdutos");
		log.info("[idCategoria] {}", idCategoria);
		List<ProdutoCategoriaListResponse> produtoPedidoListResponse = produtoService.buscaTodosProdutos(idCategoria);
		log.info("[finaliza] ProdutoRestController - buscaTodosProdutos");
		return produtoPedidoListResponse;
	}

	@Override
	public void deleteProdutoPorId(UUID idCliente, UUID idPedido, UUID idProduto) {
		log.info("[inicia] ProdutoRestController - deleteProdutoPorId");
		log.info("[idCliente] {}, [idPedido] {}, [idProduto] {}", idCliente, idPedido, idProduto);
		produtoService.deleteProdutoPorId(idCliente, idPedido, idProduto);
		log.info("[finaliza] ProdutoRestController - deleteProdutoPorId");
		
	}

	@Override
	public void patchPedido(UUID idCliente, UUID idPedido, UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest) {
		log.info("[inicia] ProdutoRestController - patchPedido");
		log.info("[idCliente] {}, [idPedido] {}, [idProduto] {}", idCliente, idPedido, idProduto);
		produtoService.alteraProduto(idCliente, idPedido, idProduto, produtoAlteracaoRequest);
		log.info("[finaliza] ProdutoRestController - patchPedido");
	}

}
