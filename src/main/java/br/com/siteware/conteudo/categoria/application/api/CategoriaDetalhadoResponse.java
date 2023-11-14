package br.com.siteware.conteudo.categoria.application.api;

import java.util.UUID;

import br.com.siteware.conteudo.categoria.domain.Categoria;
import lombok.Value;

@Value
public class CategoriaDetalhadoResponse {
	private UUID idCategoria;
	private String nome;
	
	private CategoriaDetalhadoResponse(Categoria categoria) {
		this.idCategoria = categoria.getIdCategoria();
		this.nome = categoria.getNome();
	}
	
	public static CategoriaDetalhadoResponse converteCategoriaParaResponse(Categoria categoria) {
		return new CategoriaDetalhadoResponse(categoria);
	}
}
