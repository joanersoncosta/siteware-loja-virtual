package br.com.siteware.conteudo.pedido.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.siteware.conteudo.pedido.domain.Pedido;

public interface PedidoRepository {
	Pedido salvaPedido(Pedido pedido);
	Optional<Pedido> buscaPedidoPorId(UUID idPedido);
	List<Pedido> buscaTodosPedidosPorId();
	void deletePedidoPorId(Pedido pedido);
}