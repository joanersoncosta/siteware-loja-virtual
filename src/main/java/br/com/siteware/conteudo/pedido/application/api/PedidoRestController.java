package br.com.siteware.conteudo.pedido.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.pedido.application.service.PedidoService;
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
	public PedidoDetalhadoResponse postPedido(UUID idCliente, UUID idPedido) {
		log.info("[inicia] PedidoRestController - postPedido");
		log.info("[idCliente] {}", idCliente);		
		log.info("[finaliza] PedidoRestController - postPedido");
		return null;
	}
}
