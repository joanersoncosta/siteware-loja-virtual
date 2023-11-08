package br.com.siteware.conteudo.cliente.infra;

import org.springframework.stereotype.Repository;

import br.com.siteware.conteudo.cliente.application.repository.ClientRepository;
import br.com.siteware.conteudo.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClienteInfraRepository implements ClientRepository {
	private final ClientSpringDataJPARepository clientSpringDataJPARepository;
	
	@Override
	public Cliente salvaCliente(Cliente cliente) {
		log.info("[inicia] ClienteController - postCliente");
		clientSpringDataJPARepository.save(cliente);
		log.info("[finaliza] ClienteController - postCliente");
		return cliente;
	}

}
