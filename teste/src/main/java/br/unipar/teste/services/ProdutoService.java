package br.unipar.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.teste.model.Produto;
import br.unipar.teste.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto insert(Produto produto) throws Exception {
		
		validarInsercao(produto);
		
		produtoRepository.saveAndFlush(produto);
		
		return produto;
		
	}
	
	public Produto edit(Produto produto) throws Exception {
		
		validarEdicao(produto);
		
		produtoRepository.saveAndFlush(produto);
		
		return produto;
		
	}
	
	public List<Produto> findAll() {
		
		return produtoRepository.findAll();
			
	}
	
	public List<Produto> findByFilters(String nome) {
		
		return produtoRepository.findByNomeContainingAllIgnoringCase(nome);
			
	}
	
	public Produto findById(Long id) throws Exception {
	
		Optional<Produto> retorno = produtoRepository.findById(id);
		
		if (retorno.isPresent())
			return retorno.get();
		else 
			throw new Exception("Produto com Id "+id+" Não Identificada");
		
	}
	
	private void validarInsercao(Produto produto) throws Exception {
		
		if (produto.getId() != null) {
			throw new Exception("Para operação de inserção não deve se enviar o ID.");
		}
 		
		validarProduto(produto);
		
	}
	
	private void validarEdicao(Produto produto) throws Exception {
		
		if (produto.getId() == null) {
			throw new Exception("Para operação de edição deve se enviar o ID.");
		}
		
		findById(produto.getId());
 		
		validarProduto(produto);
		
	}
	
	private void validarProduto(Produto produto) throws Exception {
		
		if (produto.getNome() == null ||
			produto.getNome().isBlank() || 
			produto.getNome().isEmpty()) {
			throw new Exception("Descricao da Marca Não pode ser vazia");
		}
		
		if (produto.getNome().length() > 255) {
			throw new Exception("Tamanho da Descrição deve ser menor que 255 caracteres");
		}
	}	
}