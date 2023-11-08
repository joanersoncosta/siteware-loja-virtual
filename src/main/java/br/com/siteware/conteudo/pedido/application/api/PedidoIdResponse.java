package br.com.siteware.conteudo.pedido.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PedidoIdResponse {
	private UUID idPedido;
}
