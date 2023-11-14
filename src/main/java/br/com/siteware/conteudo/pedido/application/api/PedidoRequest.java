package br.com.siteware.conteudo.pedido.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PedidoRequest {
	@NotBlank
	@Size(message = "Campo descrição pedido não pode estar vazio", max = 255, min = 3)
	private String descricao;
}
