package br.com.siteware.conteudo.pedido.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.siteware.conteudo.pedido.application.api.PedidoRequest;
import br.com.siteware.conteudo.pedido.domain.enuns.PedidoStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idPedido", updatable = false, unique = true, nullable = false)
	private UUID idPedido;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idCliente", nullable = false)
	private UUID idCliente;
	@NotNull
	@Enumerated(value = EnumType.STRING)
	private PedidoStatus pedidoStatus;
	private LocalDateTime momentoDoPedido;

	public Pedido(UUID idCliente, @Valid PedidoRequest pedidoRequest) {
		this.idCliente = idCliente;
		this.pedidoStatus = pedidoRequest.getPedidoStatus();
		this.momentoDoPedido = LocalDateTime.now();
	}

}
