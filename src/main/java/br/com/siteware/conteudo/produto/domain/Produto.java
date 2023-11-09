package br.com.siteware.conteudo.produto.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Produto{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idProduto", updatable = false, unique = true, nullable = false)
	private UUID idProduto;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idPedido", nullable = false)
	private UUID idPedido;
	@NotNull
	private String nomeItem;
	@NotBlank
	@Size(message = "Campo descrição produto não pode estar vazio", max = 255, min = 3)
	private String descricao;
	@NotNull
	private Double preco;
	@NotNull
	private Integer quantidade;
}
