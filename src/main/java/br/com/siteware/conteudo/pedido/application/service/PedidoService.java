package br.com.siteware.conteudo.pedido.application.service;

import java.util.List;
import java.util.UUID;

import br.com.siteware.conteudo.carrinho.domain.CarrinhoProduto;
import br.com.siteware.conteudo.pedido.application.api.PedidoClienteListResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoDetalhadoResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoIdResponse;

public interface PedidoService {
	PedidoIdResponse salvaPedido(UUID idCliente);
	PedidoDetalhadoResponse buscaPedidoPorId(UUID idCliente, UUID idPedido);
	List<PedidoClienteListResponse> buscaTodosPedidosPorId(UUID idCliente);
	void deletePedidoPorId(UUID idCliente, UUID idPedido);
	void alteraPedido(UUID idCliente, UUID idPedido, List<CarrinhoProduto> carrinhoProdutos);
}
