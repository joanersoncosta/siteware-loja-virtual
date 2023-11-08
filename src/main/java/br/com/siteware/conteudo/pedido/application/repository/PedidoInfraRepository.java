package br.com.siteware.conteudo.pedido.application.repository;

import org.springframework.stereotype.Repository;

import br.com.siteware.conteudo.pedido.application.infra.PedidoSpringDataJPARepository;
import br.com.siteware.conteudo.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PedidoInfraRepository implements PedidoRepository {
	private final PedidoSpringDataJPARepository PedidoSpringDataJPARepository;
	@Override
	public Pedido salvaPedido(Pedido pedido) {
		log.info("[inicia] PedidoInfraRepository - salvaPedido");
		PedidoSpringDataJPARepository.save(pedido);
		log.info("[finaliza] PedidoInfraRepository - salvaPedido");
		return pedido;
	}

}
