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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/produto")
public interface ProdutoAPI {
	
	@PostMapping(path = "/cadastra-produto")
	@ResponseStatus(value = HttpStatus.CREATED)
	ProdutoIdResponse postProduto(@RequestParam(value = "idCategoria") UUID idCategoria, @RequestBody @Valid ProdutoRequest produtoRequest);

	@GetMapping(path = "/{idProduto}/busca-produto")
	@ResponseStatus(value = HttpStatus.OK)
	ProdutoDetalhadoResponse buscaProdutoPorId(@PathVariable(value = "idProduto") UUID idProduto);

	@GetMapping(path = "/busca-produtos")
	@ResponseStatus(value = HttpStatus.OK)
	List<ProdutoCategoriaListResponse> buscaTodosProdutos(@RequestParam(value = "idCategoria") UUID idCategoria);

	@DeleteMapping(path = "/{idProduto}/deleta-produto")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void deleteProdutoPorId(@RequestParam(value = "idCategoria") UUID idCategoria, @PathVariable(value = "idProduto") UUID idProduto);
	
	@PatchMapping(value = "/{idProduto}/aplica-promocao")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void alteraProduto(@RequestParam(value = "idCategoria") UUID idCategoria, @PathVariable(value = "idProduto") UUID idProduto, @RequestBody @Valid ProdutoAlteracaoRequest produtoAlteracaoRequest);

}
