package br.com.siteware.conteudo.cliente.application.api;

import jakarta.validation.Valid;

public class ClienteController implements ClienteAPI {

	@Override
	public ClienteIdResponse postCliente(@Valid ClienteRequest ClienteRequest) {
		return null;
	}

}
