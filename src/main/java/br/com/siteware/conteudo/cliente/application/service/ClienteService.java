package br.com.siteware.conteudo.cliente.application.service;

import java.util.List;
import java.util.UUID;

import br.com.siteware.conteudo.cliente.application.api.ClienteDetalhadoResponse;
import br.com.siteware.conteudo.cliente.application.api.ClienteIdResponse;
import br.com.siteware.conteudo.cliente.application.api.ClienteListResponse;
import br.com.siteware.conteudo.cliente.application.api.ClienteRequest;

public interface ClienteService {
	ClienteIdResponse salvaCliente(ClienteRequest clienteRequest);
	List<ClienteListResponse> buscaTodasPessoas();
	ClienteDetalhadoResponse buscaClientePorId(UUID idCliente);

}
