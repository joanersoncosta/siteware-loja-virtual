package br.com.siteware.conteudo.produto.domain;

import java.util.UUID;

import br.com.siteware.conteudo.categoria.application.api.CategoriaDetalhadoResponse;
import br.com.siteware.conteudo.categoria.domain.Categoria;
import br.com.siteware.conteudo.produto.application.api.ProdutoAlteracaoRequest;
import br.com.siteware.conteudo.produto.application.api.ProdutoRequest;
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
	@Column(columnDefinition = "uuid", name = "idCategoria", nullable = false)
	private UUID idCategoria;
	@NotNull
	private String nome;
	@NotBlank
	@Size(message = "Campo descrição produto não pode estar vazio", max = 255, min = 3)
	private String descricao;
	
	public Produto(UUID idCategoria, ProdutoRequest produtoRequest) {
		this.idCategoria = idCategoria;
		this.nome = produtoRequest.getNome();
		this.descricao = produtoRequest.getDescricao();
	}

	public void altera(ProdutoAlteracaoRequest produtoAlteracaoRequest) {
		this.nome = produtoAlteracaoRequest.getNome();
		this.descricao = produtoAlteracaoRequest.getDescricao();
	}
	
}