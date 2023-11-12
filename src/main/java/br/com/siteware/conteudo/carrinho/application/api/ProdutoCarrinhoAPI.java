package br.com.siteware.conteudo.carrinho.application.api;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carrinho-produto")
public interface ProdutoCarrinhoAPI {

	@PostMapping(path = "/cliente/{idCliente}/pedido/{idPedido}/produto/{idProduto}")
	@ResponseStatus(value = HttpStatus.CREATED)
	ProdutoCarrinhoIdResponse adicionaProdutoCarrinho(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idPedido") UUID idPedido, @PathVariable(value = "idProduto") UUID idProduto, @RequestBody @Valid ProdutoCarrinhoRequest produtoRequest);

	@GetMapping(path = "/cliente/{idCliente}/pedido/{idPedido}")
	@ResponseStatus(value = HttpStatus.OK)
	List<ProdutoCarrinhoListResponse> buscaTodosProdutosCarrinho(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idPedido") UUID idPedido);
	
	@PostMapping(path = "/cliente/{idCliente}/pedido/{idPedido}/produto/{idPedidoCarrinho}/incrementaQuantidadeProdutoCarrinho")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void incrementaQuantidadeProdutoCarrinho(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idPedido") UUID idPedido, @PathVariable(value = "idPedidoCarrinho") UUID idPedidoCarrinho);

	
}
