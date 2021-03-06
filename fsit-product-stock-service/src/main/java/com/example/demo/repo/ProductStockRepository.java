package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProductStock;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long>{

	ProductStock findByProductNameAndProductAvailability(String productName,String productAvailability);
}
