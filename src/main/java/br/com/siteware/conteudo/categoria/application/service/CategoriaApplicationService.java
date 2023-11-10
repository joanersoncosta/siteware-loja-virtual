package br.com.siteware.conteudo.categoria.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.categoria.application.api.CategoriaIdResponse;
import br.com.siteware.conteudo.categoria.application.api.CategoriaListResponse;
import br.com.siteware.conteudo.categoria.application.api.CategoriaRequest;
import br.com.siteware.conteudo.categoria.application.repository.CategoriaRepository;
import br.com.siteware.conteudo.categoria.domain.Categoria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CategoriaApplicationService implements CategoriaService {
	private final CategoriaRepository categoriaRepository;
	
	@Override
	public CategoriaIdResponse salvaCategoria(CategoriaRequest categoriaRequest) {
		log.info("[inicia] CategoriaApplicationService - salvaCategoria");
		Categoria categoria = categoriaRepository.salvaCategoria(new Categoria(categoriaRequest));
		log.info("[finaliza] CategoriaApplicationService - salvaCategoria");
		return CategoriaIdResponse.builder().idCategoria(categoria.getIdCategoria()).build();
	}

	@Override
	public List<CategoriaListResponse> buscaTodasCategorias() {
		log.info("[inicia] CategoriaApplicationService - buscaTodasCategorias");
		log.info("[finaliza] CategoriaApplicationService - buscaTodasCategorias");
		return null;
	}

}
