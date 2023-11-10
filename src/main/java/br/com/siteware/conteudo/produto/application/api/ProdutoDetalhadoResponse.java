package br.com.siteware.conteudo.produto.application.api;

import java.util.UUID;

import br.com.siteware.conteudo.produto.domain.Produto;
import lombok.Value;

@Value
public class ProdutoDetalhadoResponse {
	private UUID idProduto;
	private UUID idCategoria;
	private String nome;
	private String descricao;

	public ProdutoDetalhadoResponse(Produto produro) {
		this.idProduto = produro.getIdProduto();
		this.idCategoria = produro.getIdCategoria();
		this.nome = produro.getNome();
		this.descricao = produro.getDescricao();
	}
	
}
