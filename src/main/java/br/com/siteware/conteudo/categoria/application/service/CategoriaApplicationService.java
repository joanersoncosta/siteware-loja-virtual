package br.com.siteware.conteudo.categoria.application.service;

import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.categoria.application.api.CategoriaIdResponse;
import br.com.siteware.conteudo.categoria.application.api.CategoriaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CategoriaApplicationService implements CategoriaService {

	@Override
	public CategoriaIdResponse salvaCategoria(CategoriaRequest categoriaRequest) {
		log.info("[inicia] CategoriaApplicationService - salvaCategoria");
		log.info("[finaliza] CategoriaApplicationService - salvaCategoria");
		return null;
	}

}
