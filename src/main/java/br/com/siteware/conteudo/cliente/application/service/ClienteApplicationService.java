package br.com.siteware.conteudo.cliente.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.cliente.application.api.ClienteDetalhadoResponse;
import br.com.siteware.conteudo.cliente.application.api.ClienteIdResponse;
import br.com.siteware.conteudo.cliente.application.api.ClienteListResponse;
import br.com.siteware.conteudo.cliente.application.api.ClienteRequest;
import br.com.siteware.conteudo.cliente.application.repository.ClientRepository;
import br.com.siteware.conteudo.cliente.domain.Cliente;
import br.com.siteware.conteudo.handler.APIException;
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

	@Override
	public List<ClienteListResponse> buscaTodasPessoas() {
		log.info("[inicia] ClienteApplicationService - buscaTodasPessoas");
		List<Cliente> clientes = clientRepository.buscaTodasPessoas();
		log.info("[finaliza] ClienteApplicationService - buscaTodasPessoas");
		return ClienteListResponse.converteListaClientes(clientes);
	}

	@Override
	public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - buscaClientePorId");
		Cliente cliente = clientRepository.buscaClientePorId(idCliente).orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
		log.info("[finaliza] ClienteApplicationService - buscaClientePorId");
		return new ClienteDetalhadoResponse(cliente);
	}

	@Override
	public void deletaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - deletaClientePorId");
		Cliente cliente = clientRepository.buscaClientePorId(idCliente).orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
		clientRepository.deletaClientePorId(cliente);
		log.info("[finaliza] ClienteApplicationService - deletaClientePorId");
	}

}
