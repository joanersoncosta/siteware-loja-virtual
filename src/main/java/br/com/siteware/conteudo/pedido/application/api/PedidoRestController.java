package br.com.siteware.conteudo.pedido.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.pedido.application.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PedidoRestController implements PedidoAPI {
	private final PedidoService pedidoService;
	
	@Override
	public PedidoIdResponse postPedido(UUID idCliente, PedidoRequest pedidoRequest) {
	log.info("[inicia] PedidoRestController - postPedido");
	log.info("[idCliente] {}", idCliente);
	PedidoIdResponse pedidoIdResponse = pedidoService.salvaPedido(idCliente, pedidoRequest);
	log.info("[finaliza] PedidoRestController - postPedido");
	return pedidoIdResponse;
	}
	
	@Override
	public PedidoDetalhadoResponse buscaPedidoPorId(UUID idCliente, UUID idPedido) {
		log.info("[inicia] PedidoRestController - buscaPedidoPorId");
		log.info("[idCliente] {}, [idPedido] {}", idCliente, idPedido);	
		PedidoDetalhadoResponse pedidoResponse = pedidoService.buscaPedidoPorId(idCliente, idPedido);
		log.info("[finaliza] PedidoRestController - buscaPedidoPorId");
		return pedidoResponse;
	}

	@Override
	public List<PedidoClienteListResponse> buscaTodosPedidosPorId(UUID idCliente) {
		log.info("[inicia] PedidoRestController - buscaTodosPedidosPorId");
		log.info("[idCliente] {}", idCliente);
		List<PedidoClienteListResponse> pedidos =  pedidoService.buscaTodosPedidosPorId(idCliente);
		log.info("[finaliza] PedidoRestController - buscaTodosPedidosPorId");
		return pedidos;
	}

	@Override
	public void deletePedidoPorId(UUID idCliente, UUID idPedido) {
		log.info("[inicia] PedidoRestController - deletePedidoPorId");
		log.info("[idCliente] {}, [idPedido] {}", idCliente, idPedido);	
		pedidoService.deletePedidoPorId(idCliente, idPedido);
		log.info("[finaliza] PedidoRestController - deletePedidoPorId");
	}

	@Override
	public void patchPedido(UUID idCliente, UUID idPedido, PedidoAlteracaoRequest pedidoAlteracaoRequest) {
		log.info("[inicia] PedidoRestController - patchPedido");
		log.info("[idCliente] {}, [idPedido] {}", idCliente, idPedido);	
		pedidoService.alteraPedido(idCliente, idPedido, pedidoAlteracaoRequest);
		log.info("[finaliza] PedidoRestController - patchPedido");		
	}
}
