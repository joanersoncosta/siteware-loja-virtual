package br.com.siteware.conteudo.cliente.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.siteware.conteudo.cliente.domain.enuns.Sexo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idCliente", updatable = false, unique = true, nullable = false)
	private UUID idCliente;
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotNull
	@Enumerated(value = EnumType.STRING)
	private Sexo sexo;
	@NotBlank
	private String telefone;
	
	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;
	
	public Cliente(@NotBlank String nome, @NotBlank @Email String email, @NotNull Sexo sexo,
			@NotBlank String telefone) {
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.telefone = telefone;
		this.momentoDoDacastro = LocalDateTime.now();
	}
}
