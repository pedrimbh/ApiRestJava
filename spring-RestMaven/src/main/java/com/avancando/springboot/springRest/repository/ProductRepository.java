package com.avancando.springboot.springRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avancando.springboot.springRest.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
