package br.com.siteware.conteudo.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.cliente.application.service.ClienteService;
import jakarta.validation.Valid;
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

	@Override
	public List<ClienteListResponse> getTodasClientes() {
		log.info("[inicia] ClienteController - getTodasClientes");
		List<ClienteListResponse> clientes = serviceCliente.buscaTodasPessoas();		
		log.info("[finaliza] ClienteController - getTodasClientes");		
		return clientes;
	}

	@Override
	public ClienteDetalhadoResponse getBuscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteController - getBuscaClientePorId");
		log.info("[idCliente] {}", idCliente);
		ClienteDetalhadoResponse clienteDetalhado = serviceCliente.buscaClientePorId(idCliente);		
		log.info("[finaliza] ClienteController - getBuscaClientePorId");		
		return clienteDetalhado;
	}

	@Override
	public void deletaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteController - deletaClientePorId");
		log.info("[idCliente] {}", idCliente);
		serviceCliente.deletaClientePorId(idCliente);		
		log.info("[finaliza] ClienteController - deletaClientePorId");		
		
	}

	@Override
	public void patchAlteraPessoa(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[inicia] ClienteController - patchAlteraPessoa");
		log.info("[idCliente] {}", idCliente);
		serviceCliente.patchAlteraPessoa(idCliente, clienteAlteracaoRequest);		
		log.info("[finaliza] ClienteController - patchAlteraPessoa");		
	}

}
