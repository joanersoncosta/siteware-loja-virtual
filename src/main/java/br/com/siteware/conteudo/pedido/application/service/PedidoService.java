package br.com.siteware.conteudo.pedido.application.service;

import java.util.UUID;

import br.com.siteware.conteudo.pedido.application.api.PedidoDetalhadoResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoIdResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoRequest;

public interface PedidoService {
	PedidoIdResponse salvaPedido(UUID idCliente, PedidoRequest pedidoRequest);
	PedidoDetalhadoResponse busbuscaPedidoPorId(UUID idCliente, UUID idPedido);

}
