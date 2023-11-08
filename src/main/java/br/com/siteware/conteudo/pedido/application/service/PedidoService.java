package br.com.siteware.conteudo.pedido.application.service;

import java.util.UUID;

import br.com.siteware.conteudo.pedido.application.api.PedidoIdResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoRequest;
import jakarta.validation.Valid;

public interface PedidoService {
	PedidoIdResponse salvaPedido(UUID idCliente, @Valid PedidoRequest pedidoRequest);

}
