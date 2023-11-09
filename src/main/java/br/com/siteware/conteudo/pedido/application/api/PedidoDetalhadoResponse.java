package br.com.siteware.conteudo.pedido.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.siteware.conteudo.pedido.domain.Pedido;
import br.com.siteware.conteudo.pedido.domain.enuns.PedidoStatus;
import lombok.Value;

@Value
public class PedidoDetalhadoResponse {
	private UUID idPedido;
	private UUID idCliente;
	private PedidoStatus pedidoStatus;
	private String descricao;
	private LocalDateTime momentoDoPedido;
	
	public PedidoDetalhadoResponse(Pedido pedido) {
		this.idPedido = pedido.getIdPedido();
		this.idCliente = pedido.getIdCliente();
		this.pedidoStatus = pedido.getPedidoStatus();
		this.descricao = pedido.getDescricao();
		this.momentoDoPedido = pedido.getMomentoDoPedido();
	}

}
