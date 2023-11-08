package br.com.siteware.conteudo.cliente.application.repository;

import java.util.List;

import br.com.siteware.conteudo.cliente.domain.Cliente;

public interface ClientRepository {
	Cliente salvaCliente(Cliente cliente);
	List<Cliente> buscaTodasPessoas();

}
