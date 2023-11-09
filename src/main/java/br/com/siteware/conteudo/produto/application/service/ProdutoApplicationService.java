package br.com.siteware.conteudo.produto.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.produto.application.api.ProdutoIdResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class ProdutoApplicationService implements ProdutoService {

	@Override
	public ProdutoIdResponse salvaProduto(UUID idPedido, ProdutoRequest produtoRequest) {
		log.info("[inicia] ProdutoRestController - postProduto");
		log.info("[idPedido] {}", idPedido);
		log.info("[finaliza] ProdutoRestController - postProduto");
		return null;
	}

}
