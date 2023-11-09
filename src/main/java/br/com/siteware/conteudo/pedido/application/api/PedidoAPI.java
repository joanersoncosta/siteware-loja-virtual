package br.com.siteware.conteudo.pedido.application.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pedido")
public interface PedidoAPI {
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	PedidoIdResponse postPedido(@PathVariable(value = "idCliente") UUID idCliente, @RequestBody @Valid PedidoRequest pedidoRequest);
	@GetMapping(path = "/{idPedido}")
	@ResponseStatus(value = HttpStatus.CREATED)
	PedidoDetalhadoResponse buscaPedidoPorId(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idPedido") UUID idPedido);
}
