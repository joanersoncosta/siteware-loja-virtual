package br.com.siteware.conteudo.cliente.application.api;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	ClienteIdResponse postCliente(@RequestBody @Valid ClienteRequest ClienteRequest);

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<ClienteListResponse> getTodasClientes();
	
	@GetMapping(value = "/{idCliente}")
	@ResponseStatus(value = HttpStatus.OK)
	ClienteDetalhadoResponse getBuscaClientePorId(@PathVariable(value = "idCliente") UUID idCliente);
	
	@DeleteMapping(value = "/{idCliente}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void deletaClientePorId(@PathVariable(value = "idCliente") UUID idCliente);
	
	@PatchMapping(value = "/{idCliente}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void patchAlteraPessoa(@PathVariable(value = "idCliente") UUID idCliente, @RequestBody @Valid ClienteAlteracaoRequest clienteAlteracaoRequest);

}
