package br.com.siteware.conteudo.categoria.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.siteware.conteudo.categoria.application.repository.CategoriaRepository;
import br.com.siteware.conteudo.categoria.domain.Categoria;
import br.com.siteware.conteudo.handler.APIException;
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
		try {
			categoriaSpringDataJPARepository.save(categoria);
		}catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Categoria já cadastrada");
		}
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

	@Override
	public Optional<Categoria> buscaCategoriaPorId(UUID idCategoria) {
		log.info("[inicia] CategoriaInfraRepository - buscaCategoriaPorId");
		Optional<Categoria> categoria = categoriaSpringDataJPARepository.findById(idCategoria);
		log.info("[finaliza] CategoriaInfraRepository - buscaCategoriaPorId");
		return categoria;
	}

	@Override
	public void deletaCategoriaPorId(Categoria categoria) {
		log.info("[inicia] CategoriaInfraRepository - deletaCategoriaPorId");
		categoriaSpringDataJPARepository.delete(categoria);
		log.info("[finaliza] CategoriaInfraRepository - deletaCategoriaPorId");
	}

}
