package br.com.siteware.conteudo.produto.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@RestController
@Log4j2
public class ProdutoRestController implements ProdutoAPI {

	@Override
	public ProdutoIdResponse postProduto(UUID idPedido, @Valid ProdutoRequest produtoRequest) {
		log.info("[inicia] ProdutoRestController - postProduto");
		log.info("[idPedido] {}", idPedido);
		log.info("[finaliza] ProdutoRestController - postProduto");
		return null;
	}

}
