package br.com.siteware.conteudo.produto.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

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
		produtoSpringDataJPARepository.save(produto);
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

}
