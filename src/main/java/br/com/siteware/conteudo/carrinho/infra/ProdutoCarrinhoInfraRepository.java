package br.com.siteware.conteudo.carrinho.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	public CarrinhoProduto salvaProdutoCarrinho(CarrinhoProduto carrinhoProduto) {
		log.info("[inicia] ProdutoCarrinhoInfraRepository - salvaProdutoCarrinho");
		try {
			produtoCarrinhoSpringDataJPARepository.save(carrinhoProduto);
		}catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Produto já adicionado ao carrinho!");
		}
		log.info("[finaliza] ProdutoCarrinhoInfraRepository - salvaProdutoCarrinho");
		return carrinhoProduto;
	}

	@Override
	public List<CarrinhoProduto> buscaTodosProdutosCarrinho() {
		log.info("[inicia] ProdutoCarrinhoInfraRepository - buscaTodosProdutosCarrinho");
		List<CarrinhoProduto> produtosCarrinho = produtoCarrinhoSpringDataJPARepository.findAll();
		log.info("[finaliza] ProdutoCarrinhoInfraRepository - buscaTodosProdutosCarrinho");
		return produtosCarrinho;
	}

	@Override
	public Optional<CarrinhoProduto> buscaProdutoPorId(UUID idPedidoCarrinho) {
		log.info("[inicia] ProdutoCarrinhoInfraRepository - buscaProdutoPorId");
		Optional<CarrinhoProduto> produto = produtoCarrinhoSpringDataJPARepository.findById(idPedidoCarrinho);
		log.info("[finaliza] ProdutoCarrinhoInfraRepository - buscaProdutoPorId");
		return produto;
	}

}
