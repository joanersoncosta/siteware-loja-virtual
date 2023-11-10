package br.com.siteware.conteudo.categoria.application.service;

import java.util.List;

import br.com.siteware.conteudo.categoria.application.api.CategoriaIdResponse;
import br.com.siteware.conteudo.categoria.application.api.CategoriaListResponse;
import br.com.siteware.conteudo.categoria.application.api.CategoriaRequest;

public interface CategoriaService {

	CategoriaIdResponse salvaCategoria(CategoriaRequest categoriaRequest);
	List<CategoriaListResponse> buscaTodasCategorias();

}
