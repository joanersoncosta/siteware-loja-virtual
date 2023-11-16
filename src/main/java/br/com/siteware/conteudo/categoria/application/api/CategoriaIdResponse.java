package br.com.siteware.conteudo.categoria.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoriaIdResponse {
	private UUID idCategoria;
}
