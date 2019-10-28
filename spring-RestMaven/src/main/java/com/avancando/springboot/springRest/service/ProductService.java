package com.avancando.springboot.springRest.service;

import java.util.List;
import java.util.Optional;

import com.avancando.springboot.springRest.models.Product;

public interface ProductService {
	public List<Product> findAll();
	public Optional<Product> findId(Long id);
	public Product create(Product product);
	public Product update(Long id, Product product);
	public void delete(Long id);
}
