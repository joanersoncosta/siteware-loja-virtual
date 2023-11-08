package br.com.siteware.conteudo.cliente.application.service;

import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.cliente.application.api.ClienteIdResponse;
import br.com.siteware.conteudo.cliente.application.api.ClienteRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClienteApplicationService implements ClienteService {

	@Override
	public ClienteIdResponse salvaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - postCliente");
		log.info("[finaliza] ClienteController - postCliente");
		return null;
	}

}
