package br.com.siteware.conteudo.cliente.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ClienteIdResponse {
	private UUID idCliente;
}
