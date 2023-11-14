package br.com.siteware.conteudo.carrinho.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carrinho-produto")
public interface ProdutoCarrinhoAPI {

	@PostMapping(path = "/adicionaProdutoCarrinho")
	@ResponseStatus(value = HttpStatus.CREATED)
	ProdutoCarrinhoIdResponse adicionaProdutoCarrinho(@RequestParam(value = "idCliente") UUID idCliente, @RequestParam(value = "idPedido") UUID idPedido, @RequestParam(value = "idProduto") UUID idProduto, @RequestBody @Valid ProdutoCarrinhoRequest produtoRequest);

	@GetMapping(path = "/buscaTodosProdutosCarrinho")
	@ResponseStatus(value = HttpStatus.OK)
	List<ProdutoCarrinhoListResponse> buscaTodosProdutosCarrinho(@RequestParam(value = "idCliente") UUID idCliente, @RequestParam(value = "idPedido") UUID idPedido);
	
	@PostMapping(path = "/{idPedidoCarrinho}/incrementaQuantidadeProdutoCarrinho")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void incrementaQuantidadeProdutoCarrinho(@RequestParam(value = "idCliente") UUID idCliente, @RequestParam(value = "idPedido") UUID idPedido, @PathVariable(value = "idPedidoCarrinho") UUID idPedidoCarrinho, @RequestBody @Valid ProdutoCarrinhoRequest produtoCarrinhoRequest);

	@DeleteMapping(path = "/{idPedidoCarrinho}/removeProdutoCarrinho")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void removeProdutoCarrinho(@RequestParam(value = "idCliente") UUID idCliente, @RequestParam(value = "idPedido") UUID idPedido, @PathVariable(value = "idPedidoCarrinho") UUID idPedidoCarrinhoprodutoCarrinhoRequest);

}
