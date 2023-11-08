package br.com.siteware.conteudo.pedido.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.siteware.conteudo.pedido.application.api.PedidoIdResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PedidoApplicationService implements PedidoService {
	
	@Override
	public PedidoIdResponse salvaPedido(UUID idCliente, @Valid PedidoRequest pedidoRequest) {
		log.info("[inicia] PedidoApplicationService - salvaPedido");
		log.info("[finaliza] PedidoApplicationService - salvaPedido");
		return null;
	}

}
