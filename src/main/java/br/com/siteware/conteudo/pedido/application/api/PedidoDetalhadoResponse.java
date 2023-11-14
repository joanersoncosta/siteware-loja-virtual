package br.com.siteware.conteudo.pedido.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.siteware.conteudo.pedido.domain.Pedido;
import br.com.siteware.conteudo.pedido.domain.enuns.PedidoStatus;
import jakarta.validation.constraints.Digits;
import lombok.Value;

@Value
public class PedidoDetalhadoResponse {
	private UUID idPedido;
	private UUID idCliente;
	private PedidoStatus pedidoStatus;
	private String descricao;
	@Digits(integer=5, fraction=2)
	private Double total;

	private LocalDateTime momentoDoPedido;
	
	private PedidoDetalhadoResponse(Pedido pedido) {
		this.idPedido = pedido.getIdPedido();
		this.idCliente = pedido.getIdCliente();
		this.pedidoStatus = pedido.getPedidoStatus();
		this.descricao = pedido.getDescricao();
		this.total = pedido.getTotal();
		this.momentoDoPedido = pedido.getMomentoDoPedido();
	}
	
	public static PedidoDetalhadoResponse convertePedidoParaResponse(Pedido pedido) {
		return new PedidoDetalhadoResponse(pedido);
	}

}
