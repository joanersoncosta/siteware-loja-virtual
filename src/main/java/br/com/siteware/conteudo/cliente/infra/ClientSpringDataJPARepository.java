package br.com.siteware.conteudo.cliente.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siteware.conteudo.cliente.domain.Cliente;

public interface ClientSpringDataJPARepository extends JpaRepository<Cliente, UUID>{

}
