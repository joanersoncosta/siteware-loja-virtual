package br.com.siteware.conteudo.pedido.application.api;

import java.util.UUID;

import jakarta.validation.Valid;

public class PedidoRestController implements EnderecoAPI {

	@Override
	public PedidoIdResponse postEndereco(UUID idCliente, @Valid PedidoRequest pedidoRequest) {
		
		return null;
	}

}
