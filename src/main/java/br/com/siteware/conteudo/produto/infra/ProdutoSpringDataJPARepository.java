package br.com.siteware.conteudo.produto.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siteware.conteudo.produto.domain.Produto;

public interface ProdutoSpringDataJPARepository extends JpaRepository<Produto, UUID>{

}
