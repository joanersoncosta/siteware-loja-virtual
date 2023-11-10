package br.com.siteware.conteudo.produto.application.api;

import java.util.UUID;

import br.com.siteware.conteudo.produto.domain.Produto;
import lombok.Value;

@Value
public class ProdutoDetalhadoResponse {
	private UUID idProduto;
	private UUID idPedido;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidade;
	private Double subTotal;

	public ProdutoDetalhadoResponse(Produto produro) {
		this.idProduto = produro.getIdProduto();
		this.idPedido = produro.getIdPedido();
		this.nome = produro.getNome();
		this.descricao = produro.getDescricao();
		this.preco = produro.getPreco();
		this.quantidade = produro.getQuantidade();
		this.subTotal = produro.getSubTotal();
	}
	
}
