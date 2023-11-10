package br.com.siteware.conteudo.produto.application.repository;

import java.util.Optional;
import java.util.UUID;

import br.com.siteware.conteudo.produto.domain.Produto;

public interface ProdutoRepository {
	Produto salvaProduto(Produto produto);
	Optional<Produto> buscaProdutoPorId(UUID idProduto);

}
