package br.com.siteware.conteudo.cliente.application.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
	private final ClienteService serviceCliente;

	@Override
	public ClienteIdResponse postCliente(ClienteRequest ClienteRequest) {
		log.info("[inicia] ClienteController - postCliente");
		ClienteIdResponse clienteId = serviceCliente.salvaCliente(ClienteRequest);
		log.info("[finaliza] ClienteController - postCliente");
		return clienteId;
	}

}
