package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>{

	List<ProductModel> findAll();

	ProductModel findById(String productId);
	Optional<ProductModel> findById(Long productId);

	List<ProductModel> findAllByProductName(String productName);

	
	

}
