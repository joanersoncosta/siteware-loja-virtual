package br.com.siteware.conteudo.produto.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.siteware.conteudo.produto.domain.Produto;
import lombok.Value;

@Value
public class ProdutoPedidoListResponse {
	private UUID idProduto;
	private UUID idPedido;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidade;

	public ProdutoPedidoListResponse(Produto produro) {
		this.idProduto = produro.getIdProduto();
		this.idPedido = produro.getIdPedido();
		this.nome = produro.getNome();
		this.descricao = produro.getDescricao();
		this.preco = produro.getPreco();
		this.quantidade = produro.getQuantidade();
	}
	
	public static List<ProdutoPedidoListResponse> converte(List<Produto> produtos) {
		return produtos
				.stream()
				.map(ProdutoPedidoListResponse::new)
				.collect(Collectors.toList());
	}

}
