package br.com.siteware.conteudo.cliente.application.api;

import java.time.LocalDate;

import br.com.siteware.conteudo.cliente.domain.enuns.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ClienteAlteracaoRequest {
	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;
	@NotNull
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
}
