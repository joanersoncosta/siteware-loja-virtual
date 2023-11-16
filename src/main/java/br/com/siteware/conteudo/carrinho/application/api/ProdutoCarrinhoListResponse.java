package br.com.siteware.conteudo.carrinho.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.siteware.conteudo.carrinho.domain.CarrinhoProduto;
import br.com.siteware.conteudo.carrinho.domain.enuns.StatusPromocao;
import jakarta.validation.constraints.Digits;
import lombok.Value;

@Value
public class ProdutoCarrinhoListResponse {
	private UUID idProdutoCarrinho;
	private String nome;
	private String descricao;
	private StatusPromocao statusPromocao;
	private Double preco;
	private Integer quantidade;
//	@Digits(integer=5, fraction=2)
	private Double subTotal;

	public ProdutoCarrinhoListResponse(CarrinhoProduto carrinhoProduto) {
		this.idProdutoCarrinho = carrinhoProduto.getIdCarrinhoProduto();
		this.nome = carrinhoProduto.getNome();
		this.descricao = carrinhoProduto.getDescricao();
		this.statusPromocao = carrinhoProduto.getStatusPromocao();
		this.preco = carrinhoProduto.getPreco();
		this.quantidade = carrinhoProduto.getQuantidade();
		this.subTotal = carrinhoProduto.getSubTotal();
	}

	public static List<ProdutoCarrinhoListResponse> converte(List<CarrinhoProduto> produtosCarrinho) {
		return produtosCarrinho
				.stream()
				.map(ProdutoCarrinhoListResponse::new)
				.collect(Collectors.toList());
	}
}
