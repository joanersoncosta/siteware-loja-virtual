package br.com.siteware.conteudo.cliente.application.service;

import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.cliente.application.api.ClienteIdResponse;
import br.com.siteware.conteudo.cliente.application.api.ClienteRequest;
import br.com.siteware.conteudo.cliente.application.repository.ClientRepository;
import br.com.siteware.conteudo.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClienteApplicationService implements ClienteService {
private final ClientRepository clientRepository;
	
	@Override
	public ClienteIdResponse salvaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationService - salvaCliente");
		Cliente cliente = clientRepository.salvaCliente(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicationService - salvaCliente");
		return ClienteIdResponse.builder().idCliente(cliente.getIdCliente()).build();
	}

}
