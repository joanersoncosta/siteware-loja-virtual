package br.com.siteware.conteudo.pedido.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PedidoRequest {
	@NotBlank
	@Size(message = "Campo descrição pedido não pode estar vazio", max = 255, min = 3)
	private String descricao;
}
