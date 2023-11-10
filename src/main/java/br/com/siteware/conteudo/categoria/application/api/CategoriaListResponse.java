package br.com.siteware.conteudo.categoria.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.siteware.conteudo.categoria.domain.Categoria;
import lombok.Value;

@Value
public class CategoriaListResponse {
	private UUID idCategoria;
	private String nome;
	
	public CategoriaListResponse(Categoria categoria) {
		this.idCategoria = categoria.getIdCategoria();
		this.nome = categoria.getNome();
	}
	
	public static List<CategoriaListResponse> converte(List<Categoria> categorias) {
		return categorias
				.stream()
				.map(CategoriaListResponse::new)
				.collect(Collectors.toList());	}
}
