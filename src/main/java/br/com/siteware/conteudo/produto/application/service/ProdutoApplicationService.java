package br.com.siteware.conteudo.produto.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.pedido.application.service.PedidoService;
import br.com.siteware.conteudo.produto.application.api.ProdutoIdResponse;
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
		log.info("[idPedido] {}", idPedido);
		pedidoService.buscaPedidoPorId(idCliente, idPedido);
		Produto produto = produtoRepository.salvaProduto(new Produto(idPedido, produtoRequest));
		log.info("[finaliza] ProdutoRestController - postProduto");
		return ProdutoIdResponse.builder().idProduto(produto.getIdProduto()).build();
	}

}
