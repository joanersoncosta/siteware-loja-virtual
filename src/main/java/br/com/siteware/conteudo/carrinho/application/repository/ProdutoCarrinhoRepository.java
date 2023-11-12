package br.com.siteware.conteudo.carrinho.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.siteware.conteudo.carrinho.domain.CarrinhoProduto;

public interface ProdutoCarrinhoRepository {
	CarrinhoProduto adicionaProdutoCarrinho(CarrinhoProduto carrinhoProduto);
	List<CarrinhoProduto> buscaTodosProdutosCarrinho();
	Optional<CarrinhoProduto> buscaProdutoPorId(UUID idPedidoCarrinho);

}
