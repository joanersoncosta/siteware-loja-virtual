package br.com.siteware.conteudo.pedido.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PedidoAlteracaoRequest {
	@NotBlank
	private String descricao;
}
