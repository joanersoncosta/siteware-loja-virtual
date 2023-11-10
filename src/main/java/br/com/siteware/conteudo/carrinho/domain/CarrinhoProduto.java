package br.com.siteware.conteudo.carrinho.domain;

import java.util.UUID;

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
	@NotNull
	@Column(columnDefinition = "uuid", name = "idProduto", nullable = false, unique = true)
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
	
	public CarrinhoProduto(UUID idCarrinhoProduto, @NotNull UUID idProduto, @NotNull String nome,
			@NotBlank @Size(message = "Campo descrição produto não pode estar vazio", max = 255, min = 3) String descricao,
			Double preco, Integer quantidade, Double subTotal) {
		this.idCarrinhoProduto = idProduto;
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.subTotal = subTotal;
	}
	
	
}
