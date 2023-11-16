package br.com.siteware.conteudo.cliente.application.api;

import br.com.siteware.conteudo.cliente.domain.enuns.Sexo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ClienteRequest {
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	private String telefone;
	@NotNull
	private Sexo sexo;
	@NotNull
	private String dataNascimento;

}
