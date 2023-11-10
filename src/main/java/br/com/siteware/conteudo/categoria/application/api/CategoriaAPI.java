package br.com.siteware.conteudo.categoria.application.api;

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

import br.com.siteware.conteudo.cliente.application.api.ClienteDetalhadoResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/categoria")
public interface CategoriaAPI {
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	CategoriaIdResponse postCategoria(@RequestBody @Valid CategoriaRequest CategoriaRequest);

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<CategoriaListResponse> buscaTodasCategorias();

	@GetMapping(value = "/{idCategoria}")
	@ResponseStatus(value = HttpStatus.OK)
	CategoriaDetalhadoResponse getBuscaCategoriaPorId(@PathVariable(value = "idCategoria") UUID idCategoria);

}
