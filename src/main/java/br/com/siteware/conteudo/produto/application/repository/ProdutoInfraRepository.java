package br.com.siteware.conteudo.produto.application.repository;

import org.springframework.stereotype.Repository;

import br.com.siteware.conteudo.produto.domain.Produto;
import br.com.siteware.conteudo.produto.infra.ProdutoSpringDataJPARepository;
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

}
