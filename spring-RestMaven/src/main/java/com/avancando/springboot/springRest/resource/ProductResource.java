package com.avancando.springboot.springRest.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avancando.springboot.springRest.models.Product;
import com.avancando.springboot.springRest.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	public ProductResource(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findAll(){
		List<Product> list = this.productService.findAll();
		return new ResponseEntity<List>(list, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findId(@PathVariable("id") Long id) {
		Optional<Product> find = this.productService.findId(id);
		return new ResponseEntity<Optional>(find, HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Product product, Errors erros) {
		if(!erros.hasErrors()) {
			Product productCreate = this.productService.create(product);
			return new ResponseEntity<Product>(productCreate, HttpStatus.CREATED);
		}
		return ResponseEntity.badRequest().body(erros.getAllErrors().stream().map(msng -> msng.getDefaultMessage()).collect(Collectors.joining(",")));
		
	}
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@Valid @PathVariable("id") Long id ,@RequestBody Product product, Errors erros) {
		if(!erros.hasErrors()) {
			Product productUpdate = this.productService.update(id,product);
			return new ResponseEntity<Product>(productUpdate, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().body(erros.getAllErrors().stream().map(msng -> msng.getDefaultMessage()).collect(Collectors.joining(",")));
		
	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void  delete(@PathVariable("id") Long id) {
		this.productService.delete(id);
	}
	
	
}
