package br.com.siteware.conteudo.pedido.application.service;

import java.util.List;
import java.util.UUID;

import br.com.siteware.conteudo.pedido.application.api.PedidoDetalhadoResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoIdResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoListDetalhadoResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoRequest;

public interface PedidoService {
	PedidoIdResponse salvaPedido(UUID idCliente, PedidoRequest pedidoRequest);
	PedidoDetalhadoResponse buscaPedidoPorId(UUID idCliente, UUID idPedido);
	List<PedidoListDetalhadoResponse> buscaTodosPedidosPorId(UUID idCliente);

}
