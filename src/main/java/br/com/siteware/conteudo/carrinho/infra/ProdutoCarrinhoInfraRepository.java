package br.com.siteware.conteudo.carrinho.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.siteware.conteudo.carrinho.application.repository.ProdutoCarrinhoRepository;
import br.com.siteware.conteudo.carrinho.domain.CarrinhoProduto;
import br.com.siteware.conteudo.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ProdutoCarrinhoInfraRepository implements ProdutoCarrinhoRepository {
	private final ProdutoCarrinhoSpringDataJPARepository produtoCarrinhoSpringDataJPARepository;
	
	@Override
	public CarrinhoProduto adicionaProdutoCarrinho(CarrinhoProduto carrinhoProduto) {
		log.info("[inicia] ProdutoCarrinhoInfraRepository - adicionaProdutoCarrinho");
		try {
			produtoCarrinhoSpringDataJPARepository.save(carrinhoProduto);
		}catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Produto já adicionado ao carrinho!");
		}
		log.info("[finaliza] ProdutoCarrinhoInfraRepository - adicionaProdutoCarrinho");
		return carrinhoProduto;
	}

}
