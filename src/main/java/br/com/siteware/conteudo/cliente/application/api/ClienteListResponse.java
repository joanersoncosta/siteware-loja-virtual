package br.com.siteware.conteudo.cliente.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.siteware.conteudo.cliente.domain.Cliente;
import br.com.siteware.conteudo.cliente.domain.enuns.Sexo;
import lombok.Value;

@Value
public class ClienteListResponse {
	private UUID idCliente;
	private String nome;
	private String email;
	private String telefone;
	private Sexo sexo;
	private String dataNascimento;
	
	public ClienteListResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.sexo = cliente.getSexo();
		this.dataNascimento = cliente.getDataNascimento();
	}
	
	public static List<ClienteListResponse> converteListaClientes(List<Cliente> clientes){
		return clientes.stream().map(ClienteListResponse::new).collect(Collectors.toList());
	}
}
