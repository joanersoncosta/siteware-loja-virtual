package br.com.siteware.conteudo.produto.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.siteware.conteudo.produto.domain.Produto;
import lombok.Value;

@Value
public class ProdutoCategoriaListResponse {
	private UUID idProduto;
	private UUID idCategoria;
	private String nome;
	private String descricao;
	private Double preco;

	public ProdutoCategoriaListResponse(Produto produro) {
		this.idProduto = produro.getIdProduto();
		this.idCategoria = produro.getIdCategoria();
		this.nome = produro.getNome();
		this.descricao = produro.getDescricao();
		this.preco = produro.getPreco();
	}
	
	public static List<ProdutoCategoriaListResponse> converte(List<Produto> produtos) {
		return produtos
				.stream()
				.map(ProdutoCategoriaListResponse::new)
				.collect(Collectors.toList());
	}

}
