package br.com.siteware.conteudo.carrinho.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProdutoCarrinhoRequest {
	@NotNull
	private int quantidade;
}
