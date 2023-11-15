package br.com.siteware.conteudo.carrinho.domain;

import java.util.UUID;

import org.springframework.http.HttpStatus;

import br.com.siteware.conteudo.carrinho.application.api.ProdutoCarrinhoRequest;
import br.com.siteware.conteudo.carrinho.domain.enuns.StatusPromocao;
import br.com.siteware.conteudo.handler.APIException;
import br.com.siteware.conteudo.pedido.application.api.PedidoDetalhadoResponse;
import br.com.siteware.conteudo.produto.application.api.ProdutoDetalhadoResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	@Column(columnDefinition = "uuid", name = "idCliente", updatable = false)
	private UUID idCliente;
	@Column(columnDefinition = "uuid", name = "idPedido", updatable = false)
	private UUID idPedido;
	@Column(columnDefinition = "uuid", name = "idProduto", updatable = false, unique = true)
	private UUID idProduto;

	@NotNull
	@Column(unique = true)
	private String nome;
	@NotBlank
	@Size(message = "Campo descrição produto não pode estar vazio", max = 255, min = 3)
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusPromocao statusPromocao;
	private Double preco;
	private int quantidade;

	public CarrinhoProduto(UUID idCliente, UUID idPedido, UUID idProduto, ProdutoDetalhadoResponse produtoDetalhadoResponse,
			ProdutoCarrinhoRequest produtoRequest) {
		this.idCliente = idCliente;
		this.idPedido = idPedido;
		this.idProduto = idProduto;
		this.nome = produtoDetalhadoResponse.getNome();
		this.descricao = produtoDetalhadoResponse.getDescricao();
		this.statusPromocao = setStatusPromocao(produtoRequest.getQuantidade());
		this.preco = produtoDetalhadoResponse.getPreco();
		this.quantidade = produtoRequest.getQuantidade();
	}

	public void alteraQuantidade(CarrinhoProduto produto, ProdutoCarrinhoRequest produtoCarrinhoRequest) {
		this.quantidade = produtoCarrinhoRequest.getQuantidade();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.statusPromocao = setStatusPromocao(produtoCarrinhoRequest.getQuantidade());
		this.preco = produto.getPreco();
		this.quantidade = produtoCarrinhoRequest.getQuantidade();
	}

	public Double getSubTotal() {
		int diminuiQuantidade = quantidade;
		for (StatusPromocao valorCorrespondente : StatusPromocao.values()) {
			if (valorCorrespondente.getQuantidade() == quantidade) {
				diminuiQuantidade -= 1;
			}
		}
		return preco * diminuiQuantidade;
	}

	private StatusPromocao setStatusPromocao(int quantidade) {
		return StatusPromocao.valueOf(quantidade);
	}

	public void atualizaProdutoRequest(ProdutoDetalhadoResponse produtoAtualizado) {
		this.nome = produtoAtualizado.getNome();
		this.descricao = produtoAtualizado.getDescricao();
		this.statusPromocao = setStatusPromocao(quantidade);
		this.preco = produtoAtualizado.getPreco();
	}
	
	public void pertenceAoProduto(ProdutoDetalhadoResponse produto) {
		if (!this.idProduto.equals(produto.getIdProduto())) {
			throw APIException.build(HttpStatus.UNAUTHORIZED, "Produto não pertence ao Carrinho solicitado!");
		}
	}
	
	public void pertenceAoPedido(PedidoDetalhadoResponse pedido) {
		if (!this.idPedido.equals(pedido.getIdPedido())) {
			throw APIException.build(HttpStatus.UNAUTHORIZED, "Carrinho não pertence ao Pedido solicitado!");
		}
	}
}