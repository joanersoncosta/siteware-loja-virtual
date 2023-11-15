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
	
	@PostMapping(value = "/login")
	@ResponseStatus(value = HttpStatus.CREATED)
	ClienteIdResponse postCliente(@RequestBody @Valid ClienteRequest ClienteRequest);

	@GetMapping(value = "/busca-todos-clientes")
	@ResponseStatus(value = HttpStatus.OK)
	List<ClienteListResponse> getTodasClientes();
	
	@GetMapping(value = "/{idCliente}/busca-cliente")
	@ResponseStatus(value = HttpStatus.OK)
	ClienteDetalhadoResponse getBuscaClientePorId(@PathVariable(value = "idCliente") UUID idCliente);
	
	@DeleteMapping(value = "/{idCliente}/deleta-cliente")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void deletaClientePorId(@PathVariable(value = "idCliente") UUID idCliente);
	
	@PatchMapping(value = "/{idCliente}/altera-dados-cliente")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void patchAlteraCliente(@PathVariable(value = "idCliente") UUID idCliente, @RequestBody @Valid ClienteAlteracaoRequest clienteAlteracaoRequest);

}
