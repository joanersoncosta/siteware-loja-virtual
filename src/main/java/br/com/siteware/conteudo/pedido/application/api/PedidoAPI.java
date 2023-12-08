package br.com.siteware.conteudo.pedido.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedido")
public interface PedidoAPI {
	
	@PostMapping(path = "/cria-pedido")
	@ResponseStatus(value = HttpStatus.CREATED)
	PedidoIdResponse postPedido(@RequestParam(value = "idCliente") UUID idCliente);
	
	@GetMapping(path = "/{idPedido}/busca-pedido")
	@ResponseStatus(value = HttpStatus.OK)
	PedidoDetalhadoResponse buscaPedidoPorId(@RequestParam(value = "idCliente") UUID idCliente, @PathVariable(value = "idPedido") UUID idPedido);

	@GetMapping(path = "/busca-pedidos")
	@ResponseStatus(value = HttpStatus.OK)
	List<PedidoClienteListResponse> buscaTodosPedidosPorId(@RequestParam(value = "idCliente") UUID idCliente);
	
	@DeleteMapping(path = "/{idPedido}/deleta-pedido")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void deletePedidoPorId(@RequestParam(value = "idCliente") UUID idCliente, @PathVariable(value = "idPedido") UUID idPedido);

}
