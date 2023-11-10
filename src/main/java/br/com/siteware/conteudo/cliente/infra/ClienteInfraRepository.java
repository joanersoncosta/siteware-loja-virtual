package br.com.siteware.conteudo.cliente.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.siteware.conteudo.cliente.application.repository.ClientRepository;
import br.com.siteware.conteudo.cliente.domain.Cliente;
import br.com.siteware.conteudo.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClienteInfraRepository implements ClientRepository {
	private final ClientSpringDataJPARepository clientSpringDataJPARepository;
	
	@Override
	public Cliente salvaCliente(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - postCliente");
		try {
			clientSpringDataJPARepository.save(cliente);
		}catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Cliente já cadastrada");
		}
		log.info("[finaliza] ClienteInfraRepository - postCliente");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodasPessoas() {
		log.info("[inicia] ClienteInfraRepository - buscaTodasPessoas");
		List<Cliente> todosClientes = clientSpringDataJPARepository.findAll();
		log.info("[inicia] ClienteInfraRepository - buscaTodasPessoas");
		return todosClientes;
	}

	@Override
	public Optional<Cliente> buscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteInfraRepository - buscaTodasPessoas");
		Optional<Cliente> cliente = clientSpringDataJPARepository.findById(idCliente);
		log.info("[inicia] ClienteInfraRepository - buscaTodasPessoas");
		return cliente;
	}

	@Override
	public void deletaClientePorId(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - buscaTodasPessoas");
		clientSpringDataJPARepository.delete(cliente);
		log.info("[inicia] ClienteInfraRepository - buscaTodasPessoas");
		
	}

}
