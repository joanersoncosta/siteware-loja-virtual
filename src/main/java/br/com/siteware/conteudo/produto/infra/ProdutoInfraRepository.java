package br.com.siteware.conteudo.produto.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.siteware.conteudo.handler.APIException;
import br.com.siteware.conteudo.produto.application.repository.ProdutoRepository;
import br.com.siteware.conteudo.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ProdutoInfraRepository implements ProdutoRepository {
	private final ProdutoSpringDataJPARepository produtoSpringDataJPARepository;
	
	@Override
	public Produto salvaProduto(Produto produto) {
		log.info("[inicia] ProdutoInfraRepository - salvaProduto");
		log.info("[inicia] CategoriaInfraRepository - salvaCategoria");
		try {
			produtoSpringDataJPARepository.save(produto);
		}catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Produto já cadastrada");
		}
		log.info("[finaliza] ProdutoInfraRepository - salvaProduto");
		return produto;
	}

	@Override
	public Optional<Produto> buscaProdutoPorId(UUID idProduto) {
		log.info("[inicia] ProdutoInfraRepository - buscaProdutoPorId");
		Optional<Produto> produto = produtoSpringDataJPARepository.findById(idProduto);
		log.info("[finaliza] ProdutoInfraRepository - buscaProdutoPorId");
		return produto;
	}

	@Override
	public List<Produto> buscaTodosProdutos() {
		log.info("[inicia] ProdutoInfraRepository - buscaTodosProdutos");
		List<Produto> produtos = produtoSpringDataJPARepository.findAll();
		log.info("[finaliza] ProdutoInfraRepository - buscaTodosProdutos");
		return produtos;
	}

	@Override
	public void deleteProdutoPorId(Produto produto) {
		log.info("[inicia] ProdutoInfraRepository - buscaTodosProdutos");
		produtoSpringDataJPARepository.delete(produto);
		log.info("[finaliza] ProdutoInfraRepository - buscaTodosProdutos");
	}

}
