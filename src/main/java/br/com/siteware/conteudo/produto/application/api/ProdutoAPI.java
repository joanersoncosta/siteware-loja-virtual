package br.com.siteware.conteudo.produto.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.pedido.application.api.PedidoClienteListResponse;
import br.com.siteware.conteudo.pedido.application.api.PedidoDetalhadoResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pedido/{idPedido}")
public interface ProdutoAPI {
	
	@PostMapping(path = "/produto")
	@ResponseStatus(value = HttpStatus.CREATED)
	ProdutoIdResponse postProduto(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idPedido") UUID idPedido, @RequestBody @Valid ProdutoRequest produtoRequest);

	@GetMapping(path = "/produto/{idProduto}")
	@ResponseStatus(value = HttpStatus.OK)
	ProdutoDetalhadoResponse buscaProdutoPorId(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idPedido") UUID idPedido, @PathVariable(value = "idProduto") UUID idProduto);

	@GetMapping(path = "/produto")
	@ResponseStatus(value = HttpStatus.OK)
	List<ProdutoPedidoListResponse> buscaTodosProdutos(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idPedido") UUID idPedido);

}
