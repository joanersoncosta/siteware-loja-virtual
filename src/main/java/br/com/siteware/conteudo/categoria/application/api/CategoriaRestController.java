package br.com.siteware.conteudo.categoria.application.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@RestController
@Log4j2
public class CategoriaRestController implements CategoriaAPI {

	@Override
	public CategoriaIdResponse postCategoria(CategoriaRequest CategoriaRequest) {
		log.info("[inicia] CategoriaRestController - postCategoria");
		log.info("[finaliza] CategoriaRestController - postCategoria");
		return null;
	}

}
