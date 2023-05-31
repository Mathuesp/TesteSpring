package br.unipar.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.teste.model.Marca;
import br.unipar.teste.repositories.MarcaRepository;


@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;

	public Marca insert(Marca marca) throws Exception {
		
		validarInsercao(marca);
		
		marcaRepository.saveAndFlush(marca);
		
		return marca;
		
	}
	
	public Marca edit(Marca marca) throws Exception {
		
		validarEdicao(marca);
		
		marcaRepository.saveAndFlush(marca);
		
		return marca;
		
	}
	
	public List<Marca> findAll() {
		
		return marcaRepository.findAll();
			
	}
	
	public List<Marca> findByFilters(String nome) {
		
		return marcaRepository.findByNomeContainingAllIgnoringCase(nome);
			
	}
	
	public Marca findById(Long id) throws Exception {
	
		Optional<Marca> retorno = marcaRepository.findById(id);
		
		if (retorno.isPresent())
			return retorno.get();
		else 
			throw new Exception("Marca com Id "+id+" Não Identificada");
		
	}
	
	private void validarInsercao(Marca marca) throws Exception {
		
		if (marca.getId() != null) {
			throw new Exception("Para operação de inserção não deve se enviar o ID.");
		}
 		
		validarMarca(marca);
		
	}
	
	private void validarEdicao(Marca marca) throws Exception {
		
		if (marca.getId() == null) {
			throw new Exception("Para operação de edição deve se enviar o ID.");
		}
		
		findById(marca.getId());
 		
		validarMarca(marca);
		
	}
	
	private void validarMarca(Marca marca) throws Exception {
		
		if (marca.getNome() == null ||
			marca.getNome().isBlank() || 
			marca.getNome().isEmpty()) {
			throw new Exception("Descricao da Marca Não pode ser vazia");
		}
		
		if (marca.getNome().length() > 255) {
			throw new Exception("Tamanho da Descrição deve ser menor que 255 caracteres");
		}
		
	}
	
}
