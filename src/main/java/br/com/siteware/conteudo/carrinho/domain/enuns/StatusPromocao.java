package br.com.siteware.conteudo.carrinho.domain.enuns;

public enum StatusPromocao {
	NENHUM, 
	LEVE_2_PAGUE_1(2), 
	LEVE_3_PAGUE_2(3);

	private int quantidade;
	
	private StatusPromocao(int quantidade) {
		this.quantidade = quantidade;
	}

	StatusPromocao() {
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public static StatusPromocao valueOf(int quantidade) {
		for (StatusPromocao valorCorrespondente: StatusPromocao.values()) {
			if(valorCorrespondente.getQuantidade() == quantidade) {
				return valorCorrespondente;
			}
		}
		return StatusPromocao.NENHUM;
	}
}
