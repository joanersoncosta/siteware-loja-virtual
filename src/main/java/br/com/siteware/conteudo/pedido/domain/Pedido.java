package br.com.siteware.conteudo.pedido.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import br.com.siteware.conteudo.carrinho.domain.CarrinhoProduto;
import br.com.siteware.conteudo.cliente.application.api.ClienteDetalhadoResponse;
import br.com.siteware.conteudo.handler.APIException;
import br.com.siteware.conteudo.pedido.application.api.PedidoAlteracaoRequest;
import br.com.siteware.conteudo.pedido.application.api.PedidoRequest;
import br.com.siteware.conteudo.pedido.domain.enuns.PedidoStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@Column(columnDefinition = "uuid", name = "idCliente", nullable = false, unique = true)
	private UUID idCliente;
	@NotNull
	@Enumerated(value = EnumType.STRING)
	private PedidoStatus pedidoStatus;
	@NotBlank
	@Size(message = "Campo descrição pedido não pode estar vazio", max = 255, min = 3)
	private String descricao;
	private LocalDateTime momentoDoPedido;
	private Double total = 0.0;

	public Pedido(UUID idCliente, PedidoRequest pedidoRequest) {
		this.idCliente = idCliente;
		this.pedidoStatus = PedidoStatus.PENDENTE;
		this.descricao = pedidoRequest.getDescricao();
		this.total = 0.0;
		this.momentoDoPedido = LocalDateTime.now();
	}

	public void alteraTotalPedido(List<CarrinhoProduto> carrinhoProdutos) {
		this.total = getTotalPedido(carrinhoProdutos);
		mudaStatusParaAguardandoPagamentoOrElseCancelado(total);
	}

	public void pertenceAoCliente(ClienteDetalhadoResponse cliente) {
		if (!this.idCliente.equals(cliente.getIdCliente())) {
			throw APIException.build(HttpStatus.UNAUTHORIZED, "Usuário não é dono do Pedido solicitado!");
		}
	}

	private Double getTotalPedido(List<CarrinhoProduto> carrinhoProdutos) {
		Double soma = carrinhoProdutos.stream()
				.map(p -> p.getSubTotal())
				.reduce(0.0, (x, y) -> x + y);
		return soma;
	}

	private PedidoStatus mudaStatusParaAguardandoPagamentoOrElseCancelado(Double total) {
		if (total > 0.0)
			return this.pedidoStatus = PedidoStatus.AGUARDANDO_PAGAMENTO;
		return this.pedidoStatus = PedidoStatus.CANCELADO;
	}
}
