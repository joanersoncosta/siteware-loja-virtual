package br.com.siteware.conteudo.carrinho.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siteware.conteudo.carrinho.domain.CarrinhoProduto;

public interface ProdutoCarrinhoSpringDataJPARepository extends JpaRepository<CarrinhoProduto, UUID>{

}
