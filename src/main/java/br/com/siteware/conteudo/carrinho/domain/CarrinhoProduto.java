package br.com.siteware.conteudo.carrinho.domain;

import java.util.UUID;

import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoRequest;
import br.com.siteware.conteudo.produto.application.api.ProdutoDetalhadoResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "carrinho_produto")
public class CarrinhoProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idCarrinhoProduto", updatable = false, unique = true, nullable = false)
	private UUID idCarrinhoProduto;
	@Column(columnDefinition = "uuid", name = "idProduto", updatable = false, unique = true)
	private UUID idProduto;

	@NotNull
	@Column(unique = true)
	private String nome;
	@NotBlank
	@Size(message = "Campo descrição produto não pode estar vazio", max = 255, min = 3)
	private String descricao;
	private Double preco;
	private Integer quantidade;
	private Double subTotal;
	
	public CarrinhoProduto(UUID idProduto, ProdutoDetalhadoResponse produtoDetalhadoResponse,
			ProdutoCarrinhoRequest produtoRequest) {
		this.idProduto = idProduto;
		this.nome = produtoDetalhadoResponse.getNome();
		this.descricao = produtoDetalhadoResponse.getDescricao();
		this.preco = produtoDetalhadoResponse.getPreco();
		this.quantidade = produtoRequest.getQuantidade();
		this.subTotal = 0.0;
	}
}
