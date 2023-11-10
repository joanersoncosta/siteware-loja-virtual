package br.com.siteware.conteudo.pedido.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.siteware.conteudo.handler.APIException;
import br.com.siteware.conteudo.pedido.application.repository.PedidoRepository;
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
		try {
			PedidoSpringDataJPARepository.save(pedido);
		}catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Pedido já cadastrada");
		}
		log.info("[finaliza] PedidoInfraRepository - salvaPedido");
		return pedido;
	}

	@Override
	public Optional<Pedido> buscaPedidoPorId(UUID idPedido) {
		log.info("[inicia] PedidoInfraRepository - buscaPedidoPorId");
		Optional<Pedido> pedido = PedidoSpringDataJPARepository.findById(idPedido);
		log.info("[finaliza] PedidoInfraRepository - buscaPedidoPorId");
		return pedido;
	}

	@Override
	public List<Pedido> buscaTodosPedidosPorId() {
		log.info("[inicia] PedidoInfraRepository - buscaTodosPedidosPorId");
		List<Pedido> pedidos = PedidoSpringDataJPARepository.findAll();
		log.info("[finaliza] PedidoInfraRepository - buscaTodosPedidosPorId");
			return pedidos;
	}

	@Override
	public void deletePedidoPorId(Pedido pedido) {
		log.info("[inicia] PedidoInfraRepository - deletePedidoPorId");
		PedidoSpringDataJPARepository.delete(pedido);
		log.info("[finaliza] PedidoInfraRepository - deletePedidoPorId");
		
	}
}
