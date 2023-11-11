package br.com.siteware.conteudo.carrinho.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoIdResponse;
import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoListResponse;
import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoRequest;
import br.com.siteware.conteudo.carrinho.application.repository.ProdutoCarrinhoRepository;
import br.com.siteware.conteudo.carrinho.domain.CarrinhoProduto;
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
		ProdutoDetalhadoResponse produtoDetalhadoResponse = produtoService.buscaProdutoPorId(idProduto);
		CarrinhoProduto carrinhoProduto = produtoCarrinhoRepository.adicionaProdutoCarrinho(new CarrinhoProduto(idProduto, produtoDetalhadoResponse, produtoRequest));
		log.info("[finaliza] ProdutoCarrinhoApplicationService - adicionaProdutoCarrinho");
		return ProdutoCarrinhoIdResponse.builder().idCarrinhoProduto(carrinhoProduto.getIdCarrinhoProduto()).build();
	}

	@Override
	public List<ProdutoCarrinhoListResponse> buscaTodosProdutosCarrinho(UUID idCliente, UUID idPedido, UUID idProduto) {
		log.info("[inicia] ProdutoCarrinhoApplicationService - buscaTodosProdutosCarrinho");
		pedidoService.buscaPedidoPorId(idCliente, idPedido);
		produtoService.buscaProdutoPorId(idProduto);
		log.info("[finaliza] ProdutoCarrinhoApplicationService - buscaTodosProdutosCarrinho");
		return null;
	}

}
