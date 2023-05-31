package br.unipar.teste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.unipar.teste.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

	@Query
	public List<Marca> findByNomeContainingAllIgnoringCase(String nome);
	
}
