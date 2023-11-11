package br.com.siteware.conteudo.carrinho.application.repository;

import java.util.List;

import br.com.siteware.conteudo.carrinho.domain.CarrinhoProduto;

public interface ProdutoCarrinhoRepository {
	CarrinhoProduto adicionaProdutoCarrinho(CarrinhoProduto carrinhoProduto);
	List<CarrinhoProduto> buscaTodosProdutosCarrinho();

}
