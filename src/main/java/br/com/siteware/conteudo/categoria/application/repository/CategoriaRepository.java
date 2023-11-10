package br.com.siteware.conteudo.categoria.application.repository;

import java.util.List;

import br.com.siteware.conteudo.categoria.domain.Categoria;

public interface CategoriaRepository {
	Categoria salvaCategoria(Categoria categoria);
	List<Categoria> buscaTodasCategorias();

}
