package br.com.siteware.conteudo.produto.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.categoria.application.api.CategoriaDetalhadoResponse;
import br.com.siteware.conteudo.categoria.application.service.CategoriaService;
import br.com.siteware.conteudo.handler.APIException;
import br.com.siteware.conteudo.pedido.application.service.PedidoService;
import br.com.siteware.conteudo.produto.application.api.ProdutoAlteracaoRequest;
import br.com.siteware.conteudo.produto.application.api.ProdutoDetalhadoResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoIdResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoCategoriaListResponse;
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
	private final CategoriaService categoriaService;

	@Override
	public ProdutoIdResponse salvaProduto(UUID idCategoria, ProdutoRequest produtoRequest) {
		log.info("[inicia] ProdutoRestController - postProduto");
		categoriaService.buscaCategoriaPorId(idCategoria);
		Produto produto = produtoRepository.salvaProduto(new Produto(idCategoria, produtoRequest));
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
	public List<ProdutoCategoriaListResponse> buscaTodosProdutos(UUID idCategoria) {
		log.info("[inicia] ProdutoRestController - buscaTodosProdutos");
		categoriaService.buscaCategoriaPorId(idCategoria);
		List<Produto>  produtos = produtoRepository.buscaTodosProdutos();
		log.info("[finaliza] ProdutoRestController - buscaTodosProdutos");
		return ProdutoCategoriaListResponse.converte(produtos);
	}

	@Override
	public void deleteProdutoPorId(UUID idCliente, UUID idPedido, UUID idProduto) {
		log.info("[inicia] ProdutoRestController - deleteProdutoPorId");
		pedidoService.buscaPedidoPorId(idCliente, idPedido);
		Produto produto = produtoRepository.buscaProdutoPorId(idProduto).orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
		produtoRepository.deleteProdutoPorId(produto);
		log.info("[finaliza] ProdutoRestController - deleteProdutoPorId");
	}

	@Override
	public void alteraProduto(UUID idCliente, UUID idPedido, UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest) {
		log.info("[inicia] ProdutoRestController - alteraProduto");
		pedidoService.buscaPedidoPorId(idCliente, idPedido);
		Produto produto = produtoRepository.buscaProdutoPorId(idProduto).orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
		produto.altera(produtoAlteracaoRequest);
		produtoRepository.salvaProduto(produto);
		log.info("[finaliza] ProdutoRestController - alteraProduto");
	}

}
