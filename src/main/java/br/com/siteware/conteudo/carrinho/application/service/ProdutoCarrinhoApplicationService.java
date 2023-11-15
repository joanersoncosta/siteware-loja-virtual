package br.com.siteware.conteudo.carrinho.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoDetalhadoResponse;
import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoIdResponse;
import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoListResponse;
import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoRequest;
import br.com.siteware.conteudo.carrinho.application.repository.ProdutoCarrinhoRepository;
import br.com.siteware.conteudo.carrinho.domain.CarrinhoProduto;
import br.com.siteware.conteudo.handler.APIException;
import br.com.siteware.conteudo.pedido.application.api.PedidoDetalhadoResponse;
import br.com.siteware.conteudo.pedido.application.service.PedidoService;
import br.com.siteware.conteudo.produto.application.api.ProdutoDetalhadoResponse;
import br.com.siteware.conteudo.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class ProdutoCarrinhoApplicationService implements ProdutoCarrinhoService {
	private final ProdutoService produtoService;
	private final ProdutoCarrinhoRepository produtoCarrinhoRepository;
	private final PedidoService pedidoService;

	@Override
	public ProdutoCarrinhoIdResponse adicionaProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idProduto,
			ProdutoCarrinhoRequest produtoRequest) {
		log.info("[inicia] ProdutoCarrinhoApplicationService - adicionaProdutoCarrinho");
		pedidoService.buscaPedidoPorId(idCliente, idPedido);
		ProdutoDetalhadoResponse produto = produtoService.buscaProdutoPorId(idProduto);
		CarrinhoProduto carrinhoProduto = produtoCarrinhoRepository.salvaProdutoCarrinho(
				new CarrinhoProduto(idCliente, idPedido, idProduto, produto, produtoRequest));
		atualizaTotalPedido(idCliente, idPedido);
		log.info("[finaliza] ProdutoCarrinhoApplicationService - adicionaProdutoCarrinho");
		return ProdutoCarrinhoIdResponse.builder().idCarrinhoProduto(carrinhoProduto.getIdCarrinhoProduto()).build();
	}

	@Override
	public List<ProdutoCarrinhoListResponse> buscaTodosProdutosCarrinho(UUID idCliente, UUID idPedido) {
		log.info("[inicia] ProdutoCarrinhoApplicationService - buscaTodosProdutosCarrinho");
		pedidoService.buscaPedidoPorId(idCliente, idPedido);
		List<CarrinhoProduto> produtosCarrinho = produtoCarrinhoRepository.buscaTodosProdutosCarrinho();
		log.info("[finaliza] ProdutoCarrinhoApplicationService - buscaTodosProdutosCarrinho");
		return ProdutoCarrinhoListResponse.converte(produtosCarrinho);
	}

	@Override
	public ProdutoCarrinhoDetalhadoResponse buscaProdutoPorId(UUID idPedidoCarrinho) {
		log.info("[inicia] ProdutoRestController - buscaProdutoPorId");
		var produtoResponse = produtoCarrinhoRepository.buscaProdutoPorId(idPedidoCarrinho)
				.map(ProdutoCarrinhoDetalhadoResponse::converteProdutoCarrinhoParaResponse)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
		log.info("[finaliza] ProdutoRestController - buscaProdutoPorId");
		return produtoResponse;
	}

	@Override
	public void atualizaQuantidadeProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idPedidoCarrinho,
			ProdutoCarrinhoRequest produtoCarrinhoRequest) {
		log.info("[inicia] ProdutoCarrinhoApplicationService - atualizaQuantidadeProdutoCarrinho");
		PedidoDetalhadoResponse pedido = pedidoService.buscaPedidoPorId(idCliente, idPedido);
		CarrinhoProduto produto = produtoCarrinhoRepository.buscaProdutoPorId(idPedidoCarrinho)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
		produto.pertenceAoPedido(pedido);
		produto.alteraQuantidade(produto, produtoCarrinhoRequest);
		produtoCarrinhoRepository.salvaProdutoCarrinho(produto);
		atualizaTotalPedido(idCliente, idPedido);
		log.info("[finaliza] ProdutoCarrinhoApplicationService - atualizaQuantidadeProdutoCarrinho");
	}

	private void atualizaTotalPedido(UUID idCliente, UUID idPedido) {
		log.info("[inicia] ProdutoCarrinhoApplicationService - atualizaPedido");
		List<CarrinhoProduto> produtosCarrinho = produtoCarrinhoRepository.buscaTodosProdutosCarrinho();
		pedidoService.alteraPedido(idCliente, idPedido, produtosCarrinho);
		log.info("[finaliza] ProdutoCarrinhoApplicationService - atualizaPedido");
	}

	@Override
	public void removeProdutoCarrinho(UUID idCliente, UUID idPedido, UUID idPedidoCarrinho) {
		log.info("[inicia] ProdutoCarrinhoApplicationService - removeProdutoCarrinho");
		PedidoDetalhadoResponse pedido = pedidoService.buscaPedidoPorId(idCliente, idPedido);
		CarrinhoProduto produto = produtoCarrinhoRepository.buscaProdutoPorId(idPedidoCarrinho)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
		produto.pertenceAoPedido(pedido);
		produtoCarrinhoRepository.removeProdutoCarrinho(produto);
		atualizaTotalPedido(idCliente, idPedido);
		log.info("[finaliza] ProdutoCarrinhoApplicationService - removeProdutoCarrinho");
	}
}
