package br.com.siteware.conteudo.cliente.application.service;

import br.com.siteware.conteudo.cliente.application.api.ClienteIdResponse;
import br.com.siteware.conteudo.cliente.application.api.ClienteRequest;

public interface ClienteService {
	ClienteIdResponse salvaCliente(ClienteRequest clienteRequest);

}
