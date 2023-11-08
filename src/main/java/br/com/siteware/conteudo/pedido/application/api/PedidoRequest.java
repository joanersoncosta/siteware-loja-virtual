package br.com.siteware.conteudo.pedido.application.api;

import br.com.siteware.conteudo.pedido.domain.enuns.PedidoStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class PedidoRequest {
	@NotNull
	private PedidoStatus pedidoStatus;

}
