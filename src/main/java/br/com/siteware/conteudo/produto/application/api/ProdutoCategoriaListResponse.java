package br.com.siteware.conteudo.produto.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.siteware.conteudo.produto.domain.Produto;
import lombok.Value;

@Value
public class ProdutoCategoriaListResponse {
	private UUID idProduto;
	private String nome;
	private String descricao;

	public ProdutoCategoriaListResponse(Produto produro) {
		this.idProduto = produro.getIdProduto();
		this.nome = produro.getNome();
		this.descricao = produro.getDescricao();
	}
	
	public static List<ProdutoCategoriaListResponse> converte(List<Produto> produtos) {
		return produtos
				.stream()
				.map(ProdutoCategoriaListResponse::new)
				.collect(Collectors.toList());
	}

}
