package br.com.siteware.conteudo.cliente.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.siteware.conteudo.cliente.domain.Cliente;

public interface ClientRepository {
	Cliente salvaCliente(Cliente cliente);
	List<Cliente> buscaTodasPessoas();

}
