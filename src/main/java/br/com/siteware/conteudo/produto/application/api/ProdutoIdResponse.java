package br.com.siteware.conteudo.produto.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ProdutoIdResponse {
	private UUID idProduto;
}
