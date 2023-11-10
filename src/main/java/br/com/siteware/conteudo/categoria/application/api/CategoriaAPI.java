package br.com.siteware.conteudo.categoria.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categoria")
public interface CategoriaAPI {
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	CategoriaIdResponse postCategoria(@RequestBody @Valid CategoriaRequest CategoriaRequest);

}
