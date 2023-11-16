package br.com.siteware.conteudo.categoria.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siteware.conteudo.categoria.domain.Categoria;

public interface CategoriaSpringDataJPARepository extends JpaRepository<Categoria, UUID> {

}
