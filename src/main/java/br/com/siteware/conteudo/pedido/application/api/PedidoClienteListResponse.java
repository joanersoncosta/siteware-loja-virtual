package br.com.siteware.conteudo.pedido.application.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.siteware.conteudo.pedido.domain.Pedido;
import br.com.siteware.conteudo.pedido.domain.enuns.PedidoStatus;
import lombok.Value;

@Value
public class PedidoClienteListResponse {

	private UUID idPedido;
	private UUID idCliente;
	private PedidoStatus pedidoStatus;
	private String descricao;
	private LocalDateTime momentoDoPedido;
	
	public PedidoClienteListResponse(Pedido pedido) {
		this.idPedido = pedido.getIdPedido();
		this.idCliente = pedido.getIdCliente();
		this.pedidoStatus = pedido.getPedidoStatus();
		this.descricao = pedido.getDescricao();
		this.momentoDoPedido = pedido.getMomentoDoPedido();
	}
	
	public static List<PedidoClienteListResponse> converte(List<Pedido> enderecosDaPessoa) {
		return enderecosDaPessoa
				.stream()
				.map(PedidoClienteListResponse::new)
				.collect(Collectors.toList());
	}
}
