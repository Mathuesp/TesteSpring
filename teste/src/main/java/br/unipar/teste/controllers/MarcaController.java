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

import br.unipar.teste.model.Marca;
import br.unipar.teste.model.dto.ExceptionDTO;
import br.unipar.teste.services.MarcaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/marca")
@Api(description = "Controlador Rest Responsavel pela Operações que representam o objeto de Negócios Marca")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;

	@PostMapping
	@ApiOperation("Operação Responsavel pela Inserção de uma Nova Marca no Sistema")
	public ResponseEntity<?> insert(@RequestBody Marca marca) {
		try {
			return ResponseEntity.ok(marcaService.insert(marca));
		} catch (Exception e) {
			ExceptionDTO dto = new ExceptionDTO(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
	}
	
	@PutMapping
	@ApiOperation("Operação Responsavel pela Edição de uma Marca existente no Sistema")
	public ResponseEntity<?> edit(@RequestBody Marca marca) {
		try {
			return ResponseEntity.ok(marcaService.edit(marca));
		} catch (Exception e) {
			ExceptionDTO dto = new ExceptionDTO(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
		
	}
	
	@GetMapping
	@ApiOperation("Operação Responsavel por retornar todas as Marcas existentes no Sistema")
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(marcaService.findAll());
		} catch (Exception e) {
			ExceptionDTO dto = new ExceptionDTO(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
		
		
	}
	
	@GetMapping(path = "/{id}")
	@ApiOperation("Operação Responsavel por retornar a Marca existentes no Sistema pelo id")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(marcaService.findById(id));
		} catch (Exception e) {
			ExceptionDTO dto = new ExceptionDTO(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
		
	}
	
	@GetMapping(path = "/filter")
	@ApiOperation("Operação Responsavel por retornar a Marca existentes no Sistema pelo nome")
	public ResponseEntity<?> findByFilters(@RequestParam("nome") String nome) {
		try {
			return ResponseEntity.ok(marcaService.findByFilters(nome));
		} catch (Exception e) {
			ExceptionDTO dto = new ExceptionDTO(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
		
		
	}
	
	
}
