package br.com.siteware.conteudo.categoria.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.categoria.application.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@RestController
@Log4j2
public class CategoriaRestController implements CategoriaAPI {
	private final CategoriaService CategoriaService;
	
	@Override
	public CategoriaIdResponse postCategoria(CategoriaRequest CategoriaRequest) {
		log.info("[inicia] CategoriaRestController - postCategoria");
		CategoriaIdResponse categoriaIdResponse = CategoriaService.salvaCategoria(CategoriaRequest);
		log.info("[finaliza] CategoriaRestController - postCategoria");
		return categoriaIdResponse;
	}

	@Override
	public List<CategoriaListResponse> buscaTodasCategorias() {
		log.info("[inicia] CategoriaRestController - buscaTodasCategorias");
		List<CategoriaListResponse> categorias = CategoriaService.buscaTodasCategorias();
		log.info("[finaliza] CategoriaRestController - buscaTodasCategorias");
		return null;
	}

}