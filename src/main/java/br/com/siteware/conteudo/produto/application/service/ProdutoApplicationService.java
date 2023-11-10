package br.com.siteware.conteudo.produto.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.handler.APIException;
import br.com.siteware.conteudo.pedido.application.service.PedidoService;
import br.com.siteware.conteudo.produto.application.api.ProdutoDetalhadoResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoIdResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoPedidoListResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoRequest;
import br.com.siteware.conteudo.produto.application.repository.ProdutoRepository;
import br.com.siteware.conteudo.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class ProdutoApplicationService implements ProdutoService {
	private final ProdutoRepository produtoRepository; 
	private final PedidoService pedidoService; 

	@Override
	public ProdutoIdResponse salvaProduto(UUID idCliente, UUID idPedido, ProdutoRequest produtoRequest) {
		log.info("[inicia] ProdutoRestController - postProduto");
		pedidoService.buscaPedidoPorId(idCliente, idPedido);
		Produto produto = produtoRepository.salvaProduto(new Produto(idPedido, produtoRequest));
		log.info("[finaliza] ProdutoRestController - postProduto");
		return ProdutoIdResponse.builder().idProduto(produto.getIdProduto()).build();
	}

	@Override
	public ProdutoDetalhadoResponse buscaProdutoPorId(UUID idCliente, UUID idPedido, UUID idProduto) {
		log.info("[inicia] ProdutoRestController - buscaProdutoPorId");
		pedidoService.buscaPedidoPorId(idCliente, idPedido);
		Produto produto = produtoRepository.buscaProdutoPorId(idProduto).orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
		log.info("[finaliza] ProdutoRestController - buscaProdutoPorId");
		return new ProdutoDetalhadoResponse(produto);
	}

	@Override
	public List<ProdutoPedidoListResponse> buscaTodosProdutos(UUID idCliente, UUID idPedido) {
		log.info("[inicia] ProdutoRestController - buscaTodosProdutos");
		pedidoService.buscaPedidoPorId(idCliente, idPedido);
		log.info("[finaliza] ProdutoRestController - buscaTodosProdutos");
		return null;
	}

}
