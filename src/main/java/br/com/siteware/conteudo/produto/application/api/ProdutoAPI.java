package br.com.siteware.conteudo.produto.application.api;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.conteudo.pedido.application.api.PedidoAlteracaoRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/categoria/{idCategoria}")
public interface ProdutoAPI {
	
	@PostMapping(path = "/produto")
	@ResponseStatus(value = HttpStatus.CREATED)
	ProdutoIdResponse postProduto(@PathVariable(value = "idCategoria") UUID idCategoria, @RequestBody @Valid ProdutoRequest produtoRequest);

	@GetMapping(path = "/produto/{idProduto}")
	@ResponseStatus(value = HttpStatus.OK)
	ProdutoDetalhadoResponse buscaProdutoPorId(@PathVariable(value = "idCategoria") UUID idCategoria, @PathVariable(value = "idProduto") UUID idProduto);

	@GetMapping(path = "/produto")
	@ResponseStatus(value = HttpStatus.OK)
	List<ProdutoCategoriaListResponse> buscaTodosProdutos(@PathVariable(value = "idCategoria") UUID idCategoria);

	@DeleteMapping(path = "/produto/{idProduto}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void deleteProdutoPorId(@PathVariable(value = "idCategoria") UUID idCategoria, @PathVariable(value = "idProduto") UUID idProduto);
	
	@PatchMapping(value = "/produto/{idProduto}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void patchPedido(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idPedido") UUID idPedido, @PathVariable(value = "idProduto") UUID idProduto, @RequestBody @Valid ProdutoAlteracaoRequest produtoAlteracaoRequest);

}
