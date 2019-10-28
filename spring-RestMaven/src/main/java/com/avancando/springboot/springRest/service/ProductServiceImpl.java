package com.avancando.springboot.springRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avancando.springboot.springRest.models.Product;
import com.avancando.springboot.springRest.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Optional<Product> findId(Long id) {
		return this.productRepository.findById(id);
	}

	@Override
	public Product create(Product product) {
		this.productRepository.save(product);
		return product;
	}

	@Override
	public Product update(Long id, Product product) {
		Optional<Product> productExist = this.productRepository.findById(id);
		if(productExist != null) {
			product.setId(product.getId());
//			product.setName(product.getName());
//			product.setQnt(product.getQnt());
//			product.setDateCreated(product.getDateCreated());
			this.productRepository.save(product);
			return product;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Optional<Product> product = this.productRepository.findById(id);
		if(product != null)this.productRepository.deleteById(id);
		
			
	}

}
