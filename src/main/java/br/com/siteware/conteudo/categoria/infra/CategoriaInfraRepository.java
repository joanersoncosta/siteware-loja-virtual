package br.com.siteware.conteudo.categoria.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.siteware.conteudo.categoria.application.repository.CategoriaRepository;
import br.com.siteware.conteudo.categoria.domain.Categoria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class CategoriaInfraRepository implements CategoriaRepository {
	private final CategoriaSpringDataJPARepository categoriaSpringDataJPARepository;
	
	@Override
	public Categoria salvaCategoria(Categoria categoria) {
		log.info("[inicia] CategoriaInfraRepository - salvaCategoria");
		categoriaSpringDataJPARepository.save(categoria);
		log.info("[finaliza] CategoriaInfraRepository - salvaCategoria");
		return categoria;
	}

	@Override
	public List<Categoria> buscaTodasCategorias() {
		log.info("[inicia] CategoriaInfraRepository - buscaTodasCategorias");
		List<Categoria> categorias = categoriaSpringDataJPARepository.findAll();
		log.info("[finaliza] CategoriaInfraRepository - buscaTodasCategorias");
		return categorias;
	}

}
