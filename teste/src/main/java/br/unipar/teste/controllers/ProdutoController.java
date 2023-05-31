package br.unipar.teste.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unipar.teste.model.Produto;
import br.unipar.teste.model.dto.ExceptionDTO;
import br.unipar.teste.services.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/produto")
@Api(description = "Controlador Rest Responsavel pela Operações que representam o objeto de Negócios Produto")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;

	@PostMapping
	@ApiOperation("Operação Responsavel pela Inserção de um Novo Produto no Sistema")
	public ResponseEntity<?> insert(@RequestBody Produto produto) {
		try {
			return ResponseEntity.ok(produtoService.insert(produto));
		} catch (Exception e) {
			ExceptionDTO dto = new ExceptionDTO(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
	}
	
	@PutMapping
	@ApiOperation("Operação Responsavel pela Edição de um Produto existente no Sistema")
	public ResponseEntity<?> edit(@RequestBody Produto produto) {
		try {
			return ResponseEntity.ok(produtoService.edit(produto));
		} catch (Exception e) {
			ExceptionDTO dto = new ExceptionDTO(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
		
	}
	
	@GetMapping
	@ApiOperation("Operação Responsavel por retornar todos os Produtos existentes no Sistema")
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(produtoService.findAll());
		} catch (Exception e) {
			ExceptionDTO dto = new ExceptionDTO(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
		
		
	}
	
	@GetMapping(path = "/{id}")
	@ApiOperation("Operação Responsavel por retornar o Produto existente no Sistema pelo id")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(produtoService.findById(id));
		} catch (Exception e) {
			ExceptionDTO dto = new ExceptionDTO(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
		
	}
	
	@GetMapping(path = "/filter")
	@ApiOperation("Operação Responsavel por retornar os Produtos existentes no Sistema pelo nome")
	public ResponseEntity<?> findByFilters(@RequestParam("nome") String nome) {
		try {
			return ResponseEntity.ok(produtoService.findByFilters(nome));
		} catch (Exception e) {
			ExceptionDTO dto = new ExceptionDTO(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
		
		
	}
}
