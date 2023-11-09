package br.com.siteware.conteudo.produto.application.api;

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
	public ProdutoIdResponse postProduto(UUID idPedido, ProdutoRequest produtoRequest) {
		log.info("[inicia] ProdutoRestController - postProduto");
		log.info("[idPedido] {}", idPedido);
		ProdutoIdResponse produtoIdResponse = produtoService.salvaProduto(idPedido, produtoRequest);
		log.info("[finaliza] ProdutoRestController - postProduto");
		return produtoIdResponse;
	}

}
