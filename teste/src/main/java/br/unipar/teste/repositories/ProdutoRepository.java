package br.unipar.teste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.unipar.teste.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query
	public List<Produto> findByNomeContainingAllIgnoringCase(String nome);
}
