package br.com.siteware.conteudo.pedido.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siteware.conteudo.pedido.domain.Pedido;

public interface PedidoSpringDataJPARepository extends JpaRepository<Pedido, UUID>{

}
