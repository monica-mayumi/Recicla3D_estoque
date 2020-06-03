package br.com.fapen.estoque.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.estoque.models.MateriaPrima;

public interface MateriaPrimaRepository extends JpaRepository<MateriaPrima, Long> {

	public Page<MateriaPrima> findByDescricaoContainingIgnoreCase(String descricao, Pageable paginacao);

}
