package br.com.siteware.conteudo.pedido.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.cliente.application.service.ClienteService;
import br.com.siteware.conteudo.handler.APIException;
import br.com.siteware.conteudo.pedido.application.api.PedidoDetalhadoResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoIdResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoListDetalhadoResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoRequest;
import br.com.siteware.conteudo.pedido.application.repository.PedidoRepository;
import br.com.siteware.conteudo.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PedidoApplicationService implements PedidoService {
	private final PedidoRepository pedidoRepository;
	private final ClienteService clienteServicce;
	
	@Override
	public PedidoIdResponse salvaPedido(UUID idCliente, PedidoRequest pedidoRequest) {
		log.info("[inicia] PedidoApplicationService - salvaPedido");
		clienteServicce.buscaClientePorId(idCliente);
		Pedido pedido = pedidoRepository.salvaPedido(new Pedido(idCliente, pedidoRequest));
		log.info("[finaliza] PedidoApplicationService - salvaPedido");
		return PedidoIdResponse.builder().idPedido(pedido.getIdPedido()).build();
	}

	@Override
	public PedidoDetalhadoResponse buscaPedidoPorId(UUID idCliente, UUID idPedido) {
		log.info("[inicia] PedidoApplicationService - salvaPedido");
		clienteServicce.buscaClientePorId(idCliente);	
		Pedido pedido = pedidoRepository.buscaPedidoPorId(idPedido).orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pedido não encontrado!"));
		log.info("[finaliza] PedidoApplicationService - salvaPedido");
		return new PedidoDetalhadoResponse(pedido);
	}


}
