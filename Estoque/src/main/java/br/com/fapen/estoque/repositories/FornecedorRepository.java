package br.com.fapen.estoque.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.estoque.models.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{
	List<Fornecedor> findByNomeEmpresaOrderByNomeEmpresaAsc(Integer id);
	
	public Fornecedor findByCnpj(String pCnpj);
	//public Page<Fornecedor> findByRazaoSocialContainingIgnoreCase(String nome, Pageable paginacao);
	public Page<Fornecedor> findByNomeEmpresa(String nome, Pageable paginacao);

}
